package comune.tivoli.rm.it.ComuneTivoli.model;

import android.graphics.drawable.Drawable;

/**
 * Created by millozzi.stefano on 19/04/2016.
 */
public class MonumentiComune {
    public String titolo;
    public String descrizione;
    public String descrizione_big;
    public Drawable foto_small;
    public Drawable foto_big;
    public String maps;
    public String tred;
    public String link_web;


    public MonumentiComune(String titolo, String descrizione, String descrizione_big, Drawable foto_small, Drawable foto_big, String link_web, String maps) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.descrizione_big = descrizione;
        this.foto_small = foto_small;
        this.foto_big = foto_big;
        this.link_web = link_web;


    }

}
