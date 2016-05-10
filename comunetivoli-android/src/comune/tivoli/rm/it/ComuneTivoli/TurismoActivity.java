package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

/**
 * Created by millozzi.stefano on 15/03/2016.
 */

public class TurismoActivity extends Activity {
    private ImageButton turismo_btn_monumenti;
    private ImageButton turismo_btn_cosa_mangiare;
    private ImageButton turismo_btn_mappa;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TemplateUtil.inizializzaActivity(this,"*"+ "Turismo", R.layout.turismo_activity, R.layout.turismo_activity_decorated);
        turismo_btn_monumenti = (ImageButton) findViewById(R.id.turismo_btn_monumenti);
        turismo_btn_cosa_mangiare = (ImageButton) findViewById(R.id.turismo_btn_cosa_mangiare);
        turismo_btn_mappa = (ImageButton) findViewById(R.id.turismo_btn_mappa);

        turismo_btn_monumenti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TurismoActivity.this, MonumentiActivity.class);
                startActivity(i);
            }
        });
    }
}