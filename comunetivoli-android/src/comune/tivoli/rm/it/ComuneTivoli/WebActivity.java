package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.dialog.DialogUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.IntentUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

/**
 * fatto: rimuovere pulsante per link esterno, sostituirlo con pressione sul titolo
 * todo: aggiungere progress bar di caricamento
 */
public class WebActivity extends Activity {
    TextView label_titolo;
    ImageButton web_btn_external_open;
    WebView www;
    WebActivityData dati;
    ProgressDialog prDialog;

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
        label_titolo.setText(dati.titolo);

        //www.getSettings().setDisplayZoomControls(true);
        www.getSettings().setBuiltInZoomControls(true);
        www.getSettings().setSupportZoom(true);
        www.getSettings().setJavaScriptEnabled(true);
        www.getSettings().setSupportZoom(true);
        www.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        www.getSettings().setLoadWithOverviewMode(true);
        www.getSettings().setUseWideViewPort(true);
        www.setWebChromeClient(
                new WebChromeClient() {
                    public void onProgressChanged(WebView view, int progress) {
                        if (prDialog == null) {
                            prDialog = new ProgressDialog(WebActivity.this);
                            prDialog.setMessage("Caricamento in corso ...");
                            prDialog.setIndeterminate(false);
                            prDialog.show();
                        }

                        prDialog.setProgress(progress);
                    }
                }
        );

        www.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (prDialog == null) {
                    prDialog = new ProgressDialog(WebActivity.this);
                    prDialog.setMessage("Caricamento in corso ...");
                    prDialog.setIndeterminate(true);
                    prDialog.show();
                }
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (prDialog != null) {
                    prDialog.dismiss();
                    prDialog = null;
                }
            }
        });


        www.loadUrl(dati.url);

        web_btn_external_open.setOnClickListener(new View.OnClickListener() {
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
        });

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