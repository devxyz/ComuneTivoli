package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by millozzi.stefano on 19/04/2016.
 */
public class ContattiDettagliActivity extends Activity {
    TextView dettagli_titolo;
    TextView dettagli_descrizione;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contattidettagli_activity);
        dettagli_titolo = (TextView) findViewById(R.id.titolo_dettagli);
        dettagli_descrizione = (TextView)findViewById(R.id.descrizione_dettagli);
        dettagli_titolo.setText(getIntent().getExtras().getString("titolo"));
        dettagli_descrizione.setText(getIntent().getExtras().getString("descrizione"));
    }

}