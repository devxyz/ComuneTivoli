package comune.tivoli.rm.it.ComuneTivoliServer.servlet;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import comune.tivoli.rm.it.ComuneTivoliCommon.data.CommonNotiziaSito;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.DataLayerBuilder;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.circolari.InMemoryCacheLayerNotiziaSitoDB;
import comune.tivoli.rm.it.ComuneTivoliServer.model.GAE_NotiziaFacebook_V0_1;
import comune.tivoli.rm.it.ComuneTivoliServer.model.GAE_NotiziaSitoDB_V1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by stefano on 06/05/16.
 */
public class ResetDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final InMemoryCacheLayerNotiziaSitoDB ee = DataLayerBuilder.getLoaderNewsSito();
        ee.invalidate();

        final Objectify ofy = ObjectifyService.ofy();
        {
            final List<GAE_NotiziaSitoDB_V1> list = ofy.load().type(GAE_NotiziaSitoDB_V1.class).list();
            final PrintWriter out = response.getWriter();
            out.println(list.size() + " notizie nel datastore cancellate\n");
            ofy.delete().entities(list).now();
        }
{
            final List<GAE_NotiziaFacebook_V0_1> list = ofy.load().type(GAE_NotiziaFacebook_V0_1.class).list();
            final PrintWriter out = response.getWriter();
            out.println(list.size() + " notizie nel datastore cancellate\n");
            ofy.delete().entities(list).now();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
