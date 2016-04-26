package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by millozzi.stefano on 22/04/2016.
 */
public class ImageScrollActivity extends Activity {
    private ArrayList<String> imgurl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagescroll);
        imgurl = new ArrayList<>();
        imgurl = new ArrayList<>();
        imgurl.add("http://www.visittivoli.eu/images/piazze/piazza-campitelli.jpg");
        imgurl.add("http://www.visittivoli.eu/images/piazze/piazza-garibaldi.jpg");
        imgurl.add("http://www.visittivoli.eu/images/le-ville/villa-adriana.jpg");
        imgurl.add("http://www.visittivoli.eu/images/le-ville/villa-d-este.jpg");
        imgurl.add("http://www.visittivoli.eu/images/le-ville/villa-gregoriana.jpg");

        final int e = this.getWindow().getDecorView().getHeight();

        LinearLayout layout = (LinearLayout) findViewById(R.id.linear);
        HorizontalScrollView horizontal_scroll = (HorizontalScrollView) findViewById(R.id.horizontal_scroll);
        for (int i = 0; i < imgurl.size(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setPadding(10, 0, 0, 0);
            imageView.setId(i);
            imageView.setPadding(2, 2, 2, 2);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), R.drawable.logoscuola));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            layout.addView(imageView);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), R.drawable.ic_launcher));


            Picasso.with(this).load(imgurl.get(i))
                    .resize(e, (int) (1.6 * e))
                    .into(imageView);

            /*ImageView imageView1 = new ImageView(this);
            imageView1.setId(i);
            imageView1.setPadding(2, 2, 2, 2);
            imageView1.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(),R.drawable.ic_launcher));
            imageView1.setScaleType(ImageView.ScaleType.FIT_XY);
            layout.addView(imageView1);
*/

        }
    }
}