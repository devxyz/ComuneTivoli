package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import comune.tivoli.rm.it.ComuneTivoli.listview.MonumentiComuneListAdapter;
import comune.tivoli.rm.it.ComuneTivoli.model.MonumentiComune;
import comune.tivoli.rm.it.ComuneTivoli.util.MonumentiUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by millozzi.stefano on 15/03/2016.
 */
public class MonumentiActivity extends Activity {
    ListView monumenti_list;
    private List<MonumentiComune> monumenti;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TemplateUtil.inizializzaActivity(this, "Monumenti", R.layout.monumenti_activity, R.layout.monumenti_activity_decorated);

        monumenti_list = (ListView) findViewById(R.id.monumenti_listview);
        monumenti = MonumentiUtil.elencoMonumenti(this);

        MonumentiComuneListAdapter a = new MonumentiComuneListAdapter(this, monumenti);
        monumenti_list.setAdapter(a);
        monumenti_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //MonumentiComune mc = monumenti.get(position);
                Intent i = new Intent(MonumentiActivity.this, MonumentiDettagliActivity.class);
                i.putExtra("posizione", position);
                startActivity(i);

            }
        });

    }
}
