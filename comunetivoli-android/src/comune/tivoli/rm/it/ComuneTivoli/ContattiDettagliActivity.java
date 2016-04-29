package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

/**
 * Created by millozzi.stefano on 19/04/2016.
 */
public class ContattiDettagliActivity extends Activity {
    TextView dettagli_titolo;
    TextView dettagli_descrizione;
    ImageButton btn_chiama;
    ImageButton btn_maps;
    ImageButton btn_email;
    ImageView screen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contattidettagli_activity_decorated);
        TemplateUtil.inizializzaComponentiTemplate(this, "Contatto");

        dettagli_titolo = (TextView) findViewById(R.id.titolo_dettagli);
        dettagli_descrizione = (TextView) findViewById(R.id.descrizione_dettagli);
        dettagli_titolo.setText(getIntent().getExtras().getString("titolo"));
        dettagli_descrizione.setText(getIntent().getExtras().getString("descrizione"));
        btn_chiama = (ImageButton) findViewById(R.id.btn_chiama_dettagli);
        btn_maps = (ImageButton) findViewById(R.id.btn_maps_dettagli);
        btn_email = (ImageButton) findViewById(R.id.btn_email_dettagli);
        screen = (ImageView) findViewById(R.id.screenmaps);
        screen.setImageDrawable(getResources().getDrawable(getIntent().getExtras().getInt("img")));
        btn_chiama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent;
                callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + getIntent().getExtras().getString("telefono")));
                startActivity(callIntent);
            }
        });
        btn_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapsIntent;
                String mapsLabel = getIntent().getExtras().getString("titolo");
                String mapsGen = getIntent().getExtras().getString("maps");
                String[] coordinate = mapsGen.split(",");

                mapsIntent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=" + coordinate[0] + "," + coordinate[1] + "&z=16 (" + mapsLabel + ")"));
                startActivity(mapsIntent);
            }
        });

        btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent;
                emailIntent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:"
                        + getIntent().getExtras().getString("email")
                        + "?subject=" + "Email from Application" + "&body=" + "");
                emailIntent.setData(data);
                startActivity(emailIntent);
            }
        });
    }

}