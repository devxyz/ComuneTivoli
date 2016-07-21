package comune.tivoli.rm.it.ComuneTivoliServer.ofy;

/**
 * Created by stefano on 01/08/15.
 */

import com.googlecode.objectify.ObjectifyService;
import comune.tivoli.rm.it.ComuneTivoliServer.model.EventoSitoSERVERDB;
import comune.tivoli.rm.it.ComuneTivoliServer.model.NotiziaFacebookSERVERDB;
import comune.tivoli.rm.it.ComuneTivoliServer.model.NotiziaSitoSERVERDB;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * OfyHelper, a ServletContextListener, is setup in web.xml to run before a JSP is run.  This is
 * required to let JSP's access Ofy.
 **/

public class OfyHelper implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
        // This will be invoked as part of a warmup request, or the first user
        // request if no warmup request was invoked.
        ObjectifyService.register(NotiziaFacebookSERVERDB.class);
        ObjectifyService.register(NotiziaSitoSERVERDB.class);
        ObjectifyService.register(EventoSitoSERVERDB.class);

    }

    public void contextDestroyed(ServletContextEvent event) {
        // App Engine does not currently invoke this method.
    }
}
