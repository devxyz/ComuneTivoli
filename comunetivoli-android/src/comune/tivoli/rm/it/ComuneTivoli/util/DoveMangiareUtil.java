package comune.tivoli.rm.it.ComuneTivoli.util;

import android.app.Activity;
import comune.tivoli.rm.it.ComuneTivoli.R;
import comune.tivoli.rm.it.ComuneTivoli.model.DoveMangiareComune;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by millozzi.stefano on 17/05/2016.
 */
public class DoveMangiareUtil {
    public static DoveMangiareComune findById(List<DoveMangiareComune> cc, int id) {
        for (DoveMangiareComune x : cc) {
            if (x.id == id)
                return x;
        }
        return null;
    }

    public static ArrayList<DoveMangiareComune> elencoContatti(Activity caller) {
        ArrayList<DoveMangiareComune> dovemangiare = new ArrayList<>();
        DoveMangiareComune il_maniero = new DoveMangiareComune(1,
                caller.getResources().getString(R.string.dovemangiare_il_maniero_titolo),
                caller.getResources().getString(R.string.dovemangiare_il_maniero_testo),
                caller.getResources().getString(R.string.dovemangiare_il_maniero_indirizzo),
                caller.getResources().getString(R.string.dovemangiare_il_maniero_telefono),
                caller.getResources().getString(R.string.dovemangiare_il_maniero_sito),
                caller.getResources().getString(R.string.dovemangiare_il_maniero_email),
                caller.getResources().getString(R.string.dovemangiare_il_maniero_maps),
                caller.getResources().getString(R.string.dovemangiare_il_maniero_tripadvisorlink)
        );
        dovemangiare.add(il_maniero);
        return dovemangiare;
    }
}
