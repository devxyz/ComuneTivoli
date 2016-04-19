package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
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



    }
}