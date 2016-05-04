package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * todo: nei telefonini con android 4.3 non si vede lo sfondo...
 */
public class LoadingActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    ImageView myactivity_imageView;
    RelativeLayout rr;
    private boolean close = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                rr.callOnClick();
            }
        });
        t.start();

        final View.OnClickListener l = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (close) return;
                Intent i = new Intent(LoadingActivity.this, HomeActivity.class);
                startActivity(i);
                finish();

            }
        };

        rr = (RelativeLayout) findViewById(R.id.my_splash);
        myactivity_imageView = (ImageView) findViewById(R.id.myactivity_imageView);

        myactivity_imageView.setOnClickListener(l);
        rr.setOnClickListener(l);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        close = true;
    }
}
