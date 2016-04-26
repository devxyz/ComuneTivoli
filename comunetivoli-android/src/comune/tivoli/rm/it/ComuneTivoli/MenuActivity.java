package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;

/**
 * Created by stefano on 26/04/16.
 */
public class MenuActivity extends Activity {
    ListView menuListView;
    ImageButton menuButton,menu_topimg;
    RelativeLayout menuRelative;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        menuListView = (ListView) findViewById(R.id.menu_listview);
        menuButton = (ImageButton) findViewById(R.id.menu_btnclose);
        menu_topimg = (ImageButton) findViewById(R.id.menu_topimg);
        menuRelative = (RelativeLayout) findViewById(R.id.menu_relative);

        ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        a.add("menu 1");
        a.add("menu 2");
        a.add("menu 3");
        a.add("menu 4");
        menuListView.setAdapter(a);

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