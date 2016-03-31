package comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.circolari;

import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.InMemoryCacheLayer;
import comune.tivoli.rm.it.ComuneTivoliServer.model.GAE_NotiziaSitoDB_V1;

/**
 * Created by stefano on 13/03/16.
 */
public class InMemoryCacheLayerNotiziaSitoDB extends InMemoryCacheLayer<String, GAE_NotiziaSitoDB_V1> {
    public InMemoryCacheLayerNotiziaSitoDB(MemcacheCacheLayerNotiziaSitoDB next) {
        super(next);
    }



    @Override
    public String getKey(GAE_NotiziaSitoDB_V1 value) {
        return value.getKey();
    }
}
