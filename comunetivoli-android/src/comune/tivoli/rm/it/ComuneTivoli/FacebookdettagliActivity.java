package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.os.Bundle;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

/**
 * Created by millozzi.stefano on 15/03/2016.
 */
public class FacebookdettagliActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TemplateUtil.inizializzaActivity(this, "Facebook",R.layout.facebookdettagli_activity,R.layout.facebookdettagli_activity_decorated);
    }
}