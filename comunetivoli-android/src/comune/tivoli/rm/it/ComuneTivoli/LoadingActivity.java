package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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

        rr = (RelativeLayout) findViewById(R.id.my_splash);
        rr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (close) return;
                Intent i = new Intent(LoadingActivity.this, DebugHomeActivity.class);
                startActivity(i);
                close = true;
            }
        });

        myactivity_imageView = (ImageView) findViewById(R.id.myactivity_imageView);

        myactivity_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoadingActivity.this, DebugHomeActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);


            }
        });

    }
}
