package comune.tivoli.rm.it.ComuneTivoli.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by millozzi.stefano on 19/04/2016.
 */
public class MonumentiComune {
    public final String titolo;
    public final String descrizione;
    public final String descrizione_big;
    public final int foto_small;
    public final int foto_big;
    public final String latitudineLongitudineMaps;
    public final String video;
    public final String tred;
    public final String url;
    public final String categoria;
    public final List<String> galleriaFoto;

    public MonumentiComune(String titolo, String descrizione, String descrizione_big, int foto_small, int foto_big, String url, String latitudineLongitudineMaps, String tred, String video, String categoria, String urlGalleriaConcatenata) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.descrizione_big = descrizione_big;
        this.tred = tred;
        this.foto_small = foto_small;
        this.latitudineLongitudineMaps = latitudineLongitudineMaps;
        this.foto_big = foto_big;
        this.url = url;
        this.video = video;
        this.categoria = categoria;

        List<String> gf = new ArrayList<>();
        final String[] split = urlGalleriaConcatenata.split("[\n ]+");
        for (String s : split) {
            gf.add(s.trim());
        }
        galleriaFoto = Collections.unmodifiableList(gf);
    }

    public double getLongitude() {
        return __parsingCoordinate(1);
    }

    public double getLatitude() {
        return __parsingCoordinate(0);
    }

    /**
     * ritorna la coordinata dell'indice specificato, se presente.
     *
     * @param v
     * @return
     */
    private double __parsingCoordinate(int v) {
        if (latitudineLongitudineMaps.length() == 0) return -1;
        final String[] split = latitudineLongitudineMaps.split(",");
        try {
            return Double.parseDouble(split[v]);
        } catch (Throwable e) {
            return -1;
        }
    }

}
