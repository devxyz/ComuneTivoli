package comune.tivoli.rm.it.ComuneTivoliServer.servlet;

import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.DataLayerBuilder;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.circolari.InMemoryCacheLayerNotiziaSitoDB;
import comune.tivoli.rm.it.ComuneTivoliServer.model.NotiziaSitoSERVERDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by stefano on 05/05/16.
 */
public class PrintNotizieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(response.getOutputStream()));
        out.print("<html><body>");
        final String number = request.getParameter("LAST");
        long n = number == null ? 1000 : Integer.parseInt(number);

        out.print("<h1>notizie</h1>");
        out.print("<table border=1>");
        out.print("<tr><td>Progressivo</td><td>Tipo</td><td>Contenuto</td></tr>");
        final InMemoryCacheLayerNotiziaSitoDB cl = DataLayerBuilder.getLoaderNewsSito();
        int i = 1;
        final List<NotiziaSitoSERVERDB> x = new ArrayList<>(cl.allEntities(n));

        Collections.sort(x, new Comparator<NotiziaSitoSERVERDB>() {
            @Override
            public int compare(NotiziaSitoSERVERDB o1, NotiziaSitoSERVERDB o2) {
                return -Long.valueOf(o1.token).compareTo(o2.token);
            }
        });


        for (NotiziaSitoSERVERDB c : x) {
            n--;
            if (n < 0) {
                break;
            }
            out.println("<tr><td rowspan=7>" + i + "</td><td><b>URL</b></td>  <td><a href='" + c.getUrl() + "'>" + c.getUrl() + "</a></td></tr>");
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
            out.println("<tr><td> <form action='http://comune-tivoli.appspot.com/UpdateExternalDataServlet' target='_blank'>\n" +
                    "    node number (example 2633): <input name='NODE' type=\"text\" maxlength='50' value='"+ c.url+"' >\n" +
                    "    <input type='submit' value='UPDATE'>\n" +
                    "</form>\n</td>  <td> ----------------------------- </td></tr>");
            out.println("<tr><td> ------- </td>  <td> ----------------------------- </td></tr>");
            i++;

        }
        out.print("</table></body>");
        if (n == 0)
            out.print("<h3>Interrotto...</h3>");

        out.print("<br><br>");


        out.print("</html>");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
