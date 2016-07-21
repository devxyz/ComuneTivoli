package comune.tivoli.rm.it.ComuneTivoliCommon.data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by stefano on 01/08/15.
 */

public class EventoSitoDTO implements Serializable {
    public long token;
    public String titolo;
    public String testo;
    public String categoria;
    public String html;
    public Date data;
    public int version;
    public String key;
    /**
     * url pagina print
     */
    public String urlPrint;
    /**
     * url pagina originale
     */
    public String urlOriginal;
    public boolean flagDelete;

    public EventoSitoDTO() {
        flagDelete = false;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUrlOriginal() {
        return urlOriginal;
    }

    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }


    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }


    public long getToken() {
        return token;
    }

    public void setToken(long token) {
        this.token = token;
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getUrlPrint() {
        return urlPrint;
    }

    public void setUrlPrint(String urlPrint) {
        this.urlPrint = urlPrint;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


}
