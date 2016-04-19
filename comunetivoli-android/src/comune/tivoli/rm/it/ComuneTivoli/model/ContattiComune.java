package comune.tivoli.rm.it.ComuneTivoli.model;

/**
 * Created by stefano on 19/04/16.
 */
public class ContattiComune {
    public final String titolo;
    public final String descrizione;
    public final String telefono;
    public final String indirizzo;
    public final String email;

    public ContattiComune(String titolo, String descrizione, String url, String indirizzo, String email) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.telefono = url;
        this.indirizzo = indirizzo;
        this.email = email;
    }
}
