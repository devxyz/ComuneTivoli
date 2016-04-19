package comune.tivoli.rm.it.ComuneTivoli.model;

/**
 * Created by millozzi.stefano on 19/04/2016.
 */
public class MonumentiComune {
    public String titolo;
    public String descrizione;
    public int id_foto;
    public String url;

    public MonumentiComune(String titolo, String descrizione, int id_foto, String url) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.id_foto = id_foto;
        this.url = url;



    }

}
