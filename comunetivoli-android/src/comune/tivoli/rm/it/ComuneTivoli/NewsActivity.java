package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import comune.tivoli.rm.it.ComuneTivoli.listview.NewsComuneListAdapter;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

import java.util.ArrayList;

/**
 * Created by millozzi.stefano on 15/03/2016.
 * todo:sistemare icona search.
 */

public class NewsActivity extends Activity {
    ListView newslist;
    boolean Letto = false;
    private ArrayList<NotizieSitoDbSqlLite> news;
    ImageButton search_btn;
    EditText edit_serch_news;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TemplateUtil.inizializzaActivity(this,"*"+ "Notizie", R.layout.news_activity, R.layout.news_activity_decorated);
        newslist = (ListView) findViewById(R.id.news_listview);
        news = new ArrayList<>();
        search_btn = (ImageButton) findViewById(R.id.search_btn);
        edit_serch_news=(EditText) findViewById(R.id.edit_serch_news);


        ManagerNotizieSitoDbSqlLite m = new ManagerNotizieSitoDbSqlLite();

        final DbHelper db = new DbHelper(this);
        try {
            db.runInTransaction(new DBHelperRunnable() {
                @Override
                public void run(DaoSession session, Context ctx) throws Throwable {
                    ManagerNotizieSitoDbSqlLite m = new ManagerNotizieSitoDbSqlLite();
                    news = new ArrayList<>(m.list(session));
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            db.close();
        }

        newslist.setAdapter(new NewsComuneListAdapter(this, news));
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ricerca;
                ricerca = edit_serch_news.getText().toString().toLowerCase();

                ArrayList<NotizieSitoDbSqlLite> nuoveNews=new ArrayList<NotizieSitoDbSqlLite>();

                for(int i=0; i <= news.size(); i++ ) {
                    NotizieSitoDbSqlLite notizia = news.get(i);
                    if (notizia.getTitolo().toLowerCase().contains(ricerca) || notizia.getTesto().toLowerCase().contains(ricerca)){
                        nuoveNews.add(notizia);
                    }
                }
                newslist.setAdapter(new NewsComuneListAdapter(NewsActivity.this, nuoveNews));
            }
        });
        newslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NotizieSitoDbSqlLite nc = news.get(position);

                //eseguito quando si fa click su una voce
                final Intent intent = NewsDettagliActivity.prepareIntent(
                        NewsActivity.this, nc.getTitolo(), nc.getData(), nc.getTesto(), nc.getHtml(), nc.getKey());
                startActivity(intent);
            }
        });

    }

}
