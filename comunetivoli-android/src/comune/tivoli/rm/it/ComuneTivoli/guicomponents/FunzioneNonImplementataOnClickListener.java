package comune.tivoli.rm.it.ComuneTivoli.guicomponents;

import android.app.Activity;
import android.view.View;

/**
 * Created by stefano on 15/05/16.
 */
public class FunzioneNonImplementataOnClickListener implements View.OnClickListener {
    private final Activity context;

    public FunzioneNonImplementataOnClickListener(Activity context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {

        DialogUtil.openInfoDialog(context, "Funzione non ancora disponibile", "Funzionalita' disponibile a breve.");
    }
}
