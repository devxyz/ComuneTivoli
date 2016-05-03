package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

/**
 * todo: rimuovere pulsante per link esterno, sostituirlo con pressione sul titolo
 */
public class WebActivity extends Activity {
    TextView label_titolo;
    ImageButton web_btn_external_open;
    WebView www;

    public static Intent prepare(Activity call, String url, String titolo, String titoloMenu) {
        Intent i = new Intent(call, WebActivity.class);
        i.putExtra("url", url);
        i.putExtra("titolo", titolo);
        i.putExtra("menu", titoloMenu);
        return i;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String url = getIntent().getExtras().getString("url");
        String titolo = getIntent().getExtras().getString("titolo");
        String menu = getIntent().getExtras().getString("menu");
        if (menu == null)
            menu = "Web";

        TemplateUtil.inizializzaActivity(this, menu, R.layout.web_activity, R.layout.web_activity_decorated);

        label_titolo = (TextView) findViewById(R.id.web_titolo);
        www = (WebView) findViewById(R.id.web_www);
        web_btn_external_open = (ImageButton) findViewById(R.id.web_btn_external_open);
        label_titolo.setText(titolo);

        //www.getSettings().setDisplayZoomControls(true);
        www.getSettings().setBuiltInZoomControls(true);
        www.getSettings().setSupportZoom(true);
        www.getSettings().setJavaScriptEnabled(true);
        www.getSettings().setLoadWithOverviewMode(true);
        www.getSettings().setUseWideViewPort(true);
        www.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });


        www.loadUrl(url);

        web_btn_external_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web;
                web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse("http://www.comune.tivoli.rm.it/node"));
                startActivity(web);
            }
        });
    }
}