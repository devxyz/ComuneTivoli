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
public class EventoSitoSERVERDB implements Serializable, CacheItem<String> {
    public long token;
    public String categoria;
    public String titolo;
    public String html;
    public String testo;
    public Date dataInizio;
    public Date dataFine;
    public String imageUrl;

    /**
     * percorso del tipo /news-ed-eventi/55/tivoli-festival che identifica l'articolo
     */
    public String keyPath;

    public int version = ServerConfiguration.PERISTENCE_VERSION_NUMBER;
    @Id
    public String key;
    public String url;
    public boolean flagDelete;

    public EventoSitoSERVERDB() {
        flagDelete = false;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getKeyPath() {
        return keyPath;
    }

    public void setKeyPath(String keyPath) {
        this.keyPath = keyPath;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


}
