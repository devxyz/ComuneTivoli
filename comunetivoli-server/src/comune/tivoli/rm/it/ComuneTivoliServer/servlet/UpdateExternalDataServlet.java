package comune.tivoli.rm.it.ComuneTivoliServer.servlet;

import comune.tivoli.rm.it.ComuneTivoliServer.crawler.NotiziaSitoPARSER;
import comune.tivoli.rm.it.ComuneTivoliServer.crawler.ParserNotizieEngine;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.DataLayerBuilder;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.circolari.InMemoryCacheLayerNotiziaSitoDB;
import comune.tivoli.rm.it.ComuneTivoliServer.model.NotiziaSitoSERVERDB;
import comune.tivoli.rm.it.ComuneTivoliServer.util.CopyUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by stefano on 31/03/16.
 */
public class UpdateExternalDataServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String node = request.getParameter("NODE");

        final InMemoryCacheLayerNotiziaSitoDB ee = DataLayerBuilder.getLoaderNewsSito();
        final List<NotiziaSitoSERVERDB> elencoNotizie = ee.allEntities();
        Set<String> nodeLinksInDB = new TreeSet<>();
        for (NotiziaSitoSERVERDB x : elencoNotizie) {
            nodeLinksInDB.add(x.getKey());
        }

        MyToken t = new MyToken();
        t.token = DataLayerBuilder.maxToken();

        //DONE debug:come demo per evitare il download totale di tutto il sito
        //nodeLinksInDB.add("/node/2585");
        response.setContentType("text/plain");
        //download delle pagine non ancora analizzate
        System.out.println("Found " + nodeLinksInDB.size() + " pagine nel db");


        NotiziaSitoPARSER pagine = ParserNotizieEngine.parse(node);


        for (NotiziaSitoPARSER p : Arrays.asList(pagine)) {
            System.out.println(" - Found " + p.url + " - " + p.titolo + " nodi");
            t.token++;
            final NotiziaSitoSERVERDB nv = CopyUtil.convertToDB(p,t.token,false);
            ee.insert(nv);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private class MyToken {
        long token;
    }
}
