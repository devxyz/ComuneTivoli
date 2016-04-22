package comune.tivoli.rm.it.ComuneTivoli.model;

import android.graphics.drawable.Drawable;

/**
 * Created by stefano on 19/04/16.
 */
public class ContattiComune {
    public final String titolo;
    public final String descrizione;
    public final String telefono;
    public final String indirizzo;
    public final String email;
    public final String maps;
    public final int img;

    public ContattiComune(String titolo, String descrizione, String telefono, String indirizzo, String email, String maps,int img) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.telefono = telefono;
        this.indirizzo = indirizzo;
        this.email = email;
        this.maps=maps;
        this.img = img;

    }
}
