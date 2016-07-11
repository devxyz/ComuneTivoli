package comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.eventi;

import com.google.appengine.api.memcache.MemcacheService;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.MemcacheCacheLayer;
import comune.tivoli.rm.it.ComuneTivoliServer.model.GAE_EventiSitoDB_V2;

/**
 * Created by stefano on 13/03/16.
 */
public class MemcacheCacheLayerEventiSitoDB extends MemcacheCacheLayer<String, GAE_EventiSitoDB_V2> {


    public MemcacheCacheLayerEventiSitoDB(MemcacheService mcservice, OfyPersistanceLayerEventiSitoDB next) {
        super(mcservice, next);
    }

    @Override
    public String getKey(GAE_EventiSitoDB_V2 value) {
        return value.getKey();
    }
}
