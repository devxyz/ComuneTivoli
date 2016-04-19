package comune.tivoli.rm.it.ComuneTivoli.model;

import android.graphics.drawable.Drawable;

/**
 * Created by millozzi.stefano on 19/04/2016.
 */
public class MonumentiComune {
    public String titolo;
    public String descrizione;
    public Drawable foto;
    public String url;

    public MonumentiComune(String titolo, String descrizione, Drawable foto, String url) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.foto = foto;
        this.url = url;



    }

}
