package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import comune.tivoli.rm.it.ComuneTivoli.guicomponents.TooltipUtil;
import comune.tivoli.rm.it.ComuneTivoli.model.ContattiComune;
import comune.tivoli.rm.it.ComuneTivoli.util.ContattiUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.IntentUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

import java.util.List;

/**
 * Created by millozzi.stefano on 19/04/2016.
 */
// TODO: 10/05/16 - verifica correttezza OK
//done cambiare passaggio di parametri specificando l'id dei contatti
public class ContattiDettagliActivity extends Activity {
    TextView dettagli_titolo;
    TextView dettagli_descrizione;
    ImageButton btn_chiama;
    ImageButton btn_maps;
    ImageButton btn_email;
    ImageButton contatti_btn_streetview_dettagli;
    ImageView screen;
    ContattiDettagliActivityData dati;

    ContattiComune contatto;

    public static Intent preparaIntent(Activity caller, ContattiComune c) {
        ContattiDettagliActivityData dati = new ContattiDettagliActivityData(c);
        return dati.toIntent(caller);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        dati.saveTo(outState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //inizializza l'activiti ed eventualmente il menu
        TemplateUtil.inizializzaActivity(this, "Sedi comunali", R.layout.contattidettagli_activity, R.layout.contattidettagli_activity_decorated);
        dati = new ContattiDettagliActivityData(savedInstanceState, getIntent());

        dettagli_titolo = (TextView) findViewById(R.id.titolo_dettagli);
        dettagli_descrizione = (TextView) findViewById(R.id.descrizione_dettagli);

        contatto = dati.get(ContattiUtil.elencoContatti(this));

        dettagli_titolo.setText(contatto.titolo);

        dettagli_descrizione.setText(contatto.descrizione);
        btn_chiama = (ImageButton) findViewById(R.id.contatti_btn_chiama_dettagli);
        btn_maps = (ImageButton) findViewById(R.id.contatti_btn_maps_dettagli);
        btn_email = (ImageButton) findViewById(R.id.contatti_btn_email_dettagli);
        contatti_btn_streetview_dettagli = (ImageButton) findViewById(R.id.contatti_btn_streetview_dettagli);
        screen = (ImageView) findViewById(R.id.screenmaps);
        screen.setImageResource(contatto.id_image);
        //dettagli_descrizione.setText(getIntent().getExtras().getString("descrizione") + " \n ID IMMAGINE:" + idIMG);

        TooltipUtil.setTooltipOnLongClick(this, btn_chiama, "Chiama " + contatto.titolo);
        TooltipUtil.setTooltipOnLongClick(this, btn_email, "Invia una email a " + contatto.titolo);
        TooltipUtil.setTooltipOnLongClick(this, btn_maps, "Cerca sulla mappa " + contatto.titolo);
        TooltipUtil.setTooltipOnLongClick(this, screen, "Cerca sulla mappa " + contatto.titolo);
        TooltipUtil.setTooltipOnLongClick(this, contatti_btn_streetview_dettagli, "Streetview di " + contatto.titolo);

        //=====================================================
        if (contatto.telefono != null && contatto.telefono.trim().length() > 0) {
            btn_chiama.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent;
                    callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + contatto.telefono));
                    startActivity(callIntent);
                }
            });
        } else {
            btn_chiama.setVisibility(View.GONE);
        }

        //=====================================================
        if (contatto.email != null && contatto.email.trim().length() > 0) {
            btn_email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent emailIntent;
                    emailIntent = new Intent(Intent.ACTION_VIEW);
                    Uri data = Uri.parse("mailto:"
                            + contatto.email
                            + "?subject=" + "Richiesta informazioni" + "&body=" + "");
                    emailIntent.setData(data);
                    startActivity(emailIntent);
                }
            });

        } else {
            btn_email.setVisibility(View.GONE);
        }

        //=====================================================
        if (contatto.getLongitude() > 0 && contatto.getLatitude() > 0) {
            btn_maps.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    screen.callOnClick();
                }
            });

            screen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent i = MapsActivity.createIntent(ContattiDettagliActivity.this, contatto.titolo, contatto.getLongitude(), contatto.getLatitude(), contatto.descrizione, 16, contatto.indirizzo, GoogleMap.MAP_TYPE_TERRAIN);
                    startActivity(i);
                }
            });
            contatti_btn_streetview_dettagli.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent streetView = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("google.streetview:cbll=" + contatto.getLatitude() + "," + contatto.getLongitude() + "&cbp=1,10,,1,1&mz=10"));
                    startActivity(streetView);

                }
            });
        } else {
            btn_maps.setVisibility(View.GONE);
            contatti_btn_streetview_dettagli.setVisibility(View.GONE);
        }
    }

    public static class ContattiDettagliActivityData {
        public static final String LABEL_ID = "ID";
        final int id;

        public ContattiDettagliActivityData(Bundle savedInstanceState, Intent i) {
            id = IntentUtil.getExtraInt(i, savedInstanceState, LABEL_ID, 0);
        }

        public ContattiDettagliActivityData(ContattiComune c) {
            this.id = c.id;
        }

        public ContattiComune get(List<ContattiComune> cc) {
            return ContattiUtil.findById(cc, id);
        }

        public Intent toIntent(Activity a) {

            Bundle b = new Bundle();
            saveTo(b);

            Intent i = new Intent(a, ContattiDettagliActivity.class);
            i.putExtras(b);
            return i;

        }

        public void saveTo(Bundle i) {
            i.putInt(LABEL_ID, id);
        }
    }

}