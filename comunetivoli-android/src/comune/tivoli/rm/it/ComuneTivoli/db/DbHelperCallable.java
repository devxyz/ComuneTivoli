package comune.tivoli.rm.it.ComuneTivoli.db;

import android.content.Context;
import comune.tivoli.rm.it.ComuneTivoli.db.dao.DaoSession;

/**
 * Created by stefano on 09/06/15.
 */
public interface DbHelperCallable<T> {

    public T call(DaoSession session, Context ctx) throws Throwable;
}
