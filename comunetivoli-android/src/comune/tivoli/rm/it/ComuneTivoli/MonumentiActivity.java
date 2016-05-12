package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import comune.tivoli.rm.it.ComuneTivoli.listview.MonumentiComuneListAdapter;
import comune.tivoli.rm.it.ComuneTivoli.model.MonumentiComune;
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
    private List<MonumentiComune> monumenti;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TemplateUtil.inizializzaActivity(this, "*" + "Monumenti", R.layout.monumenti_activity, R.layout.monumenti_activity_decorated);

        monumenti_list = (ListView) findViewById(R.id.monumenti_listview);
        monumenti = MonumentiUtil.elencoMonumenti(this);

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
}
