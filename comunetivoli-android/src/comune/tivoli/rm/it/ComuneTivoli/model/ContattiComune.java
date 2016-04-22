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
    public final String maps;


    public ContattiComune(String titolo, String descrizione, String telefono, String indirizzo, String email, String maps) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.telefono = telefono;
        this.indirizzo = indirizzo;
        this.email = email;
        this.maps=maps;

    }
}
