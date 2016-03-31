package comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.news;


import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.InMemoryCacheLayer;
import comune.tivoli.rm.it.ComuneTivoliServer.model.GAE_NotiziaFacebook_V0_1;

/**
 * Created by stefano on 13/03/16.
 */
public class InMemoryCacheLayerNotiziaFacebookDB extends InMemoryCacheLayer<String, GAE_NotiziaFacebook_V0_1> {
    public InMemoryCacheLayerNotiziaFacebookDB(MemcacheCacheLayerNotiziaFacebookDB next) {
        super(next);
    }

    @Override
    public String getKey(GAE_NotiziaFacebook_V0_1 value) {
        return value.getKey();
    }
}
