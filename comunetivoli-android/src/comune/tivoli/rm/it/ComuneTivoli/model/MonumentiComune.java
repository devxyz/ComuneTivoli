package comune.tivoli.rm.it.ComuneTivoli.model;

import android.graphics.drawable.Drawable;

/**
 * Created by millozzi.stefano on 19/04/2016.
 */
public class MonumentiComune {
    public String titolo;
    public String descrizione;
    public Drawable foto_small;
    public Drawable foto_big;

    public String url;

    public MonumentiComune(String titolo, String descrizione, Drawable foto_small, Drawable foto_big, String url) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.foto_small = foto_small;
        this.foto_big = foto_big;
        this.url = url;



    }

}
