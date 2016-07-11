package comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.eventi;

import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.InMemoryCacheLayer;
import comune.tivoli.rm.it.ComuneTivoliServer.model.GAE_EventiSitoDB_V2;
import comune.tivoli.rm.it.ComuneTivoliServer.model.GAE_NotiziaSitoDB_V2;

/**
 * Created by stefano on 13/03/16.
 */
public class InMemoryCacheLayerEventiSitoDB extends InMemoryCacheLayer<String, GAE_EventiSitoDB_V2> {
    public InMemoryCacheLayerEventiSitoDB(MemcacheCacheLayerEventiSitoDB next) {
        super(next);
    }



    @Override
    public String getKey(GAE_EventiSitoDB_V2 value) {
        return value.getKey();
    }
}
