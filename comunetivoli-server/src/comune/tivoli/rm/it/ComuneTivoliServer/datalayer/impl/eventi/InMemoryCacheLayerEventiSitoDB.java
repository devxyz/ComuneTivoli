package comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.eventi;

import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.InMemoryCacheLayer;
import comune.tivoli.rm.it.ComuneTivoliServer.model.EventoSitoSERVERDB;

/**
 * Created by stefano on 13/03/16.
 */
public class InMemoryCacheLayerEventiSitoDB extends InMemoryCacheLayer<String, EventoSitoSERVERDB> {
    public InMemoryCacheLayerEventiSitoDB(MemcacheCacheLayerEventiSitoDB next) {
        super(next);
    }



    @Override
    public String getKey(EventoSitoSERVERDB value) {
        return value.getKey();
    }
}
