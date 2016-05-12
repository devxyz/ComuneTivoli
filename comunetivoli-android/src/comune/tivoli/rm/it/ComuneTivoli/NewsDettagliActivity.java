package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.db.DBHelperRunnable;
import comune.tivoli.rm.it.ComuneTivoli.db.DbHelper;
import comune.tivoli.rm.it.ComuneTivoli.db.dao.DaoSession;
import comune.tivoli.rm.it.ComuneTivoli.db.dao.NotizieSitoDbSqlLite;
import comune.tivoli.rm.it.ComuneTivoli.db.manager.ManagerNotizieSitoDbSqlLite;
import comune.tivoli.rm.it.ComuneTivoli.dialog.DialogUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.DateUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.IntentUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.WebViewUtil;

import java.util.Date;

/**
 * Created by millozzi.stefano on 26/04/2016.
 */
public class NewsDettagliActivity extends Activity {
    TextView news_titolo;
    TextView news_data;
    ImageButton news_button;
    WebView www;
    NewsDettagliActivityData dati;
    ProgressBar bar;


    //todo: gestire pagina html con webview - fixare colori - aggiugnere pulsante apri sul sito

    public static Intent prepareIntent(Activity a, String titolo, Date data, String descrizione, String html, String key) {
        NewsDettagliActivityData n = new NewsDettagliActivityData(titolo, descrizione, data, html, key);
        return n.toIntent(a);
    }
    //done:gestire dimensione testo articolo (precedente versione funzionava)

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TemplateUtil.inizializzaActivity(this, "*" + "Notizie", R.layout.newsdettagli_activity, R.layout.newsdettagli_activity_decorated);
        news_titolo = (TextView) findViewById(R.id.news_titolo);
        news_data = (TextView) findViewById(R.id.news_data);
        www = (WebView) findViewById(R.id.news_html);
        bar = (ProgressBar) findViewById(R.id.news_progress);
        news_button = (ImageButton) findViewById(R.id.news_btn);

        dati = new NewsDettagliActivityData(savedInstanceState, getIntent());

        news_titolo.setText(dati.titolo);
        www.loadData(dati.html, "text/html", "UTF8");
        news_data.setText(DateUtil.toDDMMYYY(dati.data));

        www.getSettings().setBuiltInZoomControls(true);
        www.getSettings().setSupportZoom(true);
        www.getSettings().setJavaScriptEnabled(true);

        www.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        www.getSettings().setLoadWithOverviewMode(true);
        www.getSettings().setUseWideViewPort(true);

        news_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DbHelper db = new DbHelper(NewsDettagliActivity.this);
                try {

                    db.runInTransaction(new DBHelperRunnable() {
                        @Override
                        public void run(DaoSession session, Context ctx) throws Throwable {
                            ManagerNotizieSitoDbSqlLite m = new ManagerNotizieSitoDbSqlLite();
                            final NotizieSitoDbSqlLite x = m.listByKey(session, dati.key);
                            if (!x.getFlagContenutoLetto()) {
                                x.setFlagContenutoLetto(true);
                            }

                            String msg = "NotizieSitoDbSqlLite{" +
                                    "id=" + x.getId() +
                                    "\ndataInserimento=" + x.getDataInserimento() +
                                    "\ndata=" + x.getData() +
                                    "\ntitolo='" + x.getTitolo() + '\'' +


                                    "\ntoken=" + x.getToken() +
                                    "\nversion=" + x.getVersion() +
                                    "\nurl='" + x.getUrl() + '\'' +
                                    "\nflagContenutoLetto=" + x.getFlagContenutoLetto() +
                                    "\nkey='" + x.getKey() + '\'' +
                                    '}';

                            DialogUtil.openInfoDialog(NewsDettagliActivity.this, "Informazioni", msg);
                        }
                    });


                } catch (Throwable throwable) {

                } finally {
                    db.close();
                }
            }
        });

        //dimensiona il testo
        www.getSettings().setTextZoom(300);

        WebViewUtil.webViewProgressBarLoader(www, bar);

    }


    @Override
    public void finish() {
        ViewGroup view = (ViewGroup) getWindow().getDecorView();
        view.removeAllViews();
        super.finish();
    }


    public static class NewsDettagliActivityData {
        private static final String LABEL_KEY = "key";
        private static final String LABEL_TITOLO = "titolo";
        private static final String LABEL_DATA = "data";
        private static final String LABEL_DESCRIZIONE = "descrizione";
        private static final String LABEL_HTML = "html";
        final String titolo, descrizione, html, key;
        final Date data;

        public NewsDettagliActivityData(Bundle savedInstanceState, Intent i) {
            titolo = IntentUtil.getExtraString(i, savedInstanceState, LABEL_TITOLO, "");
            key = IntentUtil.getExtraString(i, savedInstanceState, LABEL_KEY, "");
            descrizione = IntentUtil.getExtraString(i, savedInstanceState, LABEL_DESCRIZIONE, "");
            html = IntentUtil.getExtraString(i, savedInstanceState, LABEL_HTML, "");
            data = new Date(IntentUtil.getExtraLong(i, savedInstanceState, LABEL_DATA, 0));
        }

        public NewsDettagliActivityData(String titolo, String descrizione, Date data, String html, String key) {
            this.titolo = titolo;
            this.descrizione = descrizione;
            this.data = data;
            this.html = html;
            this.key = key;
        }

        public void saveTo(Bundle b) {
            b.putString(LABEL_KEY, key);
            b.putString(LABEL_TITOLO, titolo);
            b.putString(LABEL_DESCRIZIONE, descrizione);
            b.putString(LABEL_HTML, html);
            b.putLong(LABEL_DATA, data == null ? 0 : data.getTime());
        }

        public Intent toIntent(Activity a) {
            Bundle b = new Bundle();
            saveTo(b);

            Intent i = new Intent(a, NewsDettagliActivity.class);
            i.putExtras(b);
            return i;
        }
    }
}