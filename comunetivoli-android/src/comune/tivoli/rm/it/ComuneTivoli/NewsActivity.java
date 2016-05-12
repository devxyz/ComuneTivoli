package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import comune.tivoli.rm.it.ComuneTivoli.db.DBHelperRunnable;
import comune.tivoli.rm.it.ComuneTivoli.db.DbHelper;
import comune.tivoli.rm.it.ComuneTivoli.db.dao.DaoSession;
import comune.tivoli.rm.it.ComuneTivoli.db.dao.NotizieSitoDbSqlLite;
import comune.tivoli.rm.it.ComuneTivoli.db.manager.ManagerNotizieSitoDbSqlLite;
import comune.tivoli.rm.it.ComuneTivoli.dialog.DialogUtil;
import comune.tivoli.rm.it.ComuneTivoli.listview.NewsComuneListAdapter;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by millozzi.stefano on 15/03/2016.
 * todo:sistemare icona search.
 */

public class NewsActivity extends Activity {
    ListView newslist;
    ImageButton search_btn;
    EditText edit_serch_news;
    private ArrayList<NotizieSitoDbSqlLite> newsOriginali;
    private ArrayList<NotizieSitoDbSqlLite> newsFiltered;
    private NewsComuneListAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TemplateUtil.inizializzaActivity(this, "Notizie", R.layout.news_activity, R.layout.news_activity_decorated);
        newslist = (ListView) findViewById(R.id.news_listview);
        newsFiltered = new ArrayList<>();
        search_btn = (ImageButton) findViewById(R.id.news_btn);
        edit_serch_news = (EditText) findViewById(R.id.edit_search_news);

        search_btn.setSelected(true);

        adapter = new NewsComuneListAdapter(this, newsFiltered);
        newslist.setAdapter(adapter);
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_btn.setVisibility(View.GONE);
                edit_serch_news.setVisibility(View.VISIBLE);
                edit_serch_news.requestFocusFromTouch();
            }
        });

        edit_serch_news.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                doFilter();
            }
        });

        newslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final NotizieSitoDbSqlLite nc = newsFiltered.get(position);

                boolean flag = true;
                updateFlagLettura(nc, flag);


                //eseguito quando si fa click su una voce
                final Intent intent = NewsDettagliActivity.prepareIntent(
                        NewsActivity.this, nc.getTitolo(), nc.getData(), nc.getTesto(), nc.getHtml(), nc.getKey());
                startActivity(intent);
            }
        });

        newslist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final NotizieSitoDbSqlLite v = newsFiltered.get(position);
                DialogUtil.openChooseDialog(NewsActivity.this, "Scegli l'opzione",
                        new CharSequence[]{"Segna come LETTO", "Segna come DA LEGGERE", "Segna TUTTO LETTO", "Segna tutto DA LEGGERE", "Annulla"},
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                switch (which) {
                                    case 0:
                                        updateFlagLettura(v, true);
                                        adapter.notifyDataSetChanged();
                                        break;
                                    case 1:
                                        updateFlagLettura(v, false);
                                        adapter.notifyDataSetChanged();
                                        break;
                                    case 2:
                                        updateFlagLettura(newsFiltered, true);
                                        adapter.notifyDataSetChanged();

                                        break;
                                    case 3:
                                        updateFlagLettura(newsFiltered, false);
                                        adapter.notifyDataSetChanged();
                                        break;
                                    case 4:

                                        break;
                                    default:
                                        dialog.dismiss();
                                        break;
                                }
                            }
                        }, null);


                return true;

            }
        });

        reloadDataFromDb();
        doFilter();

    }

    private void updateFlagLettura(final NotizieSitoDbSqlLite nc, boolean flag) {
        if (nc.getFlagContenutoLetto() != flag) {
            nc.setFlagContenutoLetto(flag);
            final DbHelper db = new DbHelper(NewsActivity.this);
            try {

                db.runInTransaction(new DBHelperRunnable() {
                    @Override
                    public void run(DaoSession session, Context ctx) throws Throwable {
                        ManagerNotizieSitoDbSqlLite m = new ManagerNotizieSitoDbSqlLite();
                        m.update(session, nc);
                    }
                });


            } catch (Throwable throwable) {

            } finally {
                db.close();
            }
        }
    }

    /**
     * aggiorna il flag di lettura per tutti gli elementi
     *
     * @param nnc
     * @param flag
     */
    private void updateFlagLettura(final List<NotizieSitoDbSqlLite> nnc, boolean flag) {
        final List<NotizieSitoDbSqlLite> todo = new ArrayList<>();
        for (NotizieSitoDbSqlLite nc : nnc) {
            if (nc.getFlagContenutoLetto() != flag) {
                nc.setFlagContenutoLetto(flag);
                todo.add(nc);
            }
        }

        final DbHelper db = new DbHelper(NewsActivity.this);
        try {

            db.runInTransaction(new DBHelperRunnable() {
                @Override
                public void run(DaoSession session, Context ctx) throws Throwable {
                    ManagerNotizieSitoDbSqlLite m = new ManagerNotizieSitoDbSqlLite();
                    m.update(session, todo);
                }
            });


        } catch (Throwable throwable) {

        } finally {
            db.close();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

        //carica i dati nel db sul resume (anche quando si torna da un'altra activity)
        adapter.notifyDataSetChanged();
        System.out.println("UPDATE NEWS ACTIVITY");
    }

    private void reloadDataFromDb() {
        final DbHelper db = new DbHelper(this);
        try {
            db.runInTransaction(new DBHelperRunnable() {
                @Override
                public void run(DaoSession session, Context ctx) throws Throwable {
                    ManagerNotizieSitoDbSqlLite m = new ManagerNotizieSitoDbSqlLite();
                    newsOriginali = new ArrayList<>(m.list(session));
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            db.close();
        }
    }

    private boolean match(String text, String[] words) {
        text = text.toLowerCase();
        for (String word : words) {
            if (!text.contains(word)) return false;
        }
        return true;
    }


    private void doFilter() {

        String ricerca;
        ricerca = edit_serch_news.getText().toString().trim().toLowerCase();
        final String[] words = ricerca.split("[ ]+");

        ArrayList<NotizieSitoDbSqlLite> nuoveNews = new ArrayList<>();
        if (ricerca.length() == 0) {
            nuoveNews = new ArrayList<>(newsOriginali);
        } else {
            for (int i = 0; i < newsOriginali.size(); i++) {
                NotizieSitoDbSqlLite notizia = newsOriginali.get(i);
                if (match(notizia.getTitolo(), words) || match(notizia.getTesto(), words)) {
                    nuoveNews.add(notizia);
                }
            }
        }
        newsFiltered.clear();
        newsFiltered.addAll(nuoveNews);
        adapter.notifyDataSetChanged();
    }

}
