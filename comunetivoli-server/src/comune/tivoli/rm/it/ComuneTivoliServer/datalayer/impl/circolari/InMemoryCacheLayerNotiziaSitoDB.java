package comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.circolari;

import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.InMemoryCacheLayer;
import comune.tivoli.rm.it.ComuneTivoliServer.model.NotiziaSitoSERVERDB;

/**
 * Created by stefano on 13/03/16.
 */
public class InMemoryCacheLayerNotiziaSitoDB extends InMemoryCacheLayer<String, NotiziaSitoSERVERDB> {
    public InMemoryCacheLayerNotiziaSitoDB(MemcacheCacheLayerNotiziaSitoDB next) {
        super(next);
    }



    @Override
    public String getKey(NotiziaSitoSERVERDB value) {
        return value.getKey();
    }
}
