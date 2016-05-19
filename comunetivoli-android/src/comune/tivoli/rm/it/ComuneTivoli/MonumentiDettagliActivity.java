package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.GoogleMap;
import com.squareup.picasso.Picasso;
import comune.tivoli.rm.it.ComuneTivoli.guicomponents.DialogUtil;
import comune.tivoli.rm.it.ComuneTivoli.guicomponents.listener.OnClickListenerDialogErrorCheck;
import comune.tivoli.rm.it.ComuneTivoli.guicomponents.listener.OnClickListenerViewErrorCheck;
import comune.tivoli.rm.it.ComuneTivoli.model.MonumentiComune;
import comune.tivoli.rm.it.ComuneTivoli.util.IntentUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.MonumentiUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

import java.util.List;
import java.util.Locale;

/**
 * Created by millozzi.stefano on 15/03/2016.
 * todo: nel file xml inserire la URL delle immagini BIG prelevandole dal sito (per evitare dimensione troppo alta)
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
    ImageButton monumenti_btn_voice;
    private MonumentiDettagliActivityData dati;
    private ProgressDialog dialog;
    private TextToSpeech engine;

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
        monumenti_btn_voice = (ImageButton) findViewById(R.id.monumenti_btn_voice);

        tred_btn.setLongClickable(true);


        try {
            //DialogUtil.openInfoDialog(this, "debug", "Posizione " + position);
            final MonumentiComune monumento = MonumentiUtil.findById(MonumentiUtil.elencoMonumenti(this), dati.id);
            if (monumento != null) {
                title_text.setText(monumento.titolo);
                dettagli_text.setText(monumento.descrizione_big);

                String urlImmagine = monumento.url_foto_big;
                if (urlImmagine.length() == 0) {
                    if (monumento.galleriaFoto.size() > 0)
                        urlImmagine = monumento.galleriaFoto.get(0);
                }
                if (urlImmagine.length() > 0) {
                    Picasso.with(this).load(urlImmagine).placeholder(monumento.foto_small)
                            .into(image_monumento);
                }

                 /*
                final Drawable foto_big = getResources().getDrawable(monumento.url_foto_big);
                if (foto_big != null)
                    image_monumento.setImageResource(monumento.url_foto_big);
                else {
                    //image_monumento.setImageDrawable(null);
                }
                */

                if (monumento.tred.length() > 0) {
                    tred_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //startActivity(WebActivity.prepare(MonumentiDettagliActivity.this, monumento.tred, monumento.titolo, "Panoramica 3D " + monumento.categoria));
                            final Intent intent = IntentUtil.openWebBrowser(monumento.tred);
                            startActivity(intent);

                        }
                    });
                    /*
                    todo: visualizzazione 3d in webview ha problemi di performance gravi
                    tred_btn.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            startActivity(WebActivity.prepare(MonumentiDettagliActivity.this, monumento.tred, monumento.titolo, "Panoramica 3D " + monumento.categoria));
                            return true;
                        }
                    });
                    */
                } else
                    tred_btn.setVisibility(View.GONE);


                if (monumento.latitudineLongitudineMaps.length() > 0) {
                    maps_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            final Intent intent = MapsActivity.createIntentMapsActivity(MonumentiDettagliActivity.this, monumento.titolo, monumento.getLongitude(), monumento.getLatitude(), monumento.descrizione, 18, "", GoogleMap.MAP_TYPE_SATELLITE);
                            startActivity(intent);

                        }
                    });
                    maps_btn.setLongClickable(true);
                    maps_btn.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            final Intent i = MapsActivity.createIntentOpenGoogleMaps(MonumentiDettagliActivity.this, monumento.titolo, monumento.getLongitude(), monumento.getLatitude(), monumento.descrizione, 18, "", GoogleMap.MAP_TYPE_SATELLITE);
                            startActivity(i);
                            return true;
                        }
                    });
                } else
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

                monumenti_btn_voice.setVisibility(View.GONE);
                engine = new TextToSpeech(MonumentiDettagliActivity.this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        Log.d("Speech", "OnInit - Status [" + status + "]");

                        if (status == TextToSpeech.SUCCESS) {
                            Log.d("Speech", "Success!");
                            engine.setLanguage(Locale.ITALY);
                            monumenti_btn_voice.setVisibility(View.VISIBLE);
                        } else {
                            monumenti_btn_voice.setVisibility(View.GONE);
                            engine = null;
                            Toast.makeText(MonumentiDettagliActivity.this, "Sintesi vocale non disponibile", Toast.LENGTH_LONG).show();

                            // missing data, install it
                            Intent installIntent = new Intent();
                            installIntent.setAction(
                                    TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                            startActivity(installIntent);
                        }
                    }
                });


                monumenti_btn_voice.setOnClickListener(new OnClickListenerViewErrorCheck(MonumentiDettagliActivity.this) {
                    @Override
                    protected void onClickImpl(View v) throws Throwable {
                        try {
                            if (engine == null) return;

                            final String msg = "Sintesi vocale " + monumento.titolo;

                            final OnClickListenerDialogErrorCheck v1 = new OnClickListenerDialogErrorCheck(MonumentiDettagliActivity.this) {
                                @Override
                                protected void onClickImpl(DialogInterface dialog, int which) throws Throwable {
                                    engine.stop();
                                }
                            };
                            final DialogInterface.OnKeyListener v2 = new DialogInterface.OnKeyListener() {
                                @Override
                                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                                        onStop();
                                    }
                                    return true;
                                }
                            };
                            dialog = DialogUtil.openProgressDialog(MonumentiDettagliActivity.this, "Riproduzione in corso", monumento.titolo, "Ok", v1, v2);

                            engine.setPitch(1.0f);
                            engine.setSpeechRate(1f);

                            engine.speak(monumento.titolo + ".\n" + monumento.descrizione_big, TextToSpeech.QUEUE_FLUSH, null);

                        /*final String[] tt = normalizedText.split("[\n\\.]");
                        for (String phrase : tt) {
                            engine.speak(phrase, TextToSpeech.QUEUE_FLUSH, null);
                        }*/
                        } catch (Throwable e) {
                            Toast.makeText(MonumentiDettagliActivity.this, "Sintesi vocale non disponibile", Toast.LENGTH_LONG).show();
                            if (dialog != null)
                                dialog.cancel();
                            dialog = null;
                            if (engine != null) {
                                engine.stop();
                            }

                        }

                    }
                });


            }

        } catch (Throwable e) {
            DialogUtil.openErrorDialog(this, "Errore", "Errore inatteso " + dati.id, e);
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (engine != null) {
            engine.stop();
            engine.shutdown();
            engine = null;
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
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