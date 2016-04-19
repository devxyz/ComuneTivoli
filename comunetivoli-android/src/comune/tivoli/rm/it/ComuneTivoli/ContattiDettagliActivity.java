package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by millozzi.stefano on 19/04/2016.
 */
public class ContattiDettagliActivity extends Activity {
    TextView dettagli_titolo;
    TextView dettagli_descrizione;
    ImageButton btn_chiama;
    ImageButton btn_maps;
    ImageButton btn_email;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contattidettagli_activity);
        dettagli_titolo = (TextView) findViewById(R.id.titolo_dettagli);
        dettagli_descrizione = (TextView)findViewById(R.id.descrizione_dettagli);
        dettagli_titolo.setText(getIntent().getExtras().getString("titolo"));
        dettagli_descrizione.setText(getIntent().getExtras().getString("descrizione"));
        btn_chiama = (ImageButton) findViewById(R.id.btn_chiama_dettagli);
        btn_maps = (ImageButton) findViewById(R.id.btn_maps_dettagli);
        btn_email = (ImageButton) findViewById(R.id.btn_email_dettagli);
        btn_chiama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i ;
                i= new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+getIntent().getExtras().getString("telefono")));
                startActivity(i);
            }
        });

    }

}