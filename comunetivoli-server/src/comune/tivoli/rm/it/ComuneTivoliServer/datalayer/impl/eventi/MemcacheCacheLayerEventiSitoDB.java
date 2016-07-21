package comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.eventi;

import com.google.appengine.api.memcache.MemcacheService;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.MemcacheCacheLayer;
import comune.tivoli.rm.it.ComuneTivoliServer.model.EventoSitoSERVERDB;

/**
 * Created by stefano on 13/03/16.
 */
public class MemcacheCacheLayerEventiSitoDB extends MemcacheCacheLayer<String, EventoSitoSERVERDB> {


    public MemcacheCacheLayerEventiSitoDB(MemcacheService mcservice, OfyPersistanceLayerEventiSitoDB next) {
        super(mcservice, next);
    }

    @Override
    public String getKey(EventoSitoSERVERDB value) {
        return value.getKey();
    }
}
