package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.os.Bundle;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

/**
 * Created by stefano on 01/05/16.
 */
public class WebActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String url = getIntent().getExtras().getString("url");
        String titolo = getIntent().getExtras().getString("titolo");
        String menu = getIntent().getExtras().getString("menu");
        if (menu == null)
            menu = "Web";

        TemplateUtil.inizializzaActivity(this, menu, R.layout.web_activity, R.layout.web_activity_decorated);
    }
}