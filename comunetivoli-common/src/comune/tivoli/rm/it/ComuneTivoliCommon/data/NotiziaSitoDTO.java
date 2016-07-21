package comune.tivoli.rm.it.ComuneTivoliCommon.data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by stefano on 01/08/15.
 */

public class NotiziaSitoDTO implements Serializable, INotiziaSito {
    private long token;
    private int version;
    private String titolo;
    private String categoria;
    private String testo;
    private String html;
    private Date data;

    private String key;
    private String url;
    private boolean flagDelete;

    public NotiziaSitoDTO(long token, int version, String titolo, String categoria, String testo, String html, Date data, String key, String url, boolean flagDelete) {
        this.token = token;
        this.version = version;
        this.titolo = titolo;
        this.categoria = categoria;
        this.testo = testo;
        this.html = html;
        this.data = data;
        this.key = key;
        this.url = url;
        this.flagDelete = flagDelete;
    }

    public NotiziaSitoDTO() {
        flagDelete = false;
    }

    @Override
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
