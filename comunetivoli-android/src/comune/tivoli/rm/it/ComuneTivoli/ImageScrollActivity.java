package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import comune.tivoli.rm.it.ComuneTivoli.util.IntentUtil;
import comune.tivoli.rm.it.ComuneTivoli.util.TemplateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by millozzi.stefano on 22/04/2016.
 */
//todo: migliorare galleria immagini
public class ImageScrollActivity extends Activity {
    private TextView txt;
    private TextView titolo;
    private ImageScrollActivityData data;
    private LinearLayout image_linear;

    public static Intent prepareIntent(Activity caller, String titolo, String descrizione, List<String> imgUrlList) {
        ImageScrollActivityData dati = new ImageScrollActivityData(titolo, descrizione, imgUrlList);
        return dati.toIntent(caller);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TemplateUtil.inizializzaActivity(this, "Foto", R.layout.imagescroll, R.layout.imagescroll_decorated);
        data = new ImageScrollActivityData(savedInstanceState, getIntent());

        txt = (TextView) findViewById(R.id.image_text);
        titolo = (TextView) findViewById(R.id.image_titolo);
        image_linear = (LinearLayout) findViewById(R.id.image_linear);
        txt.setText(data.descrizione + " - click prolungato per aprire");
        titolo.setText(data.titolo);

        List<String> imgurl;
        imgurl = new ArrayList<>(data.imgUrlList);


        LinearLayout layout = (LinearLayout) findViewById(R.id.image_linear);

        int padding_up_down = 0;
        int padding_left_right = 0;
        if (image_linear.getOrientation() == LinearLayout.HORIZONTAL) {
            padding_left_right = 5;
            padding_up_down = 0;
        } else {
            padding_left_right = 0;
            padding_up_down = 5;
        }

        for (int i = 0; i < imgurl.size(); i++) {
            final String path = imgurl.get(i);

            ImageView imageView = new ImageView(this);
            imageView.setId(i);
            imageView.setLongClickable(true);

            imageView.setPadding(padding_left_right, padding_up_down, padding_left_right, padding_up_down);
            //imageView.setScaleType(ImageView.ScaleType.FIT_START);
            /*imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), R.drawable.logo_scuola_500x500));
            imageView.setScaleType(ImageView.ScaleType.CENTER);*/
            layout.addView(imageView);
            imageView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    String url = path;
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                    return true;
                }
            });


            Picasso.with(this).load(path).placeholder(R.drawable.icona_picture)
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
        public static final String LABEL_DESCRIZIONE = "descrizione";
        public static final String LABEL_TITOLO = "titolo";
        public final ArrayList<String> imgUrlList;
        public final String descrizione;
        public final String titolo;

        public ImageScrollActivityData(Bundle savedInstanceState, Intent ix) {
            int size = IntentUtil.getExtraInt(ix, savedInstanceState, LABEL_SIZE, 0);
            descrizione = IntentUtil.getExtraString(ix, savedInstanceState, LABEL_DESCRIZIONE, "");
            titolo = IntentUtil.getExtraString(ix, savedInstanceState, LABEL_TITOLO, "");
            imgUrlList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                final String extraString = IntentUtil.getExtraString(ix, savedInstanceState, LABEL_IMG_I(i), "");
                imgUrlList.add(extraString);
            }

        }

        public ImageScrollActivityData(String titolo, String descrizione, List<String> imgUrlList) {
            this.titolo = titolo;
            this.descrizione = descrizione;
            this.imgUrlList = new ArrayList<>(imgUrlList);
        }

        public static String LABEL_IMG_I(int i) {
            return "img_" + i;
        }

        public void saveTo(Bundle b) {
            b.putString(LABEL_TITOLO, titolo);
            b.putString(LABEL_DESCRIZIONE, descrizione);
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