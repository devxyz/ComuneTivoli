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
 * Created by millozzi.stefano on 15/03/2016.
 */
public class ContattiActivity extends Activity {

    private ListView contattiListView;
    private ArrayList<ContattiComune> contatti;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TemplateUtil.inizializzaActivity(this, "Contatti", R.layout.contatti_activity_list, R.layout.contatti_activity_list_decorated);

        contattiListView = (ListView) findViewById(R.id.contatti_listView);

        contatti = ContattiUtil.elencoContatti(this);

        contattiListView.setAdapter(new ContattiComuneListAdapter(this, contatti));

        contattiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContattiComune cc = contatti.get(position);
                Intent i = ContattiDettagliActivity.preparaIntent(ContattiActivity.this, cc.titolo, cc.descrizione, cc.telefono, cc.indirizzo, cc.email, cc.maps, cc.img);

                /*
                //eseguito quando si fa click su una voce


                Intent i = new Intent(ContattiActivity.this, ContattiDettagliActivity.class);
                i.putExtra("titolo", cc.titolo);
                i.putExtra("descrizione", cc.descrizione);
                i.putExtra("telefono", cc.telefono);
                i.putExtra("indirizzo", cc.indirizzo);
                i.putExtra("email", cc.email);
                i.putExtra("maps", cc.maps);
                i.putExtra("img", cc.img);
                */

                startActivity(i);
            }
        });

    }
}