package comune.tivoli.rm.it.ComuneTivoliServer.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import comune.tivoli.rm.it.ComuneTivoliServer.ServerConfiguration;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.CacheItem;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by stefano on 01/08/15.
 */
@Entity
public class GAE_EventiSitoDB_V2 implements Serializable, CacheItem<String> {
    public long token;
    public String titolo;
    public String testo;
    public String categoria;
    public String html;
    public Date data;
    public int version = ServerConfiguration.PERISTENCE_VERSION_NUMBER;
    @Id
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

    public GAE_EventiSitoDB_V2() {
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

    private void _assert(boolean cond) {
        if (!cond)
            throw new AssertionError("ERROR");
    }

    public void check() {
        _assert(token >= 0);
        _assert(titolo != null);
        _assert(data != null);
        _assert(key != null);
    }

    @Override
    public String toString() {
        return "GAE_CircolareDB{" +
                "token=" + token +
                ", titolo='" + titolo + '\'' +
                ", testo='" + "...(NON INSERITO NELLA STAMPA)..." + '\'' +
                ", html=" + html +
                ", data=" + data +
                ", key='" + key + '\'' +
                ", url='" + urlPrint + '\'' +
                ", flagDelete=" + flagDelete +
                '}';
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

    public GAE_EventiSitoDB_V2 clone() {
        final GAE_EventiSitoDB_V2 c = new GAE_EventiSitoDB_V2();
        c.titolo = titolo;
        c.testo = testo;
        c.data = data;
        c.key = key;
        c.urlPrint = urlPrint;
        c.token = token;
        return c;
    }
}
