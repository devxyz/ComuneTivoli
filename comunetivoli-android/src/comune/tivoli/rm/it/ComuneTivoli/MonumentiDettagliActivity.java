package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.dialog.DialogUtil;
import comune.tivoli.rm.it.ComuneTivoli.model.MonumentiComune;
import comune.tivoli.rm.it.ComuneTivoli.util.MonumentiUtil;

import java.util.ArrayList;

/**
 * Created by millozzi.stefano on 15/03/2016.
 */


public class MonumentiDettagliActivity extends Activity {

    TextView title_text;
    TextView dettagli_text;
    ImageView image_monumento;
    ImageButton web_btn;
    ImageButton tred_btn;
    ImageButton maps_btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monumenti_dettagli_activity);
        title_text = (TextView) findViewById(R.id.title_txt);
        dettagli_text = (TextView) findViewById(R.id.txt_description);
        image_monumento = (ImageView) findViewById(R.id.monumenti_image);
        web_btn = (ImageButton) findViewById(R.id.web_btn);
        tred_btn = (ImageButton) findViewById(R.id.tred_btn);
        maps_btn = (ImageButton) findViewById(R.id.maps_btn);

        try {


            int position = getIntent().getExtras().getInt("position");
            DialogUtil.openInfoDialog(this, "debug", "Posizione " + position);
            ArrayList<MonumentiComune> mm = MonumentiUtil.elencoMonumenti(this);
            MonumentiComune monumento = mm.get(position);
            title_text.setText(monumento.titolo);
            dettagli_text.setText(monumento.descrizione);
            image_monumento.setImageDrawable(monumento.foto_big);

        } catch (Throwable e) {
            DialogUtil.openErrorDialog(this, "Errore", "Errore inatteso", e);
        }


    }
}