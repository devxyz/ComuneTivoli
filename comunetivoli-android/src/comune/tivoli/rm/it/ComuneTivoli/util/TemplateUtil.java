package comune.tivoli.rm.it.ComuneTivoli.util;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.HomeActivity;
import comune.tivoli.rm.it.ComuneTivoli.MenuActivity;
import comune.tivoli.rm.it.ComuneTivoli.R;

/**
 * Created by stefano on 24/04/16.
 */
public class TemplateUtil {
    public static void inizializzaComponentiTemplate(final Activity a, String label) {
        final ImageButton template_btn_sx = (ImageButton) a.findViewById(R.id.template_btn_sx);
        final ImageButton template_btn_dx = (ImageButton) a.findViewById(R.id.template_btn_dx);
        final TextView testo = (TextView) a.findViewById(R.id.template_titolo);
        if (testo != null)
            testo.setText(label);

        if (template_btn_dx != null)
            template_btn_dx.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (a.getClass().equals(HomeActivity.class)) return;

                    Intent i = new Intent(a, HomeActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    a.startActivity(i);
                }
            });

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

        if (testo != null) {
            testo.setOnClickListener(l);
        }

    }
}
