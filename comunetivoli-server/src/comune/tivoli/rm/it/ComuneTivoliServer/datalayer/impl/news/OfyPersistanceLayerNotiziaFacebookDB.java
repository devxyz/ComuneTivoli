package comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.news;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.cmd.Loader;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.OfyPersistanceLayer;
import comune.tivoli.rm.it.ComuneTivoliServer.model.GAE_NotiziaFacebook_V0_1;
import comune.tivoli.rm.it.ComuneTivoliServer.util.DebugUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefano on 13/03/16.
 */
public class OfyPersistanceLayerNotiziaFacebookDB extends OfyPersistanceLayer<String, GAE_NotiziaFacebook_V0_1> {
    //ultimo elenco dei dati
    private List<GAE_NotiziaFacebook_V0_1> cacheList;

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
    protected GAE_NotiziaFacebook_V0_1 _getImpl(String key) {
        if (cacheList != null) {
            for (GAE_NotiziaFacebook_V0_1 x : cacheList) {
                if (x.getKey().equals(key))
                    return x;
            }
            cacheList = null;
        }
        DebugUtil.debug(getClass().getSimpleName(), "GET BY ID ", key);

        final Loader load = ofy.load();
        final Key<GAE_NotiziaFacebook_V0_1> k = Key.create(GAE_NotiziaFacebook_V0_1.class, key);
        numByKey++;
        return load.key(k).now();
    }

    @Override
    protected List<String> _allKeys() {
        if (cacheList == null) {
            final Loader load = ofy.load();
            cacheList = load.type(GAE_NotiziaFacebook_V0_1.class).list();
            numRead++;
        }

        DebugUtil.debug(getClass().getSimpleName(), "ALL KEYS");
        List<String> ris = new ArrayList<>(cacheList.size());
        for (GAE_NotiziaFacebook_V0_1 x : cacheList) {
            ris.add(x.getKey());
        }
        return ris;


    }

    @Override
    protected void _insertImpl(String key, GAE_NotiziaFacebook_V0_1 value) {
        DebugUtil.debug(getClass().getSimpleName(), "INSERT BY ID ", key);
        ofy.save().entity(value).now();
        numWrite++;
        cacheList = null;
    }

    @Override
    protected void _updateImpl(String key, GAE_NotiziaFacebook_V0_1 value) {
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
    public String getKey(GAE_NotiziaFacebook_V0_1 value) {
        return value.getKey();
    }
}
