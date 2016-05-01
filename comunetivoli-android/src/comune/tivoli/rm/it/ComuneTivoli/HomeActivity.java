package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

/**
 * Created by millozzi.stefano on 19/04/2016.
 */
public class HomeActivity extends Activity {
    protected RelativeLayout xyz;
    protected TextView home_turismo;
    protected TextView home_eventi;
    protected ImageButton home_btn_turismo;
    protected ImageButton home_btn_eventi;
    protected TextView home_news;
    protected ImageButton home_btn_news;
    protected TextView home_facebook;
    protected ImageButton home_btn_fb;
    protected ImageButton home_btn_web;
    protected TextView home_web;
    protected TextView home_contatti;
    protected ImageButton home_btn_contatti;
    protected TextView home_aboutus;
    protected ImageButton home_btn_aboutus;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TemplateUtil.inizializzaActivity(this, "Home", R.layout.home_activity_decorated, R.layout.home_activity_decorated);


        Activity view = this;
        xyz = (RelativeLayout) view.findViewById(R.id.xyz);
        home_turismo = (TextView) view.findViewById(R.id.home_turismo);
        home_eventi = (TextView) view.findViewById(R.id.home_eventi);
        home_btn_turismo = (ImageButton) view.findViewById(R.id.home_btn_turismo);
        home_btn_eventi = (ImageButton) view.findViewById(R.id.home_btn_eventi);
        home_news = (TextView) view.findViewById(R.id.home_news);
        home_btn_news = (ImageButton) view.findViewById(R.id.home_btn_news);
        home_facebook = (TextView) view.findViewById(R.id.home_facebook);
        home_btn_fb = (ImageButton) view.findViewById(R.id.home_btn_fb);
        home_btn_web = (ImageButton) view.findViewById(R.id.home_btn_web);
        home_web = (TextView) view.findViewById(R.id.home_web);
        home_contatti = (TextView) view.findViewById(R.id.home_contatti);
        home_btn_contatti = (ImageButton) view.findViewById(R.id.home_btn_contatti);
        home_aboutus = (TextView) view.findViewById(R.id.home_aboutus);
        home_btn_aboutus = (ImageButton) view.findViewById(R.id.home_btn_aboutus);


        home_btn_turismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent turismo;
                turismo = new Intent(HomeActivity.this, TurismoActivity.class);
                startActivity(turismo);

            }
        });
        home_turismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_btn_turismo.callOnClick();
            }
        });

        //===================================================
        home_btn_eventi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eventi;
                eventi = new Intent(HomeActivity.this, EventiActivity.class);
                startActivity(eventi);

            }
        });
        home_eventi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_btn_eventi.callOnClick();
            }
        });

        //===================================================
        home_btn_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent news;
                news = new Intent(HomeActivity.this, NewsActivity.class);
                startActivity(news);

            }
        });
        home_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_btn_news.callOnClick();
            }
        });

        //===================================================
        home_btn_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fb;
                fb = new Intent(HomeActivity.this, FacebookActivity.class);
                startActivity(fb);

            }
        });
        home_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_btn_fb.callOnClick();
            }
        });

        //===================================================
        home_btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web;
                web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse("http://www.comune.tivoli.rm.it/node"));
                startActivity(web);
            }
        });
        home_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_btn_web.callOnClick();
            }
        });

        //===================================================
        home_btn_contatti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contatti;
                contatti = new Intent(HomeActivity.this, ContattiActivity.class);
                startActivity(contatti);

            }
        });
        home_contatti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_btn_contatti.callOnClick();
            }
        });

        //===================================================
        home_btn_aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutus;
                aboutus = new Intent(HomeActivity.this, CreditiActivity.class);
                startActivity(aboutus);

            }
        });
        home_aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_btn_aboutus.callOnClick();
            }
        });

        //===================================================
    }
}