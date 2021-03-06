package comune.tivoli.rm.it.ComuneTivoli.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import comune.tivoli.rm.it.ComuneTivoli.db.dao.NotizieSitoDbSqlLite;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table NOTIZIE_SITO_DB_SQL_LITE.
*/
public class NotizieSitoDbSqlLiteDao extends AbstractDao<NotizieSitoDbSqlLite, Long> {

    public static final String TABLENAME = "NOTIZIE_SITO_DB_SQL_LITE";

    /**
     * Properties of entity NotizieSitoDbSqlLite.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property DataInserimento = new Property(1, java.util.Date.class, "dataInserimento", false, "DATA_INSERIMENTO");
        public final static Property Data = new Property(2, java.util.Date.class, "data", false, "DATA");
        public final static Property Titolo = new Property(3, String.class, "titolo", false, "TITOLO");
        public final static Property Testo = new Property(4, String.class, "testo", false, "TESTO");
        public final static Property Html = new Property(5, String.class, "html", false, "HTML");
        public final static Property Token = new Property(6, long.class, "token", false, "TOKEN");
        public final static Property Version = new Property(7, int.class, "version", false, "VERSION");
        public final static Property Url = new Property(8, String.class, "url", false, "URL");
        public final static Property FlagContenutoLetto = new Property(9, boolean.class, "flagContenutoLetto", false, "FLAG_CONTENUTO_LETTO");
    };


    public NotizieSitoDbSqlLiteDao(DaoConfig config) {
        super(config);
    }
    
    public NotizieSitoDbSqlLiteDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'NOTIZIE_SITO_DB_SQL_LITE' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'DATA_INSERIMENTO' INTEGER NOT NULL ," + // 1: dataInserimento
                "'DATA' INTEGER," + // 2: data
                "'TITOLO' TEXT NOT NULL ," + // 3: titolo
                "'TESTO' TEXT NOT NULL ," + // 4: testo
                "'HTML' TEXT NOT NULL ," + // 5: html
                "'TOKEN' INTEGER NOT NULL ," + // 6: token
                "'VERSION' INTEGER NOT NULL ," + // 7: version
                "'URL' TEXT NOT NULL UNIQUE ," + // 8: url
                "'FLAG_CONTENUTO_LETTO' INTEGER NOT NULL );"); // 9: flagContenutoLetto
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'NOTIZIE_SITO_DB_SQL_LITE'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, NotizieSitoDbSqlLite entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getDataInserimento().getTime());
 
        java.util.Date data = entity.getData();
        if (data != null) {
            stmt.bindLong(3, data.getTime());
        }
        stmt.bindString(4, entity.getTitolo());
        stmt.bindString(5, entity.getTesto());
        stmt.bindString(6, entity.getHtml());
        stmt.bindLong(7, entity.getToken());
        stmt.bindLong(8, entity.getVersion());
        stmt.bindString(9, entity.getUrl());
        stmt.bindLong(10, entity.getFlagContenutoLetto() ? 1l: 0l);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public NotizieSitoDbSqlLite readEntity(Cursor cursor, int offset) {
        NotizieSitoDbSqlLite entity = new NotizieSitoDbSqlLite( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            new java.util.Date(cursor.getLong(offset + 1)), // dataInserimento
            cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)), // data
            cursor.getString(offset + 3), // titolo
            cursor.getString(offset + 4), // testo
            cursor.getString(offset + 5), // html
            cursor.getLong(offset + 6), // token
            cursor.getInt(offset + 7), // version
            cursor.getString(offset + 8), // url
            cursor.getShort(offset + 9) != 0 // flagContenutoLetto
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, NotizieSitoDbSqlLite entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDataInserimento(new java.util.Date(cursor.getLong(offset + 1)));
        entity.setData(cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)));
        entity.setTitolo(cursor.getString(offset + 3));
        entity.setTesto(cursor.getString(offset + 4));
        entity.setHtml(cursor.getString(offset + 5));
        entity.setToken(cursor.getLong(offset + 6));
        entity.setVersion(cursor.getInt(offset + 7));
        entity.setUrl(cursor.getString(offset + 8));
        entity.setFlagContenutoLetto(cursor.getShort(offset + 9) != 0);
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(NotizieSitoDbSqlLite entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(NotizieSitoDbSqlLite entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
