package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.autoUpdate.RemoteServerUpdateAsyncTask;
import comune.tivoli.rm.it.ComuneTivoli.dialog.DialogUtil;

/**
 * todo: nei telefonini con android 4.3 non si vede lo sfondo...
 */
public class LoadingActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    ImageView loading_image;
    TextView loading_details;
    TextView loading_txt;

    private boolean close = false;

    public void updateMessage(String message) {
        loading_details.append(message);
        loading_details.append("\n");
    }

    /**
     * avvia l'applicazione
     */
    public void startApplicationOnSuccess() {
        if (close) return;
        _closeActivityAndOpenMenu();
    }

    private void _closeActivityAndOpenMenu() {
        Intent i = new Intent(LoadingActivity.this, HomeActivity.class);
        startActivity(i);
        finish();
    }

    /**
     * avvia l'applicazione
     */
    public void startApplicationOnError(Throwable ex) {
        if (close) return;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                _closeActivityAndOpenMenu();
            }
        };
        DialogUtil.openErrorDialog(this, "Errore", "Errore durante il caricamento dei dati", ex, r);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);

        loading_details = (TextView) findViewById(R.id.loading_details);
        loading_txt = (TextView) findViewById(R.id.loading_txt);

        final RemoteServerUpdateAsyncTask task = new RemoteServerUpdateAsyncTask(this);
        //task.execute();

        final View.OnClickListener l = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Runnable yes = new Runnable() {
                    @Override
                    public void run() {
                        task.cancel(true);
                        _closeActivityAndOpenMenu();
                    }
                };
                final Runnable no = new Runnable() {
                    @Override
                    public void run() {

                    }
                };
                DialogUtil.openAskDialog(LoadingActivity.this, "Interruzione", "Vuoi annullare l'aggiornamento?", yes, no);
            }
        };

        loading_image = (ImageView) findViewById(R.id.loading_image);
        loading_image.setOnClickListener(l);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        close = true;
    }
}
