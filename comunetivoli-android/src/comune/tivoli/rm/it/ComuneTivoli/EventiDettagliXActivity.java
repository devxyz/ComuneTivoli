package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.os.Bundle;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

/**
 * Created by millozzi.stefano on 15/03/2016.
 */
//// TODO: 10/05/16 da realizzare
public class EventiDettagliXActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TemplateUtil.inizializzaActivity(this,"*"+ "Eventi",R.layout.eventidettagli_activity,R.layout.eventidettagli_activity_decorated);
    }
}