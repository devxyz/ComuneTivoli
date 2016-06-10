package comune.tivoli.rm.it.ComuneTivoliServer.crawler;

import java.util.Date;

/**
 * Created
 * TODO: verificare parsing nodo 2633: importata solo la lettera a...
 */
public class NotiziaWWWComuneTivoli {
    public final String titolo;
    public final String html;
    public final String testo;
    public final Date data;

    /**
     * link asoluto all'articolo (versione stampabile)
     */
    public final String urlPrint;
    public final String urlSito;

    /**
     * percorso del tipo /node/2576 che identifica l'articolo
     */
    public final String keyPath;

    public NotiziaWWWComuneTivoli(String titolo, String html, String testo, String urlPrint, String urlSito, Date data, String keyPath) {
        this.titolo = titolo;
        this.html = html;
        this.testo = testo;
        this.urlPrint = urlPrint;
        this.urlSito = urlSito;
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
