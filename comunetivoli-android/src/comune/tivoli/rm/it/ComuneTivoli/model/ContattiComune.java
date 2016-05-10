package comune.tivoli.rm.it.ComuneTivoli.model;

import android.util.Log;

/**
 * latitudine in italia e' intorno a 41
 * longitudine intorno a 12
 */
public class ContattiComune {
    public final String titolo;
    public final String descrizione;
    public final String telefono;
    public final String indirizzo;
    public final String email;
    public final String latitudineLongitudineMaps;
    public final int img;

    public ContattiComune(String titolo, String descrizione, String telefono, String indirizzo, String email, String latitudineLongitudineMaps, int img) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.telefono = telefono;
        this.indirizzo = indirizzo;
        this.email = email;
        this.latitudineLongitudineMaps = latitudineLongitudineMaps.trim();
        this.img = img;

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
            Log.e("Errore ", "PARSING", e);
            return -2;
        }
    }

}
