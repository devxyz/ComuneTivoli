package comune.tivoli.rm.it.ComuneTivoliServer.servlet;

import comune.tivoli.rm.it.ComuneTivoliServer.crawler.notizieWWW.NotiziaSitoPARSER;
import comune.tivoli.rm.it.ComuneTivoliServer.crawler.notizieWWW.NotiziaSitoPARSER_URL_NewsPage;
import comune.tivoli.rm.it.ComuneTivoliServer.crawler.notizieWWW.ParserNotizieSitoEngine;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.DataLayerBuilder;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.circolari.InMemoryCacheLayerNotiziaSitoDB;
import comune.tivoli.rm.it.ComuneTivoliServer.model.NotiziaSitoSERVERDB;
import comune.tivoli.rm.it.ComuneTivoliServer.util.CopyUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by stefano on 31/03/16.
 */
public class LoadExternalDataServlet extends HttpServlet {
    public static final int MAX_NEW_PAGES_AT_TIME = 200;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final InMemoryCacheLayerNotiziaSitoDB ee = DataLayerBuilder.getLoaderNewsSito();
        final List<NotiziaSitoSERVERDB> elencoNotizie = ee.allEntities();
        Set<NotiziaSitoPARSER_URL_NewsPage> nodeLinksInDB = new TreeSet<>();
        for (NotiziaSitoSERVERDB x : elencoNotizie) {
            nodeLinksInDB.add(new NotiziaSitoPARSER_URL_NewsPage(x.getUrl()));
        }

        MyToken t = new MyToken();
        t.token = DataLayerBuilder.maxToken();

        //DONE debug:come demo per evitare il download totale di tutto il sito
        //nodeLinksInDB.add("/node/2585");
        response.setContentType("text/plain");
        //download delle pagine non ancora analizzate
        System.out.println("Found " + nodeLinksInDB.size() + " pagine nel db");


        ArrayList<NotiziaSitoPARSER> pagine = ParserNotizieSitoEngine.parseFromWeb(nodeLinksInDB, MAX_NEW_PAGES_AT_TIME);

        System.out.println("Found " + pagine.size() + " nodes (limit " + MAX_NEW_PAGES_AT_TIME + ")");


        for (NotiziaSitoPARSER p : pagine) {
            System.out.println(" - Found " + p.absoluteUrl + " - " + p.titolo + " nodi");


            t.token++;
            final NotiziaSitoSERVERDB nv = CopyUtil.convertToDB(p, t.token, false);

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
