package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import comune.tivoli.rm.it.ComuneTivoli.listview.ContattiComuneListAdapter;
import comune.tivoli.rm.it.ComuneTivoli.model.ContattiComune;
import comune.tivoli.rm.it.ComuneTivoli.util.ContattiUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

import java.util.ArrayList;

/**
 * todo: correggere coordinate contatti in quanto imprecisi: usare il sito http://www.coordinate-gps.it/ (via del governo NON e' corretta . aggiornato al 10 maggio 2016
 * nuove coordinate inserite
 */

// TODO: 10/05/16 - verifica correttezza URP (coordinate gps errate)
public class ContattiActivity extends Activity {

    private ListView contattiListView;
    private ArrayList<ContattiComune> contatti;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TemplateUtil.inizializzaActivity(this,"Contatti", R.layout.contatti_activity_list, R.layout.contatti_activity_list_decorated);

        contattiListView = (ListView) findViewById(R.id.contatti_listView);

        contatti = ContattiUtil.elencoContatti(this);

        contattiListView.setAdapter(new ContattiComuneListAdapter(this, contatti));

        contattiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContattiComune cc = contatti.get(position);
                Intent i = ContattiDettagliActivity.preparaIntent(ContattiActivity.this, cc);
                startActivity(i);
            }
        });

    }
}