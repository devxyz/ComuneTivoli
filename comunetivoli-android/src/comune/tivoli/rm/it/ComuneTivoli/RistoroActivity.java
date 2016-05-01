package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.os.Bundle;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

/**
 * Created by millozzi.stefano on 15/03/2016.
 */
public class RistoroActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TemplateUtil.inizializzaActivity(this, "Punti di ristoro",R.layout.ristoro_activity,R.layout.ristoro_activity_decorated);
    }
}