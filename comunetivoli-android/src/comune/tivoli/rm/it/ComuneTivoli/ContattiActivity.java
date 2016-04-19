package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
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
        ContattiComune c = new ContattiComune(
                getResources().getString(R.string.contatti_titolo_comune_tivoli),
                getResources().getString(R.string.contatti_descrizione_anagrafe_tivoli),
                "url",
                "indirizzo",
                "email"
        );

        contatti.add(c);


        contattiListView.setAdapter(new ContattiComuneListAdapter(this, contatti));

        contattiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //eseguito quando si fa click su una voce


            }
        });

    }
}