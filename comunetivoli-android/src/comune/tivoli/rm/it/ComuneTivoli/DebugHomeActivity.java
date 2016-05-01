package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import comune.tivoli.rm.it.ComuneTivoli.dialog.DialogUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

/**
 * Created by millozzi.stefano on 15/03/2016.
 */


public class DebugHomeActivity extends Activity {

    Button btn_news;
    Button btn_contatti;
    Button btn_eventi;
    Button btn_web;
    Button btn_turismo;
    Button btn_fb_;
    Button btn_crediti;
    Button btn_home;
    Button btn_chiudi;
    Button btn_abilita_dec;
    Button btn_disabilita_dec;

    Button btnscroll;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.debug_home_activity);
        btn_news = (Button) findViewById(R.id.btn_news);
        btn_disabilita_dec = (Button) findViewById(R.id.btn_disabilit_decor);
        btn_chiudi = (Button) findViewById(R.id.btn_chiudi);
        btn_abilita_dec = (Button) findViewById(R.id.btn_abilita_dec);
        btn_contatti = (Button) findViewById(R.id.btn_contatti);
        btn_eventi = (Button) findViewById(R.id.btn_eventi);
        btn_web = (Button) findViewById(R.id.btn_www);
        btn_turismo = (Button) findViewById(R.id.btn_turismo);
        btn_fb_ = (Button) findViewById(R.id.btn_fb);
        btn_crediti = (Button) findViewById(R.id.btn_crediti);
        btn_home = (Button) findViewById(R.id.btn_home);

        btn_disabilita_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TemplateUtil.ENABLE_LAYOUT_DECORATED = false;
                DialogUtil.openInfoDialog(DebugHomeActivity.this, "Info", "Layout decorato DISABILITATO per le activity future");
            }
        });

        btn_abilita_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TemplateUtil.ENABLE_LAYOUT_DECORATED = true;
                DialogUtil.openInfoDialog(DebugHomeActivity.this, "Info", "Layout decorato ABILITATO per le activity future");

            }
        });

        btn_chiudi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnscroll = (Button) findViewById(R.id.btnscroll);
        btnscroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DebugHomeActivity.this, ImageScrollActivity.class);
                startActivity(i);
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DebugHomeActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });
        btn_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DebugHomeActivity.this, TemplateActivity.class);
                startActivity(i);


            }
        });
        btn_contatti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DebugHomeActivity.this, ContattiActivity.class);
                startActivity(i);
            }
        });

        btn_eventi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DebugHomeActivity.this, EventiActivity.class);
                startActivity(i);
            }
        });

        btn_turismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DebugHomeActivity.this, MonumentiActivity.class);
                startActivity(i);
            }
        });

        btn_fb_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DebugHomeActivity.this, FacebookActivity.class);
                startActivity(i);
            }
        });

        btn_crediti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DebugHomeActivity.this, CreditiActivity.class);
                startActivity(i);
            }
        });
        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.comune.tivoli.rm.it/node";
                /*Uri uriUrl = Uri.parse(url);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);*/
                final Intent i = WebActivity.prepare(DebugHomeActivity.this, url, "Comune di tivoli", "WEB");
                startActivity(i);
            }
        });

    }


}


