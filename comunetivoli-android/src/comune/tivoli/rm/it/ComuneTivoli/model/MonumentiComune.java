package comune.tivoli.rm.it.ComuneTivoli.model;

import java.util.ArrayList;

/**
 * Created by millozzi.stefano on 19/04/2016.
 */
public class MonumentiComune {
    public final String titolo;
    public final String descrizione;
    public final String descrizione_big;
    public final int foto_small;
    public final int foto_big;
    public final String maps;
    public final String video;
    public final String tred;
    public final String url;
    public final String categoria;
    public final ArrayList<String> galleriaFoto;


    public MonumentiComune(String titolo, String descrizione, String descrizione_big, int foto_small, int foto_big, String url, String maps, String tred, String video, String categoria, String urlGalleriaConcatenata) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.descrizione_big = descrizione_big;
        this.tred = tred;
        this.foto_small = foto_small;
        this.maps = maps;
        this.foto_big = foto_big;
        this.url = url;
        this.video = video;
        this.categoria = categoria;
        galleriaFoto = new ArrayList<>();
        final String[] split = urlGalleriaConcatenata.split("[\n ]+");
        for (String s : split) {
            galleriaFoto.add(s.trim());

        }
    }

}
