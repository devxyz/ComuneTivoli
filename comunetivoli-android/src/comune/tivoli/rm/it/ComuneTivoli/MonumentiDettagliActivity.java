package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import comune.tivoli.rm.it.ComuneTivoli.guicomponents.DialogUtil;
import comune.tivoli.rm.it.ComuneTivoli.model.MonumentiComune;
import comune.tivoli.rm.it.ComuneTivoli.util.IntentUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.MonumentiUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

import java.util.List;

/**
 * Created by millozzi.stefano on 15/03/2016.
 * todo:inserire le immagini buone
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
    ImageButton foto_btn;
    private MonumentiDettagliActivityData dati;

    public static Intent preparaIntent(Activity caller, MonumentiComune c) {
        MonumentiDettagliActivityData dati = new MonumentiDettagliActivityData(c);
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
        TemplateUtil.inizializzaActivity(this, "*" + "Dettagli", R.layout.monumenti_dettagli_activity, R.layout.monumenti_dettagli_activity_decorated);
        dati = new MonumentiDettagliActivityData(savedInstanceState, getIntent());


        title_text = (TextView) findViewById(R.id.title_txt);
        dettagli_text = (TextView) findViewById(R.id.txt_description);
        image_monumento = (ImageView) findViewById(R.id.image_monumento);
        web_btn = (ImageButton) findViewById(R.id.monumenti_web_btn);
        tred_btn = (ImageButton) findViewById(R.id.monumenti_view3d_btn);
        maps_btn = (ImageButton) findViewById(R.id.monumenti_maps_btn);
        foto_btn = (ImageButton) findViewById(R.id.monumenti_btn_gallery);


        try {
            //DialogUtil.openInfoDialog(this, "debug", "Posizione " + position);
            final MonumentiComune monumento = MonumentiUtil.findById(MonumentiUtil.elencoMonumenti(this), dati.id);
            if (monumento != null) {
                title_text.setText(monumento.titolo);
                dettagli_text.setText(monumento.descrizione_big);
                final Drawable foto_big = getResources().getDrawable(monumento.foto_big);
                if (foto_big != null)
                    image_monumento.setBackgroundResource(monumento.foto_big);
                else {
                    //image_monumento.setImageDrawable(null);
                }


                if (monumento.tred.length() > 0)
                    tred_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(WebActivity.prepare(MonumentiDettagliActivity.this, monumento.tred, monumento.titolo, "Panoramica 3D " + monumento.categoria));

                        }
                    });
                else
                    tred_btn.setVisibility(View.GONE);


                if (monumento.latitudineLongitudineMaps.length() > 0)
                    maps_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            final Intent intent = MapsActivity.createIntent(MonumentiDettagliActivity.this, monumento.titolo, monumento.getLongitude(), monumento.getLatitude(), monumento.descrizione, 18, "", GoogleMap.MAP_TYPE_SATELLITE);
                            startActivity(intent);

                        }
                    });
                else
                    maps_btn.setVisibility(View.GONE);


                if (monumento.url.length() > 0)
                    web_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            final Intent prepare = WebActivity.prepare(MonumentiDettagliActivity.this, monumento.url, monumento.titolo, "Informazioni aggiuntive " + monumento.categoria);
                            startActivity(prepare);

                        }
                    });
                else
                    web_btn.setVisibility(View.GONE);


                if (monumento.galleriaFoto.size() > 0) {
                    final View.OnClickListener l = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String descrizione = "" + monumento.galleriaFoto.size() + " foto";
                            final Intent intent = ImageScrollActivity.prepareIntent(MonumentiDettagliActivity.this, monumento.titolo, descrizione, monumento.galleriaFoto);
                            startActivity(intent);

                        }
                    };
                    foto_btn.setOnClickListener(l);
                    image_monumento.setOnClickListener(l);
                } else {
                    foto_btn.setVisibility(View.GONE);
                }
            }

        } catch (Throwable e) {
            DialogUtil.openErrorDialog(this, "Errore", "Errore inatteso " + dati.id, e);
        }


    }

    public static class MonumentiDettagliActivityData {
        public static final String LABEL_ID_MONUMENTO = "id";
        public final int id;

        public MonumentiDettagliActivityData(Bundle savedInstanceState, Intent i) {
            id = IntentUtil.getExtraInt(i, savedInstanceState, LABEL_ID_MONUMENTO, 0);
        }

        public MonumentiDettagliActivityData(MonumentiComune m) {
            this.id = m.id;
        }

        public MonumentiComune get(List<MonumentiComune> mm) {
            return MonumentiUtil.findById(mm, id);
        }

        public void saveTo(Bundle b) {
            b.putInt(LABEL_ID_MONUMENTO, id);
        }

        public Intent toIntent(Activity a) {
            Bundle b = new Bundle();
            saveTo(b);

            Intent i = new Intent(a, MonumentiDettagliActivity.class);
            i.putExtras(b);
            return i;
        }
    }
}