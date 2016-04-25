package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import comune.tivoli.rm.it.ComuneTivoli.listview.ContattiComuneListAdapter;
import comune.tivoli.rm.it.ComuneTivoli.model.ContattiComune;
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

        setContentView(R.layout.contatti_activity_list_decorated);
        TemplateUtil.inizializzaComponentiTemplate(this, "Contatti");

        contattiListView = (ListView) findViewById(R.id.contatti_listView);

        contatti = new ArrayList<>();
        ContattiComune comune = new ContattiComune(
                getResources().getString(R.string.contatti_comune_tivoli_titolo),
                getResources().getString(R.string.contatti_anagrafe_tivoli_descrizione),
                getResources().getString(R.string.contatti_comune_tivoli_telefono),
                getResources().getString(R.string.contatti_comune_tivoli_indirizzo),
                getResources().getString(R.string.contatti_comune_tivoli_email),
                getResources().getString(R.string.contatti_comune_tivoli_maps),
                R.drawable.contatti_mappe_comune_anagrafe
        );

        ContattiComune urp = new ContattiComune(
                getResources().getString(R.string.contatti_urp_tivoli_titolo),
                getResources().getString(R.string.contatti_urp_tivoli_descrizione),
                getResources().getString(R.string.contatti_urp_tivoli_telefono),
                getResources().getString(R.string.contatti_urp_tivoli_indirizzo),
                getResources().getString(R.string.contatti_urp_tivoli_email),
                getResources().getString(R.string.contatti_urp_tivoli_maps),
                R.drawable.contatti_mappe_uffrelazioni
        );

        ContattiComune anagrafe = new ContattiComune(
                getResources().getString(R.string.contatti_anagrafe_tivoli_titolo),
                getResources().getString(R.string.contatti_anagrafe_tivoli_descrizione),
                getResources().getString(R.string.contatti_anagrafe_tivoli_telefono),
                getResources().getString(R.string.contatti_anagrafe_tivoli_indirizzo),
                getResources().getString(R.string.contatti_anagrafe_tivoli_email),
                getResources().getString(R.string.contatti_anagrafe_tivoli_maps),
                R.drawable.contatti_mappe_comune_anagrafe
        );

        ContattiComune villa_adriana = new ContattiComune(
                getResources().getString(R.string.contatti_villa_adriana_titolo),
                getResources().getString(R.string.contatti_villa_adriana_descrizione),
                getResources().getString(R.string.contatti_villa_adriana_telefono),
                getResources().getString(R.string.contatti_villa_adriana_indirizzo),
                getResources().getString(R.string.contatti_villa_adriana_email),
                getResources().getString(R.string.contatti_villa_adriana_maps),
                R.drawable.contatti_urpvillaadriana
        );

        ContattiComune tivoli_terme = new ContattiComune(
                getResources().getString(R.string.contatti_tivoli_terme_titolo),
                getResources().getString(R.string.contatti_tivoli_terme_descrizione),
                getResources().getString(R.string.contatti_tivoli_terme_telefono),
                getResources().getString(R.string.contatti_tivoli_terme_indirizzo),
                getResources().getString(R.string.contatti_tivoli_terme_email),
                getResources().getString(R.string.contatti_tivoli_terme_maps),
                R.drawable.contatti_urptivoliterme
        );

        ContattiComune uff_elettorale = new ContattiComune(
                getResources().getString(R.string.contatti_uff_elettorale_titolo),
                getResources().getString(R.string.contatti_uff_elettorale_descrizione),
                getResources().getString(R.string.contatti_uff_elettorale_telefono),
                getResources().getString(R.string.contatti_uff_elettorale_indirizzo),
                getResources().getString(R.string.contatti_uff_elettorale_email),
                getResources().getString(R.string.contatti_uff_elettorale_maps),
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