package comune.tivoli.rm.it.ComuneTivoliServer.crawler.notizieWWW;

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
     * link assoluto all'articolo http://xxxxx/node/2576
     */
    public final String absoluteUrl;

    public NotiziaSitoPARSER(String categoria, String titolo, String html, String testo, String absoluteUrl, Date data) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.html = html;
        this.testo = testo;
        this.absoluteUrl = absoluteUrl;
        this.data = data;
    }

    @Override
    public String toString() {
        return "NotiziaWWWComuneTivoli{" +
                "categoria='" + categoria + '\'' +
                ", titolo='" + titolo + '\'' +
                ", testo='" + testo + '\'' +
                ", data=" + data +
                ", url='" + absoluteUrl + '\'' +
                '}';
    }
}
