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
import comune.tivoli.rm.it.ComuneTivoli.dialog.TooltipUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.IntentUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

import java.text.MessageFormat;

/**
 * Created by millozzi.stefano on 19/04/2016.
 */
// TODO: 10/05/16 - verifica correttezza OK
public class ContattiDettagliActivity extends Activity {
    TextView dettagli_titolo;
    TextView dettagli_descrizione;
    ImageButton btn_chiama;
    ImageButton btn_maps;
    ImageButton btn_email;
    ImageButton contatti_btn_streetview_dettagli;
    ImageView screen;
    ContattiDettagliActivityData dati;

    public static Intent preparaIntent(Activity caller, String titolo, String descrizione, String telefono, String indirizzo, String email, double longitudine, double latitudine, int img) {
        ContattiDettagliActivityData dati = new ContattiDettagliActivityData(titolo, descrizione, img, longitudine, latitudine, telefono, indirizzo, email);
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
        TemplateUtil.inizializzaActivity(this,  "Sedi comunali", R.layout.contattidettagli_activity, R.layout.contattidettagli_activity_decorated);
        dati = new ContattiDettagliActivityData(savedInstanceState, getIntent());

        dettagli_titolo = (TextView) findViewById(R.id.titolo_dettagli);
        dettagli_descrizione = (TextView) findViewById(R.id.descrizione_dettagli);


        dettagli_titolo.setText(dati.titolo);

        dettagli_descrizione.setText(dati.descrizione);
        btn_chiama = (ImageButton) findViewById(R.id.contatti_btn_chiama_dettagli);
        btn_maps = (ImageButton) findViewById(R.id.contatti_btn_maps_dettagli);
        btn_email = (ImageButton) findViewById(R.id.contatti_btn_email_dettagli);
        contatti_btn_streetview_dettagli = (ImageButton) findViewById(R.id.contatti_btn_streetview_dettagli);
        screen = (ImageView) findViewById(R.id.screenmaps);
        screen.setImageResource(dati.image_id);
        //dettagli_descrizione.setText(getIntent().getExtras().getString("descrizione") + " \n ID IMMAGINE:" + idIMG);

        TooltipUtil.setTooltipOnLongClick(this, btn_chiama, "Chiama " + dati.titolo);
        TooltipUtil.setTooltipOnLongClick(this, btn_email, "Invia una email a " + dati.titolo);
        TooltipUtil.setTooltipOnLongClick(this, btn_maps, "Cerca sulla mappa " + dati.titolo);
        TooltipUtil.setTooltipOnLongClick(this, screen, "Cerca sulla mappa " + dati.titolo);
        TooltipUtil.setTooltipOnLongClick(this, contatti_btn_streetview_dettagli, "Streetview di " + dati.titolo);

        //=====================================================
        if (dati.telefono != null && dati.telefono.trim().length() > 0) {
            btn_chiama.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent;
                    callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + dati.telefono));
                    startActivity(callIntent);
                }
            });
        } else {
            btn_chiama.setVisibility(View.GONE);
        }

        //=====================================================
        if (dati.email != null && dati.email.trim().length() > 0) {
            btn_email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent emailIntent;
                    emailIntent = new Intent(Intent.ACTION_VIEW);
                    Uri data = Uri.parse("mailto:"
                            + dati.email
                            + "?subject=" + "Richiesta informazioni" + "&body=" + "");
                    emailIntent.setData(data);
                    startActivity(emailIntent);
                }
            });

        } else {
            btn_email.setVisibility(View.GONE);
        }

        //=====================================================
        if (dati.longitudine > 0 && dati.latitudine > 0) {
            btn_maps.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    screen.callOnClick();
                }
            });

            screen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent i = MapsActivity.createIntent(ContattiDettagliActivity.this, dati.titolo, dati.longitudine, dati.latitudine, dati.descrizione, 16, dati.indirizzo, GoogleMap.MAP_TYPE_TERRAIN);
                    startActivity(i);
                }
            });
            contatti_btn_streetview_dettagli.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent streetView = new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("google.streetview:cbll="+ dati.latitudine+","+dati.longitudine+"&cbp=1,10,,1,1&mz=10"));
                    startActivity(streetView);

                }
            });
        } else {
            btn_maps.setVisibility(View.GONE);
            contatti_btn_streetview_dettagli.setVisibility(View.GONE);
        }
    }

    public static class ContattiDettagliActivityData {
        public static final String LABEL_TITOLO = "titolo";
        public static final String LABEL_DESCRIZIONE = "descrizione";
        public static final String LABEL_LONGITUDINE = "longitudine";
        public static final String LABEL_LATITUDINE = "latitudine";
        public static final String LABEL_IMAGE_ID = "image_id";
        public static final String LABEL_TELEFONO = "telefono";
        public static final String LABEL_INDIRIZZO = "indirizzo";
        public static final String LABEL_EMAIL = "email";
        final String titolo;
        final String descrizione;
        final int image_id;
        final double longitudine, latitudine;
        final String telefono, indirizzo, email;

        public ContattiDettagliActivityData(Bundle savedInstanceState, Intent i) {
            longitudine = IntentUtil.getExtraDouble(i, savedInstanceState, LABEL_LONGITUDINE, 0);
            image_id = IntentUtil.getExtraInt(i, savedInstanceState, LABEL_IMAGE_ID, 0);
            latitudine = IntentUtil.getExtraDouble(i, savedInstanceState, LABEL_LATITUDINE, 0);
            titolo = IntentUtil.getExtraString(i, savedInstanceState, LABEL_TITOLO, null);
            descrizione = IntentUtil.getExtraString(i, savedInstanceState, LABEL_DESCRIZIONE, null);
            telefono = IntentUtil.getExtraString(i, savedInstanceState, LABEL_TELEFONO, null);
            indirizzo = IntentUtil.getExtraString(i, savedInstanceState, LABEL_INDIRIZZO, null);
            email = IntentUtil.getExtraString(i, savedInstanceState, LABEL_EMAIL, null);

        }

        public ContattiDettagliActivityData(String titolo, String descrizione, int image_id, double longitudine, double latitudine, String telefono, String indirizzo, String email) {
            this.titolo = titolo;
            this.descrizione = descrizione;
            this.image_id = image_id;
            this.longitudine = longitudine;
            this.latitudine = latitudine;
            this.telefono = telefono;
            this.indirizzo = indirizzo;
            this.email = email;
        }

        public Intent toIntent(Activity a) {

            Bundle b = new Bundle();
            saveTo(b);

            Intent i = new Intent(a, ContattiDettagliActivity.class);
            i.putExtras(b);
            return i;

        }

        public void saveTo(Bundle i) {
            i.putString(LABEL_TITOLO, titolo);
            i.putString(LABEL_DESCRIZIONE, descrizione);
            i.putString(LABEL_TELEFONO, telefono);
            i.putString(LABEL_INDIRIZZO, indirizzo);
            i.putString(LABEL_EMAIL, email);
            i.putDouble(LABEL_LONGITUDINE, longitudine);
            i.putDouble(LABEL_LATITUDINE, latitudine);
            i.putInt(LABEL_IMAGE_ID, image_id);
        }
    }

}