package comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.news;

import com.google.appengine.api.memcache.MemcacheService;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.MemcacheCacheLayer;
import comune.tivoli.rm.it.ComuneTivoliServer.model.NotiziaFacebookSERVERDB;

/**
 * Created by stefano on 13/03/16.
 */
public class MemcacheCacheLayerNotiziaFacebookDB extends MemcacheCacheLayer<String, NotiziaFacebookSERVERDB> {
    public MemcacheCacheLayerNotiziaFacebookDB(MemcacheService mcservice, OfyPersistanceLayerNotiziaFacebookDB next) {
        super(mcservice, next);
    }

    @Override
    public String getKey(NotiziaFacebookSERVERDB value) {
        return value.getKey();
    }
}
