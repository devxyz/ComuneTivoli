package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.dialog.DialogUtil;
import comune.tivoli.rm.it.ComuneTivoli.model.MonumentiComune;
import comune.tivoli.rm.it.ComuneTivoli.util.MonumentiUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

import java.util.ArrayList;

/**
 * Created by millozzi.stefano on 15/03/2016.
 */

/**
 * http://www.visittivoli.eu/virtual-tour/santuario-di-ercole-vincitore/
 * http://www.visittivoli.eu/virtual-tour/villa-d-este/
 * http://www.visittivoli.eu/virtual-tour/villa-adriana/
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
        TemplateUtil.inizializzaActivity(this, "Monumenti",R.layout.monumenti_dettagli_activity,R.layout.monumenti_dettagli_activity_decorated);
        title_text = (TextView) findViewById(R.id.title_txt);
        dettagli_text = (TextView) findViewById(R.id.txt_description);
        image_monumento = (ImageView) findViewById(R.id.image_monumento);
        web_btn = (ImageButton) findViewById(R.id.web_btn);
        tred_btn = (ImageButton) findViewById(R.id.view3d_btn);
        maps_btn = (ImageButton) findViewById(R.id.maps_btn);


        int position = getIntent().getExtras().getInt("posizione");
        try {
            //DialogUtil.openInfoDialog(this, "debug", "Posizione " + position);
            ArrayList<MonumentiComune> mm = MonumentiUtil.elencoMonumenti(this);
            final MonumentiComune monumento = mm.get(position);
            title_text.setText(monumento.titolo);
            dettagli_text.setText(monumento.descrizione_big);
            final Drawable foto_big = getResources().getDrawable(monumento.foto_big);
            if (foto_big != null)
                image_monumento.setImageDrawable(foto_big);
            else {
                //image_monumento.setImageDrawable(null);
            }

            if (monumento.tred.length() > 0)
                tred_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = monumento.tred;
                        Uri uriUrl = Uri.parse(url);
                        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                        startActivity(launchBrowser);

                    }
                });
            else
                tred_btn.setVisibility(View.INVISIBLE);
            if (monumento.latitudineLongitudineMaps.length() > 0)
                maps_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = monumento.latitudineLongitudineMaps;
                        Uri uriUrl = Uri.parse(url);
                        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                        startActivity(launchBrowser);

                    }
                });
            else
                maps_btn.setVisibility(View.INVISIBLE);
            if (monumento.url.length() > 0)
                web_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = monumento.url;
                        Uri uriUrl = Uri.parse(url);
                        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                        startActivity(launchBrowser);

                    }
                });
            else
                web_btn.setVisibility(View.INVISIBLE);

        } catch (Throwable e) {
            DialogUtil.openErrorDialog(this, "Errore", "Errore inatteso " + position, e);
        }


    }
}