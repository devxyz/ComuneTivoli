package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    ImageView myactivity_imageView ;
    RelativeLayout rr;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        rr= (RelativeLayout) findViewById(R.id.my_splash);
        rr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MyActivity.this,DebugHomeActivity.class);
                startActivity(i);
            }
        });

        myactivity_imageView =  (ImageView )findViewById(R.id.myactivity_imageView );

        myactivity_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MyActivity.this,DebugHomeActivity.class);
                startActivity(i);


            }
        });

    }
}
