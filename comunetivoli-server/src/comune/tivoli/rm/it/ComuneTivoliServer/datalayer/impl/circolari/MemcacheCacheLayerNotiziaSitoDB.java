package comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.circolari;

import com.google.appengine.api.memcache.MemcacheService;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.MemcacheCacheLayer;
import comune.tivoli.rm.it.ComuneTivoliServer.model.GAE_NotiziaSitoDB_V2;

/**
 * Created by stefano on 13/03/16.
 */
public class MemcacheCacheLayerNotiziaSitoDB extends MemcacheCacheLayer<String, GAE_NotiziaSitoDB_V2> {


    public MemcacheCacheLayerNotiziaSitoDB(MemcacheService mcservice, OfyPersistanceLayerNotiziaSitoDB next) {
        super(mcservice, next);
    }

    @Override
    public String getKey(GAE_NotiziaSitoDB_V2 value) {
        return value.getKey();
    }
}
