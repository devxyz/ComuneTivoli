package comune.tivoli.rm.it.ComuneTivoli.util;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import comune.tivoli.rm.it.ComuneTivoli.R;
import comune.tivoli.rm.it.ComuneTivoli.model.ContattiComune;

import java.util.ArrayList;

/**
 * Created by millozzi.stefano on 22/04/2016.
 */
public class ImageScrollActivity extends Activity {
    private ArrayList<String> imgurl ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagescroll);
imgurl =new ArrayList<>() ;
        String imgurl = new String(

        );



        LinearLayout layout = (LinearLayout) findViewById(R.id.linear);
        for (int i = 0; i < 5; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setId(i);
            imageView.setPadding(2, 2, 2, 2);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), R.drawable.logoscuola));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            layout.addView(imageView);
        }
    }
}