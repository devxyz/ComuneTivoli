package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.guicomponents.DialogUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.IntentUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.WebViewUtil;

/**
 * fatto: rimuovere pulsante per link esterno, sostituirlo con pressione sul titolo
 * done: aggiungere progress bar di caricamento
 * done: gestire progress caricamento (si blocca con visite 3d) - NON USARE SETTING DELLA CACHE PER EVITARE IL BLOCCO!!!!
 */
// TODO: 10/05/16 - verifica correttezza OK
public class WebActivity extends Activity {
    TextView label_titolo;
    ImageButton web_btn_external_open;
    WebView www;
    WebActivityData dati;
    ProgressBar bar;

    public static Intent prepare(Activity call, String url, String titolo, String titoloMenu) {
        WebActivityData dati = new WebActivityData(url, titolo, titoloMenu);
        return dati.toIntent(call);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        dati.saveTo(outState);
    }

    @Override
    public void finish() {
        ViewGroup view = (ViewGroup) getWindow().getDecorView();
        view.removeAllViews();
        super.finish();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dati = new WebActivityData(savedInstanceState, getIntent());
        TemplateUtil.inizializzaActivity(this, dati.menu, R.layout.web_activity, R.layout.web_activity_decorated);

        label_titolo = (TextView) findViewById(R.id.web_titolo);
        www = (WebView) findViewById(R.id.web_www);
        web_btn_external_open = (ImageButton) findViewById(R.id.web_btn_external_open);
        bar = (ProgressBar) findViewById(R.id.web_progressbar);


        label_titolo.setText(dati.titolo);

        //www.getSettings().setDisplayZoomControls(true);
        www.getSettings().setBuiltInZoomControls(true);
        www.getSettings().setSupportZoom(true);
        www.getSettings().setJavaScriptEnabled(true);
        www.getSettings().setSupportZoom(true);

        //www.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);//DONE: NO SE si vuole accedere alle pagine 3d di tivoli

        www.getSettings().setLoadWithOverviewMode(true);

        //www.getSettings().setUseWideViewPort(true);
        WebViewUtil.webViewProgressBarLoader(www, bar);

        www.loadUrl(dati.url);

        final View.OnClickListener informazioni = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtil.openChooseDialog(WebActivity.this, "Scegli l'opzione",
                        new CharSequence[]{"Apri sul browser esterno", "Informazioni", "Annulla"},
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        Intent web;
                                        web = new Intent(Intent.ACTION_VIEW);
                                        web.setData(Uri.parse(dati.url));
                                        startActivity(web);
                                        break;
                                    case 1:
                                        DialogUtil.openInfoDialog(WebActivity.this,
                                                "Informazioni",
                                                dati.titolo + "\n" + "URK:" + dati.url);
                                        break;
                                    default:
                                        dialog.dismiss();
                                        break;
                                }
                            }
                        }, null);
            }
        };
        web_btn_external_open.setOnClickListener(informazioni);
        label_titolo.setOnClickListener(informazioni);

    }

    private static class WebActivityData {
        public static final String LABEL_URL = "url";
        public static final String LABEL_TITOLO = "titolo";
        public static final String LABEL_MENU = "menu";
        final String url;
        final String titolo;
        final String menu;

        public WebActivityData(Bundle savedInstanceState, Intent i) {
            url = IntentUtil.getExtraString(i, savedInstanceState, LABEL_URL, null);
            titolo = IntentUtil.getExtraString(i, savedInstanceState, LABEL_TITOLO, null);
            menu = IntentUtil.getExtraString(i, savedInstanceState, LABEL_MENU, null);
        }

        public WebActivityData(String url, String titolo, String menu) {

            this.url = url;
            this.titolo = titolo;
            this.menu = menu;
        }

        public void saveTo(Bundle outState) {
            outState.putString(LABEL_URL, url);
            outState.putString(LABEL_TITOLO, titolo);
            outState.putString(LABEL_MENU, menu);
        }

        public Intent toIntent(Activity a) {

            Bundle b = new Bundle();
            saveTo(b);

            Intent i = new Intent(a, WebActivity.class);
            i.putExtras(b);
            return i;

        }

    }
}