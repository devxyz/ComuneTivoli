package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import comune.tivoli.rm.it.ComuneTivoli.listview.NewsComuneListAdapter;
import comune.tivoli.rm.it.ComuneTivoli.model.ContattiComune;
import comune.tivoli.rm.it.ComuneTivoli.model.NewsComune;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by millozzi.stefano on 15/03/2016.
 */
public class NewsActivity extends Activity {
    ListView newslist;
    boolean Letto = false;
    private ArrayList<NewsComune> news;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity_decorated);
        TemplateUtil.inizializzaComponentiTemplate(this, "Notizie");
        newslist = (ListView) findViewById(R.id.news_listview);
        news = new ArrayList<>();
        NewsComune news1 = new NewsComune("News 1", "La news 1", new Date(2016, 4, 5), "www.google.com");
        news.add(news1);

        NewsComune news2 = new NewsComune("News 2", "La news 2", new Date(2015, 4, 3), "www.libero.it");
        news.add(news2);

        NewsComune news3 = new NewsComune("News 3", "La news 3", new Date(2010, 12, 5), "www.tiscali.it");
        news.add(news3);
        newslist.setAdapter(new NewsComuneListAdapter(this, news));

        newslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NewsComune nc = news.get(position);
                //eseguito quando si fa click su una voce
                Intent i = new Intent(NewsActivity.this,NewsDettagliActivity.class);
                i.putExtra("titolo",nc.titolo);
                i.putExtra("descrizione",nc.descrizione);
                i.putExtra("data", nc.data);
                 startActivity(i);
            }
        });

    }

}
