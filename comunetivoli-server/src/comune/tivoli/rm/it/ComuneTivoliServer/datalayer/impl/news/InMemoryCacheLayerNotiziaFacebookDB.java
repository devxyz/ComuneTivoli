package comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.news;


import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.InMemoryCacheLayer;
import comune.tivoli.rm.it.ComuneTivoliServer.model.GAE_NotiziaFacebook_V0_2;

/**
 * Created by stefano on 13/03/16.
 */
public class InMemoryCacheLayerNotiziaFacebookDB extends InMemoryCacheLayer<String, GAE_NotiziaFacebook_V0_2> {
    public InMemoryCacheLayerNotiziaFacebookDB(MemcacheCacheLayerNotiziaFacebookDB next) {
        super(next);
    }

    @Override
    public String getKey(GAE_NotiziaFacebook_V0_2 value) {
        return value.getKey();
    }
}
