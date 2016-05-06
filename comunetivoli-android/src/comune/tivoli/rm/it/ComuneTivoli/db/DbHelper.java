package comune.tivoli.rm.it.ComuneTivoli.db;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import comune.tivoli.rm.it.ComuneTivoli.db.dao.DaoMaster;
import comune.tivoli.rm.it.ComuneTivoli.db.dao.DaoSession;

/**
 * Created by stefano on 27/04/15.
 */
public class DbHelper {
    final DaoSession session;
    private final DaoMaster.DevOpenHelper helper;
    private final DaoMaster daoMaster;
    private Context ctx;

    public DbHelper(Context ctx) {
        this.ctx = ctx;
        helper = new DaoMaster.DevOpenHelper(ctx, "fermi_tivoli_db", null);


        SQLiteDatabase db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        session = daoMaster.newSession();
    }

    public static void runOneTransactionSync(Activity ctx, final DBHelperRunnable run) throws Throwable {
        final DbHelper db = new DbHelper(ctx);
        try {
            db.runInTransaction(run);
        } finally {
            db.close();
        }
    }

    public static <T> T runOneTransactionSync(Activity ctx, final DbHelperCallable<T> run) throws Throwable {
        final DbHelper db = new DbHelper(ctx);
        try {
            return db.runInTransaction(run);
        } finally {
            db.close();
        }
    }




    public synchronized void close() {
        session.clear();
        daoMaster.getDatabase().close();
        helper.close();
    }

    public synchronized void runInTransaction(final DBHelperRunnable run) throws Throwable {
        MyRunnable r = new MyRunnable(run, session);
        session.runInTx(r);
        if (r.error != null)
            throw r.error;
    }

    public synchronized <T> T runInTransaction(final DbHelperCallable<T> run) throws Throwable {
        final DaoSession session = daoMaster.newSession();
        try {
            MyCallable<T> r = new MyCallable<T>(run, session);
            session.runInTx(r);
            if (r.error != null)
                throw r.error;
            else
                return r.result;
        } finally {
            session.clear();
        }

    }

    private class MyRunnable implements Runnable {
        private final DBHelperRunnable run;
        private final DaoSession session;
        private Throwable error;

        public MyRunnable(DBHelperRunnable run, DaoSession session) {
            this.run = run;
            this.session = session;
        }

        @Override
        public void run() {
            try {
                run.run(session, ctx);
            } catch (Throwable throwable) {
                error = throwable;
                throw new IllegalArgumentException(throwable);
            }
        }
    }

    private class MyCallable<T> implements Runnable {
        private final DbHelperCallable<T> run;
        private final DaoSession session;
        private Throwable error;
        private T result;

        public MyCallable(DbHelperCallable<T> run, DaoSession session) {
            this.run = run;
            this.session = session;
        }

        @Override
        public void run() {
            try {
                result = run.call(session, ctx);
            } catch (Throwable throwable) {
                error = throwable;
                throw new IllegalArgumentException(throwable);
            }
        }
    }
}
