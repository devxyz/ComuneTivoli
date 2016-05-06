package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.util.IntentUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

import java.util.Date;

/**
 * Created by millozzi.stefano on 26/04/2016.
 */
public class NewsDettagliActivity extends Activity {
    TextView news_titolo;
    TextView news_data;
    TextView news_descrizione;
    NewsDettagliActivityData dati;

    public static Intent prepareIntent(Activity a, String titolo, Date data, String descrizione) {
        NewsDettagliActivityData n = new NewsDettagliActivityData(titolo, descrizione, data);
        return n.toIntent(a);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TemplateUtil.inizializzaActivity(this, "Notizie", R.layout.newsdettagli_activity, R.layout.newsdettagli_activity_decorated);
        news_titolo = (TextView) findViewById(R.id.news_titolo);
        news_data = (TextView) findViewById(R.id.news_data);
        news_descrizione = (TextView) findViewById(R.id.news_descrizione);

        dati = new NewsDettagliActivityData(savedInstanceState, getIntent());

        news_titolo.setText(dati.titolo);
        news_descrizione.setText(dati.descrizione);

    }

    public static class NewsDettagliActivityData {
        private static final String LABEL_TITOLO = "titolo";
        private static final String LABEL_DATA = "data";
        private static final String LABEL_DESCRIZIONE = "descrizione";
        String titolo, descrizione;
        Date data;

        public NewsDettagliActivityData(Bundle savedInstanceState, Intent i) {
            titolo = IntentUtil.getExtraString(i, savedInstanceState, LABEL_TITOLO, "");
            descrizione = IntentUtil.getExtraString(i, savedInstanceState, LABEL_DESCRIZIONE, "");
            data = new Date(IntentUtil.getExtraLong(i, savedInstanceState, LABEL_DESCRIZIONE, 0));
        }

        public NewsDettagliActivityData(String titolo, String descrizione, Date data) {
            this.titolo = titolo;
            this.descrizione = descrizione;
            this.data = data;
        }

        public void saveTo(Bundle b) {

            b.putString(LABEL_TITOLO, titolo);
            b.putString(LABEL_DESCRIZIONE, descrizione);
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