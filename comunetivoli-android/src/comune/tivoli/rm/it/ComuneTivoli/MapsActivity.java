package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import comune.tivoli.rm.it.ComuneTivoli.guicomponents.DialogUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.IntentUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

/**
 * done: implementare mappa su singolo punto, con possibilità di avviare maps esterno e navigatore
 * todo: aggiungere avvio del navigatore tra le opzioni del menu FATTO
 */

// TODO: 10/05/16 - verifica correttezza OK
public class MapsActivity extends Activity implements OnMapReadyCallback {
    TextView maps_text_titolo;

    MapsActivityDati dati;
    private MapFragment mapFragment;
    private MapOperation operation = null;
    private boolean init = false;

    /**
     * GoogleMap.MAP_TYPE_SATELLITE o MAP_TYPE_TERRAIN
     */
    public static Intent createIntentMapsActivity(Activity a, String titolo, double longitudine, double latitudine, String descrizione, int zoom, String indirizzo, int mapType) {
        MapsActivityDati dati = new MapsActivityDati(longitudine, latitudine, zoom, titolo, descrizione, indirizzo, mapType);
        return dati.toIntent(a);
    }

    public static Intent createIntentOpenGoogleMaps(Activity a, String titolo, double longitudine, double latitudine, String descrizione, int zoom, String indirizzo, int mapType) {
        Intent mapsIntent;
        mapsIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:0,0?q=" + latitudine + "," + longitudine + "(" + Uri.encode(titolo) + ")" + "&z=16&"));
        return mapsIntent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dati = new MapsActivityDati(savedInstanceState, getIntent());

        TemplateUtil.inizializzaActivity(this, "Mappa", R.layout.maps_activity, R.layout.maps_activity_decorated);


        maps_text_titolo = (TextView) findViewById(R.id.maps_text_titolo);
        mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);


        final View.OnClickListener informazioni = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtil.openChooseDialog(MapsActivity.this, "Scegli l'opzione",
                        new CharSequence[]{"Vista Satellite", "Vista Stradale", "Centra Mappa", "Apri con Maps", "Apri navigatore", "Apri streetview", "Informazioni", "Chiudi"},
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        operation = new MapOperation() {
                                            @Override
                                            public void doSome(GoogleMap map) {
                                                map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                                            }
                                        };
                                        mapFragment.getMapAsync(MapsActivity.this);
                                        break;
                                    case 1:
                                        operation = new MapOperation() {
                                            @Override
                                            public void doSome(GoogleMap map) {
                                                map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                                            }
                                        };
                                        mapFragment.getMapAsync(MapsActivity.this);
                                        break;
                                    case 2:
                                        operation = new MapOperation() {
                                            @Override
                                            public void doSome(GoogleMap map) {
                                                LatLng pos = new LatLng(dati.latitudine, dati.longitudine);
                                                map.moveCamera(CameraUpdateFactory.newLatLngZoom(pos, 16));

                                            }
                                        };
                                        mapFragment.getMapAsync(MapsActivity.this);
                                        break;
                                    case 3:
                                        Intent mapsIntent;
                                        mapsIntent = new Intent(Intent.ACTION_VIEW,
                                                Uri.parse("geo:0,0?q=" + dati.latitudine + "," + dati.longitudine + "(" + Uri.encode(dati.titolo) + ")" + "&z=16&"));
                                        startActivity(mapsIntent);

                                        break;
                                    case 4:
                                        Intent navigator;
                                        navigator = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + dati.indirizzo));
                                        startActivity(navigator);
                                        break;
                                    case 5: {
                                        Intent streetView = new Intent(Intent.ACTION_VIEW, Uri.parse("google.streetview:cbll=" + dati.latitudine + "," + dati.longitudine + "&cbp=1,10,,1,1&mz=10"));
                                        startActivity(streetView);

                                    }
                                    break;
                                    case 6:
                                        DialogUtil.openInfoDialog(MapsActivity.this,
                                                "Informazioni",
                                                dati.descrizione + "\n" +
                                                        dati.indirizzo + "\n" +
                                                        "\nLat-Long:" + dati.latitudine + ", " + dati.longitudine + "");
                                        break;
                                    default:
                                        dialog.dismiss();
                                        break;
                                }
                            }
                        }, null);


            }
        };
        maps_text_titolo.setOnClickListener(informazioni);
        maps_text_titolo.setText(dati.titolo);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap map) {
        if (!init) {
            LatLng pos = new LatLng(dati.latitudine, dati.longitudine);
            map.setMapType(dati.mapType);
            map.setMyLocationEnabled(true);
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(pos, dati.zoom));


            final Marker marker = map.addMarker(new MarkerOptions()
                    .title(dati.titolo)
                    .snippet(dati.indirizzo)
                    .position(pos));
            marker.showInfoWindow();
        }
        init = true;
        if (operation != null) {
            operation.doSome(map);
            operation = null;
        }

    }

    private interface MapOperation {
        void doSome(GoogleMap map);
    }

    private static class MapsActivityDati {
        public static final String LABEL_TITOLO = "titolo";
        public static final String LABEL_DESCRIZIONE = "descrizione";
        public static final String LABEL_INDIRIZZO = "indirizzo";
        public static final String LABEL_ZOOM = "zoom";
        public static final String LABEL_LONGITUDINE = "longitudine";
        public static final String LABEL_LATITUDINE = "latitudine";
        public static final String LABEL_MAPTYPE = "map-type";

        final double longitudine;
        final double latitudine;
        final int zoom;
        final String titolo;
        final String descrizione;
        final String indirizzo;
        /**
         * GoogleMap.MAP_TYPE_SATELLITE o MAP_TYPE_TERRAIN
         */
        final int mapType;

        public MapsActivityDati(Bundle savedInstanceState, Intent i) {
            longitudine = IntentUtil.getExtraDouble(i, savedInstanceState, LABEL_LONGITUDINE, 0);
            zoom = IntentUtil.getExtraInt(i, savedInstanceState, LABEL_ZOOM, 0);
            mapType = IntentUtil.getExtraInt(i, savedInstanceState, LABEL_MAPTYPE, GoogleMap.MAP_TYPE_TERRAIN);
            latitudine = IntentUtil.getExtraDouble(i, savedInstanceState, LABEL_LATITUDINE, 0);
            titolo = IntentUtil.getExtraString(i, savedInstanceState, LABEL_TITOLO, null);
            descrizione = IntentUtil.getExtraString(i, savedInstanceState, LABEL_DESCRIZIONE, null);
            indirizzo = IntentUtil.getExtraString(i, savedInstanceState, LABEL_INDIRIZZO, null);
        }

        public MapsActivityDati(double longitudine, double latitudine, int zoom, String titolo, String descrizione, String indirizzo, int mapType) {
            this.longitudine = longitudine;
            this.latitudine = latitudine;
            this.zoom = zoom;
            this.titolo = titolo;
            this.descrizione = descrizione;
            this.indirizzo = indirizzo;
            this.mapType = mapType;
        }

        public void saveTo(Bundle a) {
            a.putString(LABEL_TITOLO, titolo);
            a.putDouble(LABEL_LONGITUDINE, longitudine);
            a.putDouble(LABEL_LATITUDINE, latitudine);
            a.putString(LABEL_DESCRIZIONE, descrizione);
            a.putString(LABEL_INDIRIZZO, indirizzo);
            a.putInt(LABEL_MAPTYPE, mapType);
            a.putInt(LABEL_ZOOM, zoom);
        }

        public Intent toIntent(Activity a) {

            Bundle b = new Bundle();
            saveTo(b);

            Intent i = new Intent(a, MapsActivity.class);
            i.putExtras(b);
            return i;

        }
    }
}