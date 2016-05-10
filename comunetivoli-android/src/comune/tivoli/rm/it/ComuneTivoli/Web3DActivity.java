package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.dialog.DialogUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.IntentUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

/**
 * fatto: rimuovere pulsante per link esterno, sostituirlo con pressione sul titolo
 * done: aggiungere progress bar di caricamento
 * todo: gestire progress caricamento (si blocca con visite 3d)
 */
public class Web3DActivity extends Activity {
    TextView label_titolo;
    ImageButton web_btn_external_open;
    WebView www;
    Web3dActivityData dati;

    public static Intent prepare(Activity call, String url, String titolo, String titoloMenu) {
        Web3dActivityData dati = new Web3dActivityData(url, titolo, titoloMenu);
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

        dati = new Web3dActivityData(savedInstanceState, getIntent());
        TemplateUtil.inizializzaActivity(this,"*"+ dati.menu, R.layout.web3d_activity, R.layout.web3d_activity_decorated);

        label_titolo = (TextView) findViewById(R.id.web_titolo);
        www = (WebView) findViewById(R.id.web_www);
        web_btn_external_open = (ImageButton) findViewById(R.id.web_btn_external_open);
        label_titolo.setText(dati.titolo);

        //www.getSettings().setDisplayZoomControls(true);
/*        www.getSettings().setBuiltInZoomControls(true);
        www.getSettings().setSupportZoom(true);
        www.getSettings().setJavaScriptEnabled(true);
        www.getSettings().setSupportZoom(true);
        www.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        www.getSettings().setLoadWithOverviewMode(true);
        www.getSettings().setUseWideViewPort(true);*/

        www.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

        });


        www.loadUrl(dati.url);

        web_btn_external_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtil.openChooseDialog(Web3DActivity.this, "Scegli l'opzione",
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
                                        DialogUtil.openInfoDialog(Web3DActivity.this,
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
        });

    }

    private static class Web3dActivityData {
        public static final String LABEL_URL = "url";
        public static final String LABEL_TITOLO = "titolo";
        public static final String LABEL_MENU = "menu";
        final String url;
        final String titolo;
        final String menu;

        public Web3dActivityData(Bundle savedInstanceState, Intent i) {
            url = IntentUtil.getExtraString(i, savedInstanceState, LABEL_URL, null);
            titolo = IntentUtil.getExtraString(i, savedInstanceState, LABEL_TITOLO, null);
            menu = IntentUtil.getExtraString(i, savedInstanceState, LABEL_MENU, null);
        }

        public Web3dActivityData(String url, String titolo, String menu) {

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

            Intent i = new Intent(a, Web3DActivity.class);
            i.putExtras(b);
            return i;

        }

    }
}