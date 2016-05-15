package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.guicomponents.FunzioneNonImplementataOnClickListener;
import comune.tivoli.rm.it.ComuneTivoli.listview.MonumentiComuneListAdapter;
import comune.tivoli.rm.it.ComuneTivoli.model.MonumentiComune;
import comune.tivoli.rm.it.ComuneTivoli.util.IntentUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.MonumentiUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by millozzi.stefano on 15/03/2016.
 */
//todo manca corrispondenza tra monumenti nella lista e  nel dettaglio -- errore ID????
public class MonumentiActivity extends Activity {
    ListView monumenti_list;
    TextView monumenti_text;
    ImageButton monumenti_btn;
    private List<MonumentiComune> monumenti;
    private MonumentiActivityData dati;

    public static Intent prepareIntent(Activity caller, String categoria) {
        MonumentiActivityData dati = new MonumentiActivityData(categoria);
        return dati.toIntent(caller);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TemplateUtil.inizializzaActivity(this, "*" + "Monumenti", R.layout.monumenti_activity, R.layout.monumenti_activity_decorated);
        dati = new MonumentiActivityData(savedInstanceState, getIntent());

        monumenti_list = (ListView) findViewById(R.id.monumenti_listview);
        monumenti_text = (TextView) findViewById(R.id.monumenti_titolo);
        monumenti_btn = (ImageButton) findViewById(R.id.monumenti_image);

        if (dati.categoria == null) {
            monumenti = MonumentiUtil.elencoMonumenti(this);
            monumenti_text.setText("Da visitare");
        } else {
            monumenti = MonumentiUtil.filtraByCategoria(MonumentiUtil.elencoMonumenti(this), dati.categoria);
            monumenti_text.setText(dati.categoria);
        }

        monumenti_btn.setOnClickListener(new FunzioneNonImplementataOnClickListener(this));

        Collections.sort(monumenti, new Comparator<MonumentiComune>() {
            @Override
            public int compare(MonumentiComune a, MonumentiComune b) {
                final int i1 = a.categoria.compareTo(b.categoria);
                if (i1 != 0) return i1;
                return a.titolo.compareTo(b.titolo);
            }
        });

        MonumentiComuneListAdapter a = new MonumentiComuneListAdapter(this, monumenti);

        monumenti_list.setAdapter(a);

        monumenti_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Intent intent = MonumentiDettagliActivity.preparaIntent(MonumentiActivity.this, monumenti.get(position));
                startActivity(intent);
            }
        });

    }

    public static class MonumentiActivityData {
        public static final String LABEL_CATEGORIA = "categoria";
        public final String categoria;

        public MonumentiActivityData(Bundle savedInstanceState, Intent ix) {

            categoria = IntentUtil.getExtraString(ix, savedInstanceState, LABEL_CATEGORIA, null);
        }

        public MonumentiActivityData(String categoria) {
            this.categoria = categoria;
        }

        public void saveTo(Bundle b) {
            b.putString(LABEL_CATEGORIA, categoria);
        }

        public Intent toIntent(Activity a) {
            Bundle b = new Bundle();
            saveTo(b);

            Intent i = new Intent(a, MonumentiActivity.class);
            i.putExtras(b);
            return i;
        }
    }

}
