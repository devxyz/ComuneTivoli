package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import comune.tivoli.rm.it.ComuneTivoli.guicomponents.FunzioneNonImplementataOnClickListener;
import comune.tivoli.rm.it.ComuneTivoli.util.MonumentiUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

import java.util.Collections;
import java.util.List;

/**
 * Created by millozzi.stefano on 15/03/2016.
 */

public class TurismoActivity extends Activity {
    private ImageButton turismo_btn_monumenti;
    private ImageButton turismo_btn_cosa_mangiare;
    private ImageButton turismo_btn_dormire;
    private ListView turismo_listview_cosavedere;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TemplateUtil.inizializzaActivity(this,  "Turismo", R.layout.turismo_activity, R.layout.turismo_activity_decorated);
        turismo_btn_monumenti = (ImageButton) findViewById(R.id.turismo_btn_monumenti);
        turismo_btn_cosa_mangiare = (ImageButton) findViewById(R.id.turismo_btn_cosa_mangiare);
        turismo_btn_dormire = (ImageButton) findViewById(R.id.turismo_btn_dormire);
        turismo_listview_cosavedere = (ListView) findViewById(R.id.turismo_listview_cosavedere);

        turismo_btn_cosa_mangiare.setOnClickListener(new FunzioneNonImplementataOnClickListener(this));
        turismo_btn_dormire.setOnClickListener(new FunzioneNonImplementataOnClickListener(this));


        turismo_btn_monumenti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = MonumentiActivity.prepareIntent(TurismoActivity.this, null);
                startActivity(i);
            }
        });


        final List<String> strings = MonumentiUtil.estraiCategorie(MonumentiUtil.elencoMonumenti(TurismoActivity.this));
        Collections.sort(strings);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(TurismoActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, strings);

        turismo_listview_cosavedere.setAdapter(adapter);
        turismo_listview_cosavedere.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = MonumentiActivity.prepareIntent(TurismoActivity.this, strings.get(position));
                startActivity(i);
            }
        });
    }
}