package comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.news;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.cmd.Loader;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.OfyPersistanceLayer;
import comune.tivoli.rm.it.ComuneTivoliServer.model.NotiziaFacebookSERVERDB;
import comune.tivoli.rm.it.ComuneTivoliServer.util.DebugUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefano on 13/03/16.
 */
public class OfyPersistanceLayerNotiziaFacebookDB extends OfyPersistanceLayer<String, NotiziaFacebookSERVERDB> {
    //ultimo elenco dei dati
    private List<NotiziaFacebookSERVERDB> cacheList;

    private int numRead = 0;
    private int numByKey = 0;
    private int numWrite = 0;

    public OfyPersistanceLayerNotiziaFacebookDB(Objectify ofy) {
        super(ofy);
    }

    @Override
    protected String _toStatImpl() {
        return "Entities in cache: " + (cacheList == null ? "NULL CACHE" : cacheList.size() + " entities") + "\nnumRead=" + numRead + ", numWrite=" + numWrite + ", numByKey=" + numByKey;
    }

    @Override
    public void invalidateImpl() {
        cacheList = null;
    }

    @Override
    protected NotiziaFacebookSERVERDB _getImpl(String key) {
        if (cacheList != null) {
            for (NotiziaFacebookSERVERDB x : cacheList) {
                if (x.getKey().equals(key))
                    return x;
            }
            cacheList = null;
        }
        DebugUtil.debug(getClass().getSimpleName(), "GET BY ID ", key);

        final Loader load = ofy.load();
        final Key<NotiziaFacebookSERVERDB> k = Key.create(NotiziaFacebookSERVERDB.class, key);
        numByKey++;
        return load.key(k).now();
    }

    @Override
    protected List<String> _allKeys() {
        if (cacheList == null) {
            final Loader load = ofy.load();
            cacheList = load.type(NotiziaFacebookSERVERDB.class).list();
            numRead++;
        }

        DebugUtil.debug(getClass().getSimpleName(), "ALL KEYS");
        List<String> ris = new ArrayList<>(cacheList.size());
        for (NotiziaFacebookSERVERDB x : cacheList) {
            ris.add(x.getKey());
        }
        return ris;


    }

    @Override
    protected void _insertImpl(String key, NotiziaFacebookSERVERDB value) {
        DebugUtil.debug(getClass().getSimpleName(), "INSERT BY ID ", key);
        ofy.save().entity(value).now();
        numWrite++;
        cacheList = null;
    }

    @Override
    protected void _updateImpl(String key, NotiziaFacebookSERVERDB value) {
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
    public String getKey(NotiziaFacebookSERVERDB value) {
        return value.getKey();
    }
}
