package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

/**
 * Created by millozzi.stefano on 26/04/2016.
 */
public class NewsDettagliActivity extends Activity {
    TextView news_titolo;
    TextView news_data;
    TextView news_descrizione;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TemplateUtil.inizializzaActivity(this, "Notizie",R.layout.newsdettagli_activity,R.layout.newsdettagli_activity_decorated);
        news_titolo = (TextView) findViewById(R.id.news_titolo);
        news_data = (TextView) findViewById(R.id.news_data);
        news_descrizione = (TextView) findViewById(R.id.news_descrizione);


    }
}