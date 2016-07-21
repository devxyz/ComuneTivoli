package comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.circolari;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.cmd.Loader;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.OfyPersistanceLayer;
import comune.tivoli.rm.it.ComuneTivoliServer.model.NotiziaSitoSERVERDB;
import comune.tivoli.rm.it.ComuneTivoliServer.util.DebugUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefano on 13/03/16.
 */
public class OfyPersistanceLayerNotiziaSitoDB extends OfyPersistanceLayer<String, NotiziaSitoSERVERDB> {
    //ultimo elenco dei dati
    private List<NotiziaSitoSERVERDB> cacheList;
    private int numRead = 0;
    private int numByKey = 0;
    private int numWrite = 0;

    public OfyPersistanceLayerNotiziaSitoDB(Objectify ofy) {
        super(ofy);
    }

    @Override
    public void invalidateImpl() {
        cacheList = null;
    }

    @Override
    protected String _toStatImpl() {
        return "Entities in cache: " + (cacheList == null ? "NULL CACHE" : cacheList.size() + " entities") + "\nnumRead=" + numRead + ", numWrite=" + numWrite + ", numByKey=" + numByKey;
    }

    @Override
    protected NotiziaSitoSERVERDB _getImpl(String key) {
        if (cacheList != null) {
            for (NotiziaSitoSERVERDB x : cacheList) {
                if (x.getKey().equals(key))
                    return x;
            }
            cacheList = null;
        }

        final Loader load = ofy.load();
        DebugUtil.debug(getClass().getSimpleName(), "GET BY ID ", key);
        final Key<NotiziaSitoSERVERDB> k = Key.create(NotiziaSitoSERVERDB.class, key);
        numByKey++;
        return load.key(k).now();
    }

    @Override
    protected List<String> _allKeys() {
        if (cacheList == null) {
            final Loader load = ofy.load();
            cacheList = load.type(NotiziaSitoSERVERDB.class).list();
            numRead++;
        }

        DebugUtil.debug(getClass().getSimpleName(), "ALLKEYS");
        List<String> ris = new ArrayList<>(cacheList.size());
        for (NotiziaSitoSERVERDB x : cacheList) {
            ris.add(x.getKey());
        }
        return ris;


    }

    @Override
    protected void _insertImpl(String key, NotiziaSitoSERVERDB value) {
        DebugUtil.debug(getClass().getSimpleName(), "SAVE BY ID ", key);
        ofy.save().entity(value).now();
        numWrite++;
        cacheList = null;
    }

    @Override
    protected void _updateImpl(String key, NotiziaSitoSERVERDB value) {
        DebugUtil.debug(getClass().getSimpleName(), "UPDATE BY ID ", key);
        ofy.save().entity(value).now();
        numWrite++;
        cacheList = null;
    }

    @Override
    protected void _removeByKeyImpl(String key) {
        DebugUtil.debug(getClass().getSimpleName(), "REMOVE BY ID ", key);
        ofy.delete().entity(get(key)).now();
        numWrite++;
        cacheList = null;
    }

    @Override
    public String getKey(NotiziaSitoSERVERDB value) {
        return value.getKey();
    }

}
