package comune.tivoli.rm.it.ComuneTivoli.model;

import android.graphics.drawable.Drawable;

/**
 * Created by millozzi.stefano on 19/04/2016.
 */
public class MonumentiComune {
    public String titolo;
    public String descrizione;
    public String descrizione_big;
    public int foto_small;
    public int foto_big;
    public String maps;
    public String video;
    public String tred;
    public String url;


    public MonumentiComune(String titolo, String descrizione, String descrizione_big, int foto_small, int foto_big, String url, String maps, String tred, String video) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.descrizione_big = descrizione_big;
        this.tred= tred;
        this.foto_small = foto_small;
        this.maps = maps;
        this.foto_big = foto_big;
        this.url = url;
        this.video = video;


    }

}
