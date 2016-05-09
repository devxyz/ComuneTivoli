package comune.tivoli.rm.it.ComuneTivoli.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.*;

import java.util.Arrays;

/**
 * Created by stefano on 24/04/16.
 */
public class TemplateUtil {
    public static boolean ENABLE_LAYOUT_DECORATED = true;

    public static void inizializzaActivity(final Activity a, String label, int id_layout, int id_layout_decorated) {

        if (ENABLE_LAYOUT_DECORATED) {
            a.setContentView(id_layout_decorated);
        } else {
            a.setContentView(id_layout);
        }

        final ImageButton template_btn_sx = (ImageButton) a.findViewById(R.id.template_btn_sx);
        final ImageButton template_btn_dx = (ImageButton) a.findViewById(R.id.template_btn_dx);
        final ImageButton template_rotate = (ImageButton) a.findViewById(R.id.template_rotate);
        final TextView testo = (TextView) a.findViewById(R.id.template_titolo);
        if (testo != null)
            testo.setText(label);
        PackageManager p = a.getPackageManager();

        try {
            final ActivityInfo ax = p.getActivityInfo(new ComponentName(a, a.getClass()),PackageManager.GET_META_DATA);
            if (ax.screenOrientation==ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                    ||ax.screenOrientation==ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
                template_rotate.setVisibility(View.INVISIBLE);
            }

        } catch (PackageManager.NameNotFoundException e) {
        }

        if (template_btn_dx != null) {

            if (a.getClass().equals(HomeActivity.class)) {
                template_btn_dx.setImageDrawable(a.getResources().getDrawable(R.drawable.icona_trasparente));
            }

            template_btn_dx.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (a.getClass().equals(HomeActivity.class)) return;
/*
                    Intent i = new Intent(a, HomeActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    a.startActivity(i);
                    */
                    a.finish();
                }
            });
        }

        final View.OnClickListener l = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(a, MenuActivity.class);
                a.startActivity(i);
            }
        };

        if (template_btn_sx != null) {
            template_btn_sx.setOnClickListener(l);
        }

        if (template_rotate != null) {
            template_rotate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (a.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                        a.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    } else if (a.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        a.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    }
                }
            });
        }

        if (testo != null) {
            testo.setOnClickListener(l);
        }

    }
}
