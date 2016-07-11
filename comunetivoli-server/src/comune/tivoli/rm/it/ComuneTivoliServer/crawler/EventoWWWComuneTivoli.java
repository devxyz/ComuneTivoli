package comune.tivoli.rm.it.ComuneTivoliServer.crawler;

import java.util.Date;

/**
 * Created
 */
public class EventoWWWComuneTivoli {
    public final String categoria;
    public final String titolo;
    public final String html;
    public final String testo;
    public final Date dataInizio;
    public final Date dataFine;
    public final String imageUrl;

    /**
     * percorso del tipo /news-ed-eventi/55/tivoli-festival che identifica l'articolo
     */
    public final String keyPath;

    @Override
    public String toString() {
        return "EventoWWWComuneTivoli{" +
                "categoria='" + categoria + '\'' +
                "\ntitolo='" + titolo + '\'' +
                "\ndataInizio=" + dataInizio +
                "\ndataFine=" + dataFine +
                "\nimageUrl='" + imageUrl + '\'' +
                "\ntesto='" + testo + '\'' +
                '}';
    }

    public EventoWWWComuneTivoli(String categoria, String titolo, String html, String testo, Date dataInizio, Date dataFine, String imageUrl, String keyPath) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.html = html;
        this.testo = testo;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.imageUrl = imageUrl;
        this.keyPath = keyPath;
    }
}
