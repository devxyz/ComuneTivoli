package comune.tivoli.rm.it.greenDaoEngine;

import de.greenrobot.daogenerator.*;

import java.util.Date;

/**
 * Created by stefano on 27/04/15.
 */
public class GreenDaoGenerator {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(3, "comune.tivoli.rm.it.ComuneTivoli.db.dao");

        //circolare
        final Entity circolare = schema.addEntity("NotizieSitoDbSqlLite");
        {
            circolare.addIdProperty().autoincrement();
            circolare.addDateProperty("dataInserimento").notNull();

            /*private long token;
            private String titolo;
            private String testo;
            private Date data;

            private String key;
            private String url;
*/

            circolare.addDateProperty("data").getProperty();
            circolare.addStringProperty("titolo").notNull();
            circolare.addStringProperty("testo").notNull();
            circolare.addStringProperty("html").notNull();
            circolare.addLongProperty("token").notNull();
            circolare.addIntProperty("version").notNull();
            circolare.addStringProperty("url").notNull().unique();
            circolare.addBooleanProperty("flagContenutoLetto").notNull();
            circolare.addStringProperty("key").notNull().unique();

            //index
            /*Index indexCircolare = new Index();
            indexCircolare.makeUnique();
            indexCircolare.addProperty(data);
            indexCircolare.addProperty(numero);
            circolare.addIndex(indexCircolare);*/
        }





        new DaoGenerator().generateAll(schema, "/Users/stefano/DATA/dev/android/ComuneTivoliApp/ComuneTivoli/github/ComuneTivoli/comunetivoli-android/src");
    }
}
