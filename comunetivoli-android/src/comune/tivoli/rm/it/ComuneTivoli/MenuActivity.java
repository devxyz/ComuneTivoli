package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import comune.tivoli.rm.it.ComuneTivoli.model.MenuApplicazione;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefano on 26/04/16.
 */
public class MenuActivity extends Activity {
    ListView menuListView;
    ImageButton menuButton, menu_topimg;
    RelativeLayout menuRelative;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        menuListView = (ListView) findViewById(R.id.menu_listview);
        menuButton = (ImageButton) findViewById(R.id.menu_btnclose);
        menu_topimg = (ImageButton) findViewById(R.id.menu_topimg);
        menuRelative = (RelativeLayout) findViewById(R.id.menu_relative);

        final List<MenuApplicazione> vociMenu = new ArrayList<>();
        vociMenu.add(new MenuApplicazione("Home", HomeActivity.class));
        vociMenu.add(new MenuApplicazione("Informazioni turistiche", TurismoActivity.class));
        vociMenu.add(new MenuApplicazione("Notizie Istituzionali", NewsActivity.class));
        vociMenu.add(new MenuApplicazione("News dai Social", NewsActivity.class));
        vociMenu.add(new MenuApplicazione("Credits", CreditiActivity.class));
        vociMenu.add(new MenuApplicazione("DEBUG", DebugHomeActivity.class));

        final ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        for (MenuApplicazione x : vociMenu) {
            a.add(x.titoloMenu);
        }

        menuListView.setAdapter(a);
        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MenuActivity.this.finish();
                vociMenu.get(position).azione.esegui(MenuActivity.this);

            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        menuRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuButton.callOnClick();
            }
        });

        menu_topimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuButton.callOnClick();
            }
        });
    }
}