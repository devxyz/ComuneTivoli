package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.util.MonumentiUtil;

/**
 * Created by millozzi.stefano on 15/03/2016.
 */


public class MonumentidettagliActivity extends Activity {

    TextView title_text;
    TextView dettagli_text;
    ImageView image_monumento;
    ImageButton web_btn;
    ImageButton tred_btn;
    ImageButton maps_btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monumentidettagli_activity);
        title_text= (TextView) findViewById(R.id.title_txt);
        dettagli_text= (TextView) findViewById(R.id.txt_description);
        image_monumento= (ImageView) findViewById(R.id.monumenti_image);
        web_btn=(ImageButton) findViewById(R.id.web_btn);
        tred_btn = (ImageButton) findViewById( R.id.tred_btn);
        maps_btn=(ImageButton) findViewById(R.id.maps_btn);
        



    }
}