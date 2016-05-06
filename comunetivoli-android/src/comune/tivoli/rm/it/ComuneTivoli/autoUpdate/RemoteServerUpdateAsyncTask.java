package comune.tivoli.rm.it.ComuneTivoli.autoUpdate;

import android.content.Context;
import android.os.AsyncTask;
import com.google.gson.Gson;
import comune.tivoli.rm.it.ComuneTivoli.LoadingActivity;
import comune.tivoli.rm.it.ComuneTivoli.R;
import comune.tivoli.rm.it.ComuneTivoli.db.DBHelperRunnable;
import comune.tivoli.rm.it.ComuneTivoli.db.DbHelper;
import comune.tivoli.rm.it.ComuneTivoli.db.dao.DaoSession;
import comune.tivoli.rm.it.ComuneTivoli.db.manager.ManagerNotizieSitoDbSqlLite;
import comune.tivoli.rm.it.ComuneTivoli.util.StreamAndroidUtil;
import comune.tivoli.rm.it.ComuneTivoliCommon.data.CommonDataServerRequest;
import comune.tivoli.rm.it.ComuneTivoliCommon.data.CommonDataServerResponse;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by stefano on 06/05/16.
 */
public class RemoteServerUpdateAsyncTask extends AsyncTask<Void, String, Void> {
    private final LoadingActivity activity;
    private final boolean DEBUG = true;
    /**
     * eventuale errore
     */
    private Throwable errore;

    public RemoteServerUpdateAsyncTask(LoadingActivity activity) {
        this.activity = activity;
    }

    @Override
    protected Void doInBackground(Void... params) {

        if (isCancelled()) return null;

        //prepara request
        //-------------------------------------------
        publishProgress("Accesso al database dei dati");
        final CommonDataServerRequest req1 = new CommonDataServerRequest();
        {
            final DbHelper db = new DbHelper(activity);
            try {
                db.runInTransaction(new DBHelperRunnable() {
                    @Override
                    public void run(DaoSession session, Context ctx) throws Throwable {
                        ManagerNotizieSitoDbSqlLite m = new ManagerNotizieSitoDbSqlLite();
                        req1.responseInZipFormat = true;
                        req1.maxClientToken = m.maxToken(session);
                    }
                });

            } catch (Throwable throwable) {
                throwable.printStackTrace();
            } finally {
                db.close();
            }
        }
        if (isCancelled()) return null;

        //analizza la risposta
        //-------------------------------------------
        final String json = new Gson().toJson(req1);

        publishProgress("Connessione al server");
        //effettua chiamata post
        //---------------------------------------------
        String url = activity.getResources().getString(R.string.url_server_data_servlet);
        HttpURLConnection con = null;
        try {
            if (isCancelled()) return null;
            URL obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();

            //add reuqest header
            con.setRequestMethod("POST");

            String urlParameters = "param=" + URLEncoder.encode(json, "UTF-8");
            publishProgress("Invio richiesta");

            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();
            if (isCancelled()) return null;
            //attede la risposta
            //---------------------------------------------
            int responseCode = con.getResponseCode();
            if (DEBUG) {
                System.out.println("\nSending 'POST' request to URL : " + url);
                System.out.println("Post parameters : " + urlParameters);
                System.out.println("Response Code : " + responseCode);
            }

            //legge la risposta
            //---------------------------------------------
            publishProgress("Elaborazione della risposta");
            Gson g = new Gson();
            ZipInputStream in = new ZipInputStream(new BufferedInputStream(con.getInputStream()));
            final ZipEntry nextEntry = in.getNextEntry();

            final String content = StreamAndroidUtil.loadFileContent(in);
            in.close();
            if (isCancelled()) return null;
            final CommonDataServerResponse resp = g.fromJson(content, CommonDataServerResponse.class);
            publishProgress(resp.notizie.size() + " nuove notizie");
            publishProgress("Salvataggio dati");
            {
                if (isCancelled()) return null;
                final DbHelper db = new DbHelper(activity);
                try {
                    db.runInTransaction(new DBHelperRunnable() {
                        @Override
                        public void run(DaoSession session, Context ctx) throws Throwable {
                            ManagerNotizieSitoDbSqlLite m = new ManagerNotizieSitoDbSqlLite();
                            m.insertFromServer(session, resp.notizie);
                        }
                    });

                } finally {
                    db.close();
                }
            }
            if (isCancelled()) return null;

        } catch (Throwable e) {
            errore = e;
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //se cancellato, nulla
        if (isCancelled()) return;

        if (errore == null)
            activity.startApplicationOnSuccess();
        else
            activity.startApplicationOnError(errore);
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        for (String value : values) {
            activity.updateMessage(value);
        }

    }

    @Override
    protected void onCancelled(Void aVoid) {
        super.onCancelled(aVoid);
        activity.startApplicationOnSuccess();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        activity.startApplicationOnSuccess();
    }
}
