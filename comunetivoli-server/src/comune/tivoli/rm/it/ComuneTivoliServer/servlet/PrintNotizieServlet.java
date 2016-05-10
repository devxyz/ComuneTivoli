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
 * Created by stefano on 05/05/16.
 */
public class PrintNotizieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(response.getOutputStream()));
        out.print("<html><body>");

        out.print("<h1>notizie</h1>");
        out.print("<table border=1>");
        out.print("<tr><td>Progressivo</td><td>Tipo</td><td>Contenuto</td></tr>");
        final InMemoryCacheLayerNotiziaSitoDB cl = DataLayerBuilder.getLoaderNewsSito();
        int i = 1;
        for (GAE_NotiziaSitoDB_V1 c : cl.allEntities()) {

            out.println("<tr><td rowspan=7>" + i + "</td><td><b>URL</b></td>  <td><a href='" + c.getUrlPrint() + "'>" + c.getUrlPrint() + "</a></td></tr>");
            out.println("<tr><td><b>Key</b></td>  <td>" + c.getKey() + "</td></tr>");
            out.println("<tr><td><b>Data</b></td>  <td>" + c.getData() + "</td></tr>");
            out.println("<tr><td><b>Titolo</b></td>  <td>" + c.getTitolo() + "</td></tr>");
            out.println("<tr><td><b>Token</b></td>  <td>" + c.getToken() + "</td></tr>");
            if (c.getTesto() != null) {
                out.println("<tr><td><b>Testo</b></td>  <td>" + c.getTesto() + "</td></tr>");
                out.println("<tr><td><b>Html</b></td>  <td>" + c.getHtml() + "</td></tr>");
            } else {
                out.println("<tr><td><b>Testo</b></td>  <td> NULL </td></tr>");
                out.println("<tr><td><b>Html</b></td>  <td> NULL </td></tr>");
            }
            out.println("<tr><td> ------- </td>  <td> ----------------------------- </td></tr>");
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
