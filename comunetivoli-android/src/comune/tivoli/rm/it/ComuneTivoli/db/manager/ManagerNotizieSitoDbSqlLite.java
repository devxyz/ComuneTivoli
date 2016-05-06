package comune.tivoli.rm.it.ComuneTivoli.db.manager;

import comune.tivoli.rm.it.ComuneTivoli.db.dao.DaoSession;
import comune.tivoli.rm.it.ComuneTivoli.db.dao.NotizieSitoDbSqlLite;
import comune.tivoli.rm.it.ComuneTivoli.db.dao.NotizieSitoDbSqlLiteDao;
import comune.tivoli.rm.it.ComuneTivoliCommon.data.CommonNotiziaSito;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by stefano on 06/05/16.
 */
public class ManagerNotizieSitoDbSqlLite {
    private static List<NotizieSitoDbSqlLite> cache;


    public List<NotizieSitoDbSqlLite> list(DaoSession session) {
        if (cache == null) {

            final QueryBuilder<NotizieSitoDbSqlLite> q = session.queryBuilder(NotizieSitoDbSqlLite.class);
            q.orderDesc(NotizieSitoDbSqlLiteDao.Properties.Id);
            final Query<NotizieSitoDbSqlLite> build = q.build();
            final List<NotizieSitoDbSqlLite> list = build.list();
            cache = new ArrayList<>(list);
        }
        return Collections.unmodifiableList(cache);
    }

    public long maxToken(DaoSession session) {
        final QueryBuilder<NotizieSitoDbSqlLite> q = session.queryBuilder(NotizieSitoDbSqlLite.class);
        q.orderDesc(NotizieSitoDbSqlLiteDao.Properties.Token);
        q.limit(1);
        final Query<NotizieSitoDbSqlLite> build = q.build();
        final List<NotizieSitoDbSqlLite> list = build.list();
        long i = list.size();
        if (i == 0) return -1;//no data
        return list.get(0).getToken();
    }

    public void insertFromServer(DaoSession session, List<CommonNotiziaSito> l) {
        List<NotizieSitoDbSqlLite> x = new ArrayList<>();
        for (CommonNotiziaSito commonNotiziaSito : l) {
            x.add(convert(commonNotiziaSito));
        }
        final NotizieSitoDbSqlLiteDao n = session.getNotizieSitoDbSqlLiteDao();
        n.insertInTx(x);
        cache = null;
    }

    public void update(DaoSession session, NotizieSitoDbSqlLite l) {
        final NotizieSitoDbSqlLiteDao n = session.getNotizieSitoDbSqlLiteDao();
        n.update(l);
    }

    public NotizieSitoDbSqlLite convert(CommonNotiziaSito s) {
        NotizieSitoDbSqlLite x = new NotizieSitoDbSqlLite(null, new Date(), s.getData(), s.getTitolo(), s.getTesto(), s.getHtml(),s.getToken(), s.getUrl(), false, s.getKey());
        return x;
    }
}
