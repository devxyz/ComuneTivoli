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
import comune.tivoli.rm.it.ComuneTivoliServer.model.GAE_NotiziaFacebook_V0_2;
import comune.tivoli.rm.it.ComuneTivoliServer.model.GAE_NotiziaSitoDB_V2;

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
        final List<GAE_NotiziaSitoDB_V2> gae_circolareDB_v2s = getLoaderNewsSito().allEntities();
        for (GAE_NotiziaSitoDB_V2 x : gae_circolareDB_v2s) {
            max = Math.max(max, x.getToken());
        }

        final List<GAE_NotiziaFacebook_V0_2> gae_newsDB_v2s = getLoaderNewsFacebook().allEntities();
        for (GAE_NotiziaFacebook_V0_2 x : gae_newsDB_v2s) {
            max = Math.max(max, x.getToken());
        }
        return max;
    }

}
