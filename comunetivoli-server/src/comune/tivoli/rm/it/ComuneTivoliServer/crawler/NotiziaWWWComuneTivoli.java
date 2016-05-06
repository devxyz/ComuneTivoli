package comune.tivoli.rm.it.ComuneTivoliServer.crawler;

import java.util.Date;

/**
 * Created by stefano on 15/04/16.
 */
public class NotiziaWWWComuneTivoli {
    public final String titolo;
    public final String html;
    public final String testo;
    public final Date data;

    /**
     * link asoluto all'articolo (versione stampabile)
     */
    public final String link;

    /**
     * percorso del tipo /node/2576 che identifica l'articolo
     */
    public final String keyPath;

    public NotiziaWWWComuneTivoli(String titolo, String html, String testo, String link, Date data, String keyPath) {
        this.titolo = titolo;
        this.html = html;
        this.testo = testo;
        this.link = link;
        this.data = data;
        this.keyPath = keyPath;
    }

    @Override
    public String toString() {
        return "NotiziaWWWComuneTivoli{" +
                "titolo='" + titolo + '\'' +
                "\n, html='" + html + '\'' +
                "\n, testo='" + testo + '\'' +
                "\n, data=" + data +
                '}';
    }
}
