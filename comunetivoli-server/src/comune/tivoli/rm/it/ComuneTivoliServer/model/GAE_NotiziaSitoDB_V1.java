package comune.tivoli.rm.it.ComuneTivoliServer.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.CacheItem;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by stefano on 01/08/15.
 */
@Entity
public class GAE_NotiziaSitoDB_V1 implements Serializable, CacheItem<String> {
    public long token;
    public String titolo;
    public String testo;
    public Date data;

    @Id
    public String key;
    public String url;
    public boolean flagDelete;

    public GAE_NotiziaSitoDB_V1() {
        flagDelete = false;
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
                ", data=" + data +
                ", key='" + key + '\'' +
                ", url='" + url + '\'' +
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

    public GAE_NotiziaSitoDB_V1 clone() {
        final GAE_NotiziaSitoDB_V1 c = new GAE_NotiziaSitoDB_V1();
        c.titolo = titolo;
        c.testo = testo;
        c.data = data;
        c.key = key;
        c.url = url;
        c.token = token;
        return c;
    }
}
