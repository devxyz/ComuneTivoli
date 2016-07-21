package comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.news;


import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.InMemoryCacheLayer;
import comune.tivoli.rm.it.ComuneTivoliServer.model.NotiziaFacebookSERVERDB;

/**
 * Created by stefano on 13/03/16.
 */
public class InMemoryCacheLayerNotiziaFacebookDB extends InMemoryCacheLayer<String, NotiziaFacebookSERVERDB> {
    public InMemoryCacheLayerNotiziaFacebookDB(MemcacheCacheLayerNotiziaFacebookDB next) {
        super(next);
    }

    @Override
    public String getKey(NotiziaFacebookSERVERDB value) {
        return value.getKey();
    }
}
