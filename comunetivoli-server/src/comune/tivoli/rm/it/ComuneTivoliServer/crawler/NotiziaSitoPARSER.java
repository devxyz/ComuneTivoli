package comune.tivoli.rm.it.ComuneTivoliServer.crawler;

import java.util.Date;

/**
 * Created
 * TODO: verificare parsing nodo 2633: importata solo la lettera a...
 */
public class NotiziaSitoPARSER {
    public final String categoria;
    public final String titolo;
    public final String html;
    public final String testo;
    public final Date data;

    /**
     * link assoluto all'articolo (versione stampabile)
     */
    public final String url;

    /**
     * percorso del tipo /node/2576 che identifica l'articolo
     */
    public final String keyPath;

    public NotiziaSitoPARSER(String categoria, String titolo, String html, String testo, String url, Date data, String keyPath) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.html = html;
        this.testo = testo;
        this.url = url;
        this.data = data;
        this.keyPath = keyPath;
    }

    @Override
    public String toString() {
        return "NotiziaWWWComuneTivoli{" +
                "categoria='" + categoria + '\'' +
                ", titolo='" + titolo + '\'' +
                ", testo='" + testo + '\'' +
                ", data=" + data +
                ", keyPath='" + keyPath + '\'' +
                '}';
    }
}
