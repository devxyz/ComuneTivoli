package comune.tivoli.rm.it.ComuneTivoli.util;

import android.app.Activity;
import comune.tivoli.rm.it.ComuneTivoli.R;
import comune.tivoli.rm.it.ComuneTivoli.model.ContattiComune;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefano on 01/05/16.
 */
public class ContattiUtil {
    public static ContattiComune findById(List<ContattiComune> cc, int id) {
        for (ContattiComune x : cc) {
            if (x.id == id)
                return x;
        }
        return null;
    }

    public static ArrayList<ContattiComune> elencoContatti(Activity caller) {
        ArrayList<ContattiComune> contatti = new ArrayList<>();
        ContattiComune comune = new ContattiComune(1,
                caller.getResources().getString(R.string.contatti_comune_tivoli_titolo),
                caller.getResources().getString(R.string.contatti_anagrafe_tivoli_descrizione),
                caller.getResources().getString(R.string.contatti_comune_tivoli_telefono),
                caller.getResources().getString(R.string.contatti_comune_tivoli_indirizzo),
                caller.getResources().getString(R.string.contatti_comune_tivoli_email),
                caller.getResources().getString(R.string.contatti_comune_tivoli_maps),
                R.drawable.contatti_maps_comune_anagrafe
        );

        ContattiComune urp = new ContattiComune(2,
                caller.getResources().getString(R.string.contatti_urp_tivoli_titolo),
                caller.getResources().getString(R.string.contatti_urp_tivoli_descrizione),
                caller.getResources().getString(R.string.contatti_urp_tivoli_telefono),
                caller.getResources().getString(R.string.contatti_urp_tivoli_indirizzo),
                caller.getResources().getString(R.string.contatti_urp_tivoli_email),
                caller.getResources().getString(R.string.contatti_urp_tivoli_maps),
                R.drawable.contatti_maps_uffrelazioni
        );

        ContattiComune anagrafe = new ContattiComune(3,
                caller.getResources().getString(R.string.contatti_anagrafe_tivoli_titolo),
                caller.getResources().getString(R.string.contatti_anagrafe_tivoli_descrizione),
                caller.getResources().getString(R.string.contatti_anagrafe_tivoli_telefono),
                caller.getResources().getString(R.string.contatti_anagrafe_tivoli_indirizzo),
                caller.getResources().getString(R.string.contatti_anagrafe_tivoli_email),
                caller.getResources().getString(R.string.contatti_anagrafe_tivoli_maps),
                R.drawable.contatti_maps_comune_anagrafe
        );

        ContattiComune villa_adriana = new ContattiComune(4,
                caller.getResources().getString(R.string.contatti_villa_adriana_titolo),
                caller.getResources().getString(R.string.contatti_villa_adriana_descrizione),
                caller.getResources().getString(R.string.contatti_villa_adriana_telefono),
                caller.getResources().getString(R.string.contatti_villa_adriana_indirizzo),
                caller.getResources().getString(R.string.contatti_villa_adriana_email),
                caller.getResources().getString(R.string.contatti_villa_adriana_maps),
                R.drawable.contatti_maps_urpvillaadriana
        );

        ContattiComune tivoli_terme = new ContattiComune(5,
                caller.getResources().getString(R.string.contatti_tivoli_terme_titolo),
                caller.getResources().getString(R.string.contatti_tivoli_terme_descrizione),
                caller.getResources().getString(R.string.contatti_tivoli_terme_telefono),
                caller.getResources().getString(R.string.contatti_tivoli_terme_indirizzo),
                caller.getResources().getString(R.string.contatti_tivoli_terme_email),
                caller.getResources().getString(R.string.contatti_tivoli_terme_maps),
                R.drawable.contatti_maps_urptivoliterme
        );

        ContattiComune uff_elettorale = new ContattiComune(6,
                caller.getResources().getString(R.string.contatti_uff_elettorale_titolo),
                caller.getResources().getString(R.string.contatti_uff_elettorale_descrizione),
                caller.getResources().getString(R.string.contatti_uff_elettorale_telefono),
                caller.getResources().getString(R.string.contatti_uff_elettorale_indirizzo),
                caller.getResources().getString(R.string.contatti_uff_elettorale_email),
                caller.getResources().getString(R.string.contatti_uff_elettorale_maps),
                R.drawable.contatti_maps_ufficioelettorale
        );

        contatti.add(comune);
        contatti.add(urp);
        contatti.add(anagrafe);
        contatti.add(villa_adriana);
        contatti.add(tivoli_terme);
        contatti.add(uff_elettorale);
        return contatti;
    }
}
