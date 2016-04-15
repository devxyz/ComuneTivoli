package comune.tivoli.rm.it.ComuneTivoliServer.crawler;

import java.util.Date;

/**
 * Created by stefano on 15/04/16.
 */
public class NotiziaWWWComuneTivoli {
    public final String titolo;
    public final String html;
    public final Date data;

    public NotiziaWWWComuneTivoli(String titolo, String html, Date data) {
        this.titolo = titolo;
        this.html = html;
        this.data = data;
    }

    @Override
    public String toString() {
        return "NotiziaWWWComuneTivoli{" +
                "titolo='" + titolo + '\'' +
                "\n, html='" + html + '\'' +
                "\n, data=" + data +
                '}';
    }
}
