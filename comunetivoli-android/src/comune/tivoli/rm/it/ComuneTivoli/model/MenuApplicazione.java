package comune.tivoli.rm.it.ComuneTivoli.model;

import android.content.Intent;
import comune.tivoli.rm.it.ComuneTivoli.MenuActivity;

/**
 * Created by stefano on 29/04/16.
 */
public class MenuApplicazione {
    public final String titoloMenu;
    public final MenuApplicazioneAction azione;

    public MenuApplicazione(String titoloMenu, MenuApplicazioneAction azione) {
        this.titoloMenu = titoloMenu;
        this.azione = azione;
    }

    public MenuApplicazione(String titoloMenu, final Class activity) {
        this(titoloMenu, new MenuApplicazioneAction() {
            @Override
            public void esegui(MenuActivity a) {
                Intent i = new Intent(a, activity);
                a.startActivity(i);
            }
        });
    }
}
