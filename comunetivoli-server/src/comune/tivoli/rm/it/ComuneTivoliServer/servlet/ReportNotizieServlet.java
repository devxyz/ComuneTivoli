package comune.tivoli.rm.it.ComuneTivoliServer.servlet;

import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.DataLayerBuilder;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.circolari.InMemoryCacheLayerNotiziaSitoDB;
import comune.tivoli.rm.it.ComuneTivoliServer.model.GAE_NotiziaSitoDB_V1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by stefano on 15/05/16.
 */
public class ReportNotizieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(response.getOutputStream()));
        out.print("<html><body>");

        out.print("<h1>notizie</h1>");
        out.print("<table border=1>");
        out.print("<tr>" +
                "<td>Token</td>" +
                "<td>url</td>" +
                "<td>titolo</td>" +
                "<td>Key</td>" +
                "<td>Key</td>" +
                "</tr>");
        final InMemoryCacheLayerNotiziaSitoDB cl = DataLayerBuilder.getLoaderNewsSito();
        int i = 1;
        for (GAE_NotiziaSitoDB_V1 c : cl.allEntities()) {

            out.print("<tr>" +
                    "<td>" + c.getToken() + "</td>" +
                    "<td><a href='" + c.getUrlOriginal() + "'>" + c.getUrlOriginal() + "</a></td>" +
                    "<td>" + c.getTitolo() + "</td>" +
                    "<td>" + c.getKey() + "</td>" +
                    "</tr>");

            i++;
        }
        out.print("</table></body>");
        out.print("<br><br>");


        out.print("</html>");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
