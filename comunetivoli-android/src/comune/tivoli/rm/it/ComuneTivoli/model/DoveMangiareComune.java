package comune.tivoli.rm.it.ComuneTivoli.model;

import android.util.Log;

/**
 * Created by millozzi.stefano on 17/05/2016.
 */
public class DoveMangiareComune {
    public final int id;
    public final String titolo;
    public final String testo;
    public final String indirizzo;
    public final String telefono;
    public final String sito;
    public final String email;
    public final String latitudineLongitudine;
    public final String tripadvisorlink;

    public DoveMangiareComune(int id,String titolo, String testo, String indirizzo, String telefono,String sito, String email, String latitudineLongitudine, String tripadvisorlink) {
        this.id = id;
        this.titolo = titolo;
        this.testo = testo;
        this.sito = sito;
        this.telefono = telefono;
        this.indirizzo = indirizzo;
        this.email = email;
        this.latitudineLongitudine = latitudineLongitudine.trim();
        this.tripadvisorlink = tripadvisorlink;

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
        if (latitudineLongitudine.length() == 0) return -1;
        final String[] split = latitudineLongitudine.split(",");
        try {
            return Double.parseDouble(split[v]);
        } catch (Throwable e) {
            Log.e("Errore ", "PARSING COORDINATE", e);
            return -2;
        }
    }
}
