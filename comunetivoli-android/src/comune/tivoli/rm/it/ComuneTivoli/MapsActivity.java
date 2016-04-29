package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

/**
 * Created by millozzi.stefano on 15/03/2016.
 */
@Deprecated
public class MapsActivity extends Activity {
    MapView maps;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps_activity);
        maps = (MapView) findViewById(R.id.mapview);

        GeoPoint point = new GeoPoint(52372991, 4892655);
        OverlayItem overlayItem = new OverlayItem(point, "Amsterdam", null);


       /* itemizedOverlay.addOverlayItem(52372991, 4892655, "Amsterdam");
        itemizedOverlay.addOverlayItem(51501851, -140623, "London");
        itemizedOverlay.addOverlayItem(48857522, 2294496, "Paris");

        maps.getOverlays(overlayItem);*/
    }
}