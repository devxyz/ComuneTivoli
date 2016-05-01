package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

/**
 * Created by millozzi.stefano on 15/03/2016.
 */

public class FacebookActivity extends Activity {
    ListView lst_news_fb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TemplateUtil.inizializzaActivity(this, "Facebook",R.layout.facebook_activity,R.layout.facebook_activity_decorated);
        lst_news_fb = (ListView) findViewById(R.id.Lst_News_FB);

        lst_news_fb.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                i = new Intent(FacebookActivity.this, FacebookdettagliActivity.class);
                startActivity(i);
                return false;
            }
        });
    }
}