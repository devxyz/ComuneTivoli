package comune.tivoli.rm.it.ComuneTivoli.model;

import java.util.Date;

/**
 * Created by millozzi.stefano on 26/04/2016.
 */
@Deprecated
public class NewsComune {
    public String titolo;
    public String descrizione;
    public Date data;
    public String url;

    public NewsComune(String titolo, String descrizione, Date data, String url) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.data = data;
        this.url = url;

    }


}
