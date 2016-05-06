package comune.tivoli.rm.it.ComuneTivoliCommon.data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by stefano on 01/08/15.
 */

public class CommonNotiziaSito implements Serializable {
    private long token;
    private String titolo;
    private String testo;
    private Date data;

    private String key;
    private String url;
    private boolean flagDelete;

    public CommonNotiziaSito(long token, String titolo, String testo, Date data, String key, String url, boolean flagDelete) {
        this.token = token;
        this.titolo = titolo;
        this.testo = testo;
        this.data = data;
        this.key = key;
        this.url = url;
        this.flagDelete = flagDelete;
    }

    public CommonNotiziaSito() {
        flagDelete = false;
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
