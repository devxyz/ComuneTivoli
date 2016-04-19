package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import comune.tivoli.rm.it.ComuneTivoli.listview.MonumentiComuneListAdapter;
import comune.tivoli.rm.it.ComuneTivoli.model.ContattiComune;
import comune.tivoli.rm.it.ComuneTivoli.model.MonumentiComune;

import java.util.ArrayList;

/**
 * Created by millozzi.stefano on 15/03/2016.
 */
public class MonumentiActivity extends Activity {
    ListView monumenti_list;
    private ArrayList<MonumentiComune> monumenti;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monumenti_activity);
        monumenti_list = (ListView) findViewById(R.id.monumenti_listview);
        monumenti = new ArrayList<>();
        MonumentiComune villa_d_este = new MonumentiComune(
                getResources().getString(R.string.monumenti_villa_d_este_titolo),
                getResources().getString(R.string.monumenti_villa_d_este_descrizione),
                getResources().getDrawable(R.drawable.monumenti_villa_d_este_fotosmall),
                getResources().getString(R.string.monumenti_villa_d_este_url)
        );
        MonumentiComune acquedotti = new MonumentiComune(
                getResources().getString(R.string.monumenti_acquedotti_titolo),
                getResources().getString(R.string.monumenti_acquedotti_descrizione),
                getResources().getDrawable(R.drawable.monumenti_acquedotti_anio_vetus_e_aqua_marcia),
                getResources().getString(R.string.monumenti_acquedotti_url)
        );

        MonumentiComuneListAdapter a=new MonumentiComuneListAdapter(this,monumenti);
                monumenti_list.setAdapter(a);


    }
}
