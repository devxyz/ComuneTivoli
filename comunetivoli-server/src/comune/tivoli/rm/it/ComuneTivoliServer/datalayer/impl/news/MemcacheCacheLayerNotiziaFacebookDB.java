package comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.news;

import com.google.appengine.api.memcache.MemcacheService;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.MemcacheCacheLayer;
import comune.tivoli.rm.it.ComuneTivoliServer.model.GAE_NotiziaFacebook_V0_2;

/**
 * Created by stefano on 13/03/16.
 */
public class MemcacheCacheLayerNotiziaFacebookDB extends MemcacheCacheLayer<String, GAE_NotiziaFacebook_V0_2> {
    public MemcacheCacheLayerNotiziaFacebookDB(MemcacheService mcservice, OfyPersistanceLayerNotiziaFacebookDB next) {
        super(mcservice, next);
    }

    @Override
    public String getKey(GAE_NotiziaFacebook_V0_2 value) {
        return value.getKey();
    }
}
