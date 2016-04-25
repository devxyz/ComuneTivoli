package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

/**
 * Created by millozzi.stefano on 19/04/2016.
 */
public class HomeActivity extends Activity {
    ImageButton btn_turismo;
    ImageButton btn_eventi;
    ImageButton btn_news;
    ImageButton btn_fb;
    ImageButton btn_web;
    ImageButton btn_contatti;
    ImageButton btn_about_us;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home_activity_decorated);
        TemplateUtil.inizializzaComponentiTemplate(this, "Home");


        btn_turismo = (ImageButton) findViewById(R.id.home_btn_turismo);
        btn_eventi = (ImageButton) findViewById(R.id.home_btn_eventi);
        btn_news = (ImageButton) findViewById(R.id.home_btn_news);
        btn_about_us = (ImageButton) findViewById(R.id.home_about_us);
        btn_fb = (ImageButton) findViewById(R.id.home_btn_fb);
        btn_web = (ImageButton) findViewById(R.id.home_btn_web);
        btn_contatti = (ImageButton) findViewById(R.id.home_btn_contatti);
        btn_turismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent turismo;
                turismo = new Intent(HomeActivity.this, TurismoActivity.class);
                startActivity(turismo);

            }
        });
        btn_eventi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eventi;
                eventi = new Intent(HomeActivity.this, EventiActivity.class);
                startActivity(eventi);

            }
        });
        btn_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent news;
                news = new Intent(HomeActivity.this, NewsActivity.class);
                startActivity(news);

            }
        });
        btn_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fb;
                fb = new Intent(HomeActivity.this, FacebookActivity.class);
                startActivity(fb);

            }
        });
        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web;
                web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse("http://www.comune.tivoli.rm.it/node"));
                startActivity(web);
            }
        });
        btn_contatti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contatti;
                contatti = new Intent(HomeActivity.this, ContattiActivity.class);
                startActivity(contatti);

            }
        });
        btn_about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutus;
                aboutus = new Intent(HomeActivity.this, CreditiActivity.class);
                startActivity(aboutus);

            }
        });
    }
}