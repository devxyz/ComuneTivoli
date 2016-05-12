package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.squareup.picasso.Picasso;
import comune.tivoli.rm.it.ComuneTivoli.util.IntentUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by millozzi.stefano on 22/04/2016.
 */
public class ImageScrollActivity extends Activity {
    private ImageScrollActivityData data;

    public static Intent prepareIntent(Activity caller, List<String> imgUrlList) {
        ImageScrollActivityData dati = new ImageScrollActivityData(imgUrlList);
        return dati.toIntent(caller);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TemplateUtil.inizializzaActivity(this, "*" + "Home", R.layout.imagescroll, R.layout.imagescroll_decorated);
        data = new ImageScrollActivityData(savedInstanceState, getIntent());

        List<String> imgurl;
        imgurl = new ArrayList<>(data.imgUrlList);

        final int e = this.getWindow().getDecorView().getHeight();

        LinearLayout layout = (LinearLayout) findViewById(R.id.linear);
        HorizontalScrollView horizontal_scroll = (HorizontalScrollView) findViewById(R.id.horizontal_scroll);
        for (int i = 0; i < imgurl.size(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setPadding(20, 0, 0, 0);
            imageView.setId(i);
            imageView.setPadding(10, 2, 2, 2);
            /*imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), R.drawable.logo_scuola_500x500));
            imageView.setScaleType(ImageView.ScaleType.CENTER);*/
            layout.addView(imageView);


            Picasso.with(this).load(imgurl.get(i))
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


    public static class ImageScrollActivityData {
        public static final String LABEL_SIZE = "size";
        public final ArrayList<String> imgUrlList;

        public ImageScrollActivityData(Bundle savedInstanceState, Intent ix) {
            int size = IntentUtil.getExtraInt(ix, savedInstanceState, LABEL_SIZE, 0);
            imgUrlList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                final String extraString = IntentUtil.getExtraString(ix, savedInstanceState, LABEL_IMG_I(i), "");
                imgUrlList.add(extraString);
            }

        }

        public ImageScrollActivityData(List<String> imgUrlList) {
            this.imgUrlList = new ArrayList<>(imgUrlList);
        }

        public static String LABEL_IMG_I(int i) {
            return "img_" + i;
        }

        public void saveTo(Bundle b) {
            b.putInt(LABEL_SIZE, imgUrlList.size());
            for (int i = 0; i < imgUrlList.size(); i++) {
                b.putString(LABEL_IMG_I(i), imgUrlList.get(i));
            }
        }

        public Intent toIntent(Activity a) {
            Bundle b = new Bundle();
            saveTo(b);

            Intent i = new Intent(a, ImageScrollActivity.class);
            i.putExtras(b);
            return i;
        }
    }
}