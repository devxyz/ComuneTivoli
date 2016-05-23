package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.db.DBHelperRunnable;
import comune.tivoli.rm.it.ComuneTivoli.db.DbHelper;
import comune.tivoli.rm.it.ComuneTivoli.db.dao.DaoSession;
import comune.tivoli.rm.it.ComuneTivoli.db.dao.NotizieSitoDbSqlLite;
import comune.tivoli.rm.it.ComuneTivoli.db.manager.ManagerNotizieSitoDbSqlLite;
import comune.tivoli.rm.it.ComuneTivoli.model.MonumentiComune;
import comune.tivoli.rm.it.ComuneTivoli.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    protected TextView home_facebook;
    protected TextView home_news_data;
    protected TextView home_news_titolo;
    protected TextView home_news_descrizione;
    protected ImageButton home_btn_fb;
    protected ImageButton home_btn_web;
    protected TextView home_web;
    protected TextView home_contatti;
    protected ImageButton home_btn_contatti;
    protected TextView home_aboutus;
    protected ImageButton home_btn_aboutus;

    private ThreadAggiornamentoImmagineMonumentiComune task;
    private ThreadAggiornamentoNotizieSitoDbSqlLite task2;


    @Override
    protected void onResume() {
        super.onResume();
        task = new ThreadAggiornamentoImmagineMonumentiComune();
        task.start();

        task2 = new ThreadAggiornamentoNotizieSitoDbSqlLite();
        task2.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        task.stopAnimation();
        task = null;

        task2.stopAnimation();
        task2 = null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TemplateUtil.inizializzaActivity(this,  "Home", R.layout.home_activity_decorated, R.layout.home_activity_decorated);


        Activity view = this;
        xyz = (RelativeLayout) view.findViewById(R.id.xyz);
        home_turismo = (TextView) view.findViewById(R.id.home_turismo);
        home_eventi = (TextView) view.findViewById(R.id.home_eventi);
        home_btn_turismo = (ImageButton) view.findViewById(R.id.home_btn_turismo);
        home_btn_eventi = (ImageButton) view.findViewById(R.id.home_btn_eventi);
        home_news = (TextView) view.findViewById(R.id.home_news);
        home_news_data = (TextView) view.findViewById(R.id.home_news_data);
        home_news_titolo = (TextView) view.findViewById(R.id.home_news_titolo);
        home_news_descrizione = (TextView) view.findViewById(R.id.home_news_descrizione);


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
                /*Intent eventi;
                eventi = new Intent(HomeActivity.this, EventiActivity.class);
                startActivity(eventi);
                */
                startActivity(IntentUtil.openWebBrowser(getResources().getString(R.string.url_eventi_)));

            }
        });
        home_eventi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_btn_eventi.callOnClick();
            }
        });

        //===================================================
        final View.OnClickListener l = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent news;
                news = new Intent(HomeActivity.this, NewsActivity.class);
                startActivity(news);
            }
        };
        home_news_titolo.setOnClickListener(l);
        home_news.setOnClickListener(l);
        home_news_descrizione.setOnClickListener(l);
        home_news_data.setOnClickListener(l);

        //===================================================
        home_btn_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent fb;
                fb = new Intent(HomeActivity.this, FacebookActivity.class);
                startActivity(fb);*/
                final Intent facebook = WebActivity.prepare(HomeActivity.this, getResources().getString(R.string.url_facebook), "Comune di Tivoli", "Facebook");
                startActivity(facebook);

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
                //final Intent prepare = WebActivity.prepare(HomeActivity.this, "http://www.comune.tivoli.rm.it/node", "Comune di Tivoli", "Sito Web");
                startActivity(IntentUtil.openWebBrowser(getResources().getString(R.string.url_comune_tivoli)));
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

    private class ThreadAggiornamentoImmagineMonumentiComune extends Thread {
        private static final int SLEEP_SEC = 8000;
        protected final Random r;
        protected List<MonumentiComune> monumenti;
        protected volatile boolean stop = false;

        public ThreadAggiornamentoImmagineMonumentiComune() {
            r = new Random();
        }

        public void stopAnimation() {
            stop = true;
        }

        @Override
        public void run() {
            super.run();

            monumenti = new ArrayList<>(MonumentiUtil.elencoMonumenti(HomeActivity.this));

            {
                final Point size = ScreenUtil.getSize(HomeActivity.this);
                final Bitmap bitmap = ScreenUtil.drawableToBitmap(HomeActivity.this.getResources().getDrawable(R.drawable.home_eventi_170x220));
                final Bitmap bitmap1 = bitmap == null ? null : ScreenUtil.scaleAndAdaptWith(bitmap, size.x / 2-40);
                HomeActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        home_btn_eventi.setImageBitmap(bitmap1);
                    }
                });

            }

            while (!stop) {
                final Point size = ScreenUtil.getSize(HomeActivity.this);
                final MonumentiComune m = monumenti.size() == 0 ? null : monumenti.get(r.nextInt(monumenti.size()));
                final Bitmap bitmap = m == null ? null : ScreenUtil.drawableToBitmap(HomeActivity.this.getResources().getDrawable(m.foto_small));
                final Bitmap bitmap1 = bitmap == null ? null : ScreenUtil.scaleAndAdaptWith(bitmap, size.x / 2);

                HomeActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (bitmap1 != null)
                            home_btn_turismo.setImageBitmap(bitmap1);
                    }
                });

                try {
                    Thread.sleep(SLEEP_SEC);
                } catch (InterruptedException e) {
                }
                if (stop) return;

            }
        }
    }

    /**
     * aggiorna elenco news
     */
    private class ThreadAggiornamentoNotizieSitoDbSqlLite extends Thread {
        private static final int SLEEP_SEC = 5000;
        protected final Random r;
        protected List<NotizieSitoDbSqlLite> news;
        protected volatile boolean stop = false;

        public ThreadAggiornamentoNotizieSitoDbSqlLite() {


            r = new Random();
        }

        public void stopAnimation() {
            stop = true;
        }

        @Override
        public void run() {
            super.run();

            final DbHelper db = new DbHelper(HomeActivity.this);
            try {
                db.runInTransaction(new DBHelperRunnable() {
                    @Override
                    public void run(DaoSession session, Context ctx) throws Throwable {
                        ManagerNotizieSitoDbSqlLite m = new ManagerNotizieSitoDbSqlLite();
                        news = new ArrayList<>(m.latestNews(session, 10));
                    }
                });
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            } finally {
                db.close();
            }


            ////////////////////////////////
            while (!stop) {
                if (news.size() > 0) {
                    final NotizieSitoDbSqlLite remove = news.remove(0);
                    news.add(remove);
                }

                HomeActivity.this.runOnUiThread(
                        new Runnable() {
                            @Override
                            public void run() {
                                if (news.size() > 0) {
                                    final NotizieSitoDbSqlLite x = news.get(0);

                                    if (x.getData() != null)
                                        home_news_data.setText(DateUtil.toDDMMYYY(x.getData()));
                                    else
                                        home_news_data.setText("");
                                    home_news_titolo.setText(x.getTitolo());
                                    home_news_descrizione.setText(x.getTesto());
                                }
                            }
                        }
                );

                try {
                    Thread.sleep(SLEEP_SEC);
                } catch (InterruptedException e) {
                }

            }
        }
    }
}