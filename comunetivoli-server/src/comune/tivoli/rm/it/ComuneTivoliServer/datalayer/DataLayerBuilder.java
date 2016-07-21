package comune.tivoli.rm.it.ComuneTivoliServer.datalayer;

import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.circolari.InMemoryCacheLayerNotiziaSitoDB;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.circolari.MemcacheCacheLayerNotiziaSitoDB;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.circolari.OfyPersistanceLayerNotiziaSitoDB;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.news.InMemoryCacheLayerNotiziaFacebookDB;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.news.MemcacheCacheLayerNotiziaFacebookDB;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.news.OfyPersistanceLayerNotiziaFacebookDB;
import comune.tivoli.rm.it.ComuneTivoliServer.model.NotiziaFacebookSERVERDB;
import comune.tivoli.rm.it.ComuneTivoliServer.model.NotiziaSitoSERVERDB;

import java.util.List;

public class DataLayerBuilder {
    private static InMemoryCacheLayerNotiziaSitoDB loaderNewsSito;
    private static InMemoryCacheLayerNotiziaFacebookDB loaderNewsFacebook;

    private static MemcacheService memcache;
    private static Objectify ofy;

    public static InMemoryCacheLayerNotiziaSitoDB getLoaderNewsSito() {
        if (loaderNewsSito == null) {
            init();
            loaderNewsSito = new InMemoryCacheLayerNotiziaSitoDB(new MemcacheCacheLayerNotiziaSitoDB(memcache, new OfyPersistanceLayerNotiziaSitoDB(ofy)));
        }
        return loaderNewsSito;
    }

    public static InMemoryCacheLayerNotiziaFacebookDB getLoaderNewsFacebook() {
        if (loaderNewsFacebook == null) {
            init();
            loaderNewsFacebook = new InMemoryCacheLayerNotiziaFacebookDB(new MemcacheCacheLayerNotiziaFacebookDB(memcache, new OfyPersistanceLayerNotiziaFacebookDB(ofy)));
        }
        return loaderNewsFacebook;
    }

    private static void init() {
        if (memcache == null)
            memcache = MemcacheServiceFactory.getMemcacheService();
        if (ofy == null)
            ofy = ObjectifyService.ofy();
    }

    public static long maxToken() {
        long max = 0;
        final List<NotiziaSitoSERVERDB> gae_circolareDB_v2s = getLoaderNewsSito().allEntities();
        for (NotiziaSitoSERVERDB x : gae_circolareDB_v2s) {
            max = Math.max(max, x.getToken());
        }

        final List<NotiziaFacebookSERVERDB> gae_newsDB_v2s = getLoaderNewsFacebook().allEntities();
        for (NotiziaFacebookSERVERDB x : gae_newsDB_v2s) {
            max = Math.max(max, x.getToken());
        }
        return max;
    }

}
