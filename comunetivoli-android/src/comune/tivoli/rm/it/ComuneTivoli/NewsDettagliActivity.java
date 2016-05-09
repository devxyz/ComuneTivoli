package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.util.DateUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.IntentUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

import java.util.Date;

/**
 * Created by millozzi.stefano on 26/04/2016.
 */
public class NewsDettagliActivity extends Activity {
    TextView news_titolo;
    TextView news_data;
    WebView www;
    NewsDettagliActivityData dati;

    ProgressDialog prDialog;
    //todo: gestire pagina html con webview - fixare colori - aggiugnere pulsante apri sul sito

    public static Intent prepareIntent(Activity a, String titolo, Date data, String descrizione, String html) {
        NewsDettagliActivityData n = new NewsDettagliActivityData(titolo, descrizione, data, html);
        return n.toIntent(a);
    }
    //todo:gestire dimensione testo articolo (precedente versione funzionava)

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TemplateUtil.inizializzaActivity(this, "Notizie", R.layout.newsdettagli_activity, R.layout.newsdettagli_activity_decorated);
        news_titolo = (TextView) findViewById(R.id.news_titolo);
        news_data = (TextView) findViewById(R.id.news_data);
        www = (WebView) findViewById(R.id.news_html);

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

        //dimensiona il testo
        www.getSettings().setTextZoom(300);

        www.setWebChromeClient(
                new WebChromeClient() {
                    public void onProgressChanged(WebView view, int progress) {
                        if (prDialog == null) {
                            prDialog = new ProgressDialog(NewsDettagliActivity.this);
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
                    prDialog = new ProgressDialog(NewsDettagliActivity.this);
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


    }


    @Override
    public void finish() {
        ViewGroup view = (ViewGroup) getWindow().getDecorView();
        view.removeAllViews();
        super.finish();
    }


    public static class NewsDettagliActivityData {
        private static final String LABEL_TITOLO = "titolo";
        private static final String LABEL_DATA = "data";
        private static final String LABEL_DESCRIZIONE = "descrizione";
        private static final String LABEL_HTML = "html";
        String titolo, descrizione, html;
        Date data;

        public NewsDettagliActivityData(Bundle savedInstanceState, Intent i) {
            titolo = IntentUtil.getExtraString(i, savedInstanceState, LABEL_TITOLO, "");
            descrizione = IntentUtil.getExtraString(i, savedInstanceState, LABEL_DESCRIZIONE, "");
            html = IntentUtil.getExtraString(i, savedInstanceState, LABEL_HTML, "");
            data = new Date(IntentUtil.getExtraLong(i, savedInstanceState, LABEL_DATA, 0));
        }

        public NewsDettagliActivityData(String titolo, String descrizione, Date data, String html) {
            this.titolo = titolo;
            this.descrizione = descrizione;
            this.data = data;
            this.html = html;
        }

        public void saveTo(Bundle b) {

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