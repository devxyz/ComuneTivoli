package comune.tivoli.rm.it.ComuneTivoli.guicomponents;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Created by stefano on 10/05/16.
 */
public class TooltipUtil {
    /**
     * aggiunge un messaggio in caso di long click
     *
     * @param b
     * @param message
     */
    public static void setTooltipOnLongClick(final Context c, View b, final String message) {
        if (b==null)return ;
        b.setLongClickable(true);
        b.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(c, message, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
