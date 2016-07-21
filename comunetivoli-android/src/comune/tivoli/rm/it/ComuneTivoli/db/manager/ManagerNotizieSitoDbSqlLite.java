package comune.tivoli.rm.it.ComuneTivoli.db.manager;

import comune.tivoli.rm.it.ComuneTivoli.db.dao.DaoSession;
import comune.tivoli.rm.it.ComuneTivoli.db.dao.NotizieSitoDbSqlLite;
import comune.tivoli.rm.it.ComuneTivoli.db.dao.NotizieSitoDbSqlLiteDao;
import comune.tivoli.rm.it.ComuneTivoliCommon.data.NotiziaSitoDTO;
import de.greenrobot.dao.query.DeleteQuery;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import java.util.*;

/**
 * Created by stefano on 06/05/16.
 */
public class ManagerNotizieSitoDbSqlLite {
    private static List<NotizieSitoDbSqlLite> cache;
    private static Long maxToken = null;
    private static Integer maxVersion = null;

    public void deleteDifferentVersion(DaoSession session, int version) {
        final DeleteQuery<NotizieSitoDbSqlLite> q = session.queryBuilder(NotizieSitoDbSqlLite.class).where(NotizieSitoDbSqlLiteDao.Properties.Version.notEq(version)).buildDelete();
        q.executeDeleteWithoutDetachingEntities();
    }

    public Map<String, NotizieSitoDbSqlLite> mapByKey(DaoSession session) {
        Map<String, NotizieSitoDbSqlLite> ris = new LinkedHashMap<>();
        final List<NotizieSitoDbSqlLite> list = list(session);
        for (NotizieSitoDbSqlLite x : list) {
            ris.put(x.getKey(), x);
        }
        return ris;
    }

    public List<NotizieSitoDbSqlLite> list(DaoSession session) {
        if (cache == null) {

            final QueryBuilder<NotizieSitoDbSqlLite> q = session.queryBuilder(NotizieSitoDbSqlLite.class);
            q.orderDesc(NotizieSitoDbSqlLiteDao.Properties.Token);
            final Query<NotizieSitoDbSqlLite> build = q.build();
            final List<NotizieSitoDbSqlLite> list = build.list();
            cache = new ArrayList<>(list);
        }
        return Collections.unmodifiableList(cache);
    }

    public List<NotizieSitoDbSqlLite> latestNews(DaoSession session, int n) {


        final QueryBuilder<NotizieSitoDbSqlLite> q = session.queryBuilder(NotizieSitoDbSqlLite.class);
        q.orderDesc(NotizieSitoDbSqlLiteDao.Properties.Token).limit(n);
        final Query<NotizieSitoDbSqlLite> build = q.build();
        final List<NotizieSitoDbSqlLite> list = build.list();
        return new ArrayList<>(list);
    }

    public NotizieSitoDbSqlLite listByKey(DaoSession session, String key) {
        final QueryBuilder<NotizieSitoDbSqlLite> q = session.queryBuilder(NotizieSitoDbSqlLite.class);
        q.where(NotizieSitoDbSqlLiteDao.Properties.Key.eq(key));
        q.limit(1);
        final Query<NotizieSitoDbSqlLite> build = q.build();
        final List<NotizieSitoDbSqlLite> list = build.list();
        long i = list.size();
        if (i == 0) return null;
        return list.get(0);

    }

    public long maxToken(DaoSession session) {
        if (maxToken != null) return maxToken;
        final QueryBuilder<NotizieSitoDbSqlLite> q = session.queryBuilder(NotizieSitoDbSqlLite.class);
        q.orderDesc(NotizieSitoDbSqlLiteDao.Properties.Token);
        q.limit(1);
        final Query<NotizieSitoDbSqlLite> build = q.build();
        final List<NotizieSitoDbSqlLite> list = build.list();
        long i = list.size();
        if (i == 0) return -1;//no data
        return maxToken = list.get(0).getToken();
    }

    public int maxVersion(DaoSession session) {
        if (maxVersion != null) return maxVersion;
        final QueryBuilder<NotizieSitoDbSqlLite> q = session.queryBuilder(NotizieSitoDbSqlLite.class);
        q.orderDesc(NotizieSitoDbSqlLiteDao.Properties.Version);
        q.limit(1);
        final Query<NotizieSitoDbSqlLite> build = q.build();
        final List<NotizieSitoDbSqlLite> list = build.list();
        long i = list.size();
        if (i == 0) return -1;//no data
        return maxVersion = list.get(0).getVersion();
    }

    public void insertFromServer(DaoSession session, List<NotiziaSitoDTO> l) {
        List<NotizieSitoDbSqlLite> x = new ArrayList<>();
        for (NotiziaSitoDTO commonNotiziaSito : l) {
            x.add(convert(commonNotiziaSito));
        }
        final NotizieSitoDbSqlLiteDao n = session.getNotizieSitoDbSqlLiteDao();
        n.insertInTx(x);
        _invalidate();
    }

    public void update(DaoSession session, List<NotizieSitoDbSqlLite> l) {
        List<NotizieSitoDbSqlLite> x = new ArrayList<>();
        for (NotizieSitoDbSqlLite commonNotiziaSito : l) {
            x.add(commonNotiziaSito);
        }
        final NotizieSitoDbSqlLiteDao n = session.getNotizieSitoDbSqlLiteDao();
        n.updateInTx(x);
        _invalidate();
    }

    private void _invalidate() {
        cache = null;
        maxToken = null;
        maxVersion = null;
    }

    public void update(DaoSession session, NotizieSitoDbSqlLite l) {
        final NotizieSitoDbSqlLiteDao n = session.getNotizieSitoDbSqlLiteDao();
        n.update(l);
    }

    public NotizieSitoDbSqlLite convert(NotiziaSitoDTO s) {
        NotizieSitoDbSqlLite x = new NotizieSitoDbSqlLite(null, new Date(), s.getData(), s.getTitolo(), s.getTesto(), s.getHtml(), s.getToken(), s.getVersion(), s.getUrl(), false, s.getKey());
        return x;
    }
}
