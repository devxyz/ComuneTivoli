package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import comune.tivoli.rm.it.ComuneTivoli.listview.DoveMangiareListAdapter;
import comune.tivoli.rm.it.ComuneTivoli.model.DoveMangiareComune;
import comune.tivoli.rm.it.ComuneTivoli.util.DoveMangiareUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

import java.util.ArrayList;

/**
 * Created by millozzi.stefano on 17/05/2016.
 */
public class DoveMangiareActivity extends Activity {

    private ListView dovemangiareListview;
    private ArrayList<DoveMangiareComune> dovemangiare;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TemplateUtil.inizializzaActivity(this,"Dove mangiare", R.layout.dove_mangiare_activity_list, R.layout.dove_mangiare_activity_list_decorated);

        dovemangiareListview = (ListView) findViewById(R.id.dovemangiare_listView);

        dovemangiare = DoveMangiareUtil.elencoPuntiRistoro(this);

        dovemangiareListview.setAdapter(new DoveMangiareListAdapter(this, dovemangiare));

        dovemangiareListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DoveMangiareComune dmc = dovemangiare.get(position);
                //apri dettagli
            }
        });
    }
}