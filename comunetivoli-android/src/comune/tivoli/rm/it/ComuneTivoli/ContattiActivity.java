package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import comune.tivoli.rm.it.ComuneTivoli.listview.ContattiComuneListAdapter;
import comune.tivoli.rm.it.ComuneTivoli.model.ContattiComune;

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
        setContentView(R.layout.contatti_activity_list);
        contattiListView = (ListView) findViewById(R.id.contatti_listView);

        contatti = new ArrayList<>();
        ContattiComune comune = new ContattiComune(
                getResources().getString(R.string.contatti_titolo_comune_tivoli),
                getResources().getString(R.string.contatti_descrizione_anagrafe_tivoli),
                getResources().getString(R.string.contatti_telefono_tivoli),
                getResources().getString(R.string.contatti_indirizzo_tivoli),
                getResources().getString(R.string.contatti_email_tivoli),
                getResources().getString(R.string.contatti_maps_tivoli),
                R.drawable.contatti_mappe_comune_anagrafe
        );

        ContattiComune urp = new ContattiComune(
                getResources().getString(R.string.contatti_titolo_urp_tivoli),
                getResources().getString(R.string.contatti_descrizione_urp_tivoli),
                getResources().getString(R.string.contatti_telefono_urp_tivoli),
                getResources().getString(R.string.contatti_indirizzo_urp_tivoli),
                getResources().getString(R.string.contatti_email_urp_tivoli),
                getResources().getString(R.string.contatti_maps_urp_tivoli),
                R.drawable.contatti_mappe_uffrelazioni
        );

        ContattiComune anagrafe = new ContattiComune(
                getResources().getString(R.string.contatti_titolo_anagrafe_tivoli),
                getResources().getString(R.string.contatti_descrizione_anagrafe_tivoli),
                getResources().getString(R.string.contatti_telefono_anagrafe_tivoli),
                getResources().getString(R.string.contatti_indirizzo_anagrafe_tivoli),
                getResources().getString(R.string.contatti_email_anagrafe_tivoli),
                getResources().getString(R.string.contatti_maps_anagrafe_tivoli),
                R.drawable.contatti_mappe_comune_anagrafe
        );

        ContattiComune villa_adriana = new ContattiComune(
                getResources().getString(R.string.contatti_titolo_villa_adriana),
                getResources().getString(R.string.contatti_descrizione_villa_adriana),
                getResources().getString(R.string.contatti_telefono_villa_adriana),
                getResources().getString(R.string.contatti_indirizzo_villa_adriana),
                getResources().getString(R.string.contatti_email_villa_adriana),
                getResources().getString(R.string.contatti_maps_villa_adriana),
                R.drawable.contatti_urpvillaadriana
        );

        ContattiComune tivoli_terme = new ContattiComune(
                getResources().getString(R.string.contatti_titolo_tivoli_terme),
                getResources().getString(R.string.contatti_descrizione_tivoli_terme),
                getResources().getString(R.string.contatti_telefono_tivoli_terme),
                getResources().getString(R.string.contatti_indirizzo_tivoli_terme),
                getResources().getString(R.string.contatti_email_tivoli_terme),
                getResources().getString(R.string.contatti_maps_tivoli_terme),
                R.drawable.contatti_urptivoliterme
        );

        ContattiComune uff_elettorale = new ContattiComune(
                getResources().getString(R.string.contatti_titolo_uff_elettorale),
                getResources().getString(R.string.contatti_descrizione_uff_elettorale),
                getResources().getString(R.string.contatti_telefono_uff_elettorale),
                getResources().getString(R.string.contatti_indirizzo_uff_elettorale),
                getResources().getString(R.string.contatti_email_uff_elettorale),
                getResources().getString(R.string.contatti_maps_uff_elettorale),
                R.drawable.contatti_ufficioelettorale
        );

        contatti.add(comune);
        contatti.add(urp);
        contatti.add(anagrafe);
        contatti.add(villa_adriana);
        contatti.add(tivoli_terme);
        contatti.add(uff_elettorale);

        contattiListView.setAdapter(new ContattiComuneListAdapter(this, contatti));

        contattiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContattiComune cc = contatti.get(position);
                //eseguito quando si fa click su una voce
                Intent i = new Intent(ContattiActivity.this,ContattiDettagliActivity.class);
                i.putExtra("titolo",cc.titolo);
                i.putExtra("descrizione",cc.descrizione);
                i.putExtra("telefono", cc.telefono);
                i.putExtra("indirizzo",cc.indirizzo);
                i.putExtra("email",cc.email);
                i.putExtra("maps", cc.maps);
                i.putExtra("img",cc.img);
                startActivity(i);
           }
        });

    }
}