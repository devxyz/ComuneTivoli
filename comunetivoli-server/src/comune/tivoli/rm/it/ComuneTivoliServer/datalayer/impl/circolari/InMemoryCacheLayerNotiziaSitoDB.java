package comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.circolari;

import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.InMemoryCacheLayer;
import comune.tivoli.rm.it.ComuneTivoliServer.model.GAE_NotiziaSitoDB_V2;

/**
 * Created by stefano on 13/03/16.
 */
public class InMemoryCacheLayerNotiziaSitoDB extends InMemoryCacheLayer<String, GAE_NotiziaSitoDB_V2> {
    public InMemoryCacheLayerNotiziaSitoDB(MemcacheCacheLayerNotiziaSitoDB next) {
        super(next);
    }



    @Override
    public String getKey(GAE_NotiziaSitoDB_V2 value) {
        return value.getKey();
    }
}
