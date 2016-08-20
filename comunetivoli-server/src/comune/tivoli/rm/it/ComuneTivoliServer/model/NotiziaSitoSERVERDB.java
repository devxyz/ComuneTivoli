package comune.tivoli.rm.it.ComuneTivoliServer.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import comune.tivoli.rm.it.ComuneTivoliCommon.data.INotiziaSito;
import comune.tivoli.rm.it.ComuneTivoliServer.ServerConfiguration;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.CacheItem;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by stefano on 01/08/15.
 */
@Entity
public class NotiziaSitoSERVERDB implements Serializable, CacheItem<String>, INotiziaSito {
    public long token;
    public String titolo;
    public String testo;
    public String categoria;
    public String html;
    public Date data;
    public int version = ServerConfiguration.PERISTENCE_VERSION_NUMBER;
    /**
     * url pagina originale
     */
    @Id
    public String url;
    public boolean flagDelete;

    public NotiziaSitoSERVERDB(long token, String titolo, String testo, String categoria, String html, Date data, int version, String url, boolean flagDelete) {
        this.token = token;
        this.titolo = titolo;
        this.testo = testo;
        this.categoria = categoria;
        this.html = html;
        this.data = data;
        this.version = version;

        this.url = url;
        this.flagDelete = flagDelete;
    }

    public NotiziaSitoSERVERDB() {
        flagDelete = false;
    }

    @Override
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }


    @Override
    public String getKey() {
        return url;
    }

    @Override
    public long getToken() {
        return token;
    }

    public void setToken(long token) {
        this.token = token;
    }


    @Override
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    @Override
    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    @Override
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }


    @Override
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
