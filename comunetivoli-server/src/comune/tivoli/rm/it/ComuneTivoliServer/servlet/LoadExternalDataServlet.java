package comune.tivoli.rm.it.ComuneTivoliServer.servlet;

import comune.tivoli.rm.it.ComuneTivoliServer.crawler.NotiziaWWWComuneTivoli;
import comune.tivoli.rm.it.ComuneTivoliServer.crawler.ParserEngine;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.DataLayerBuilder;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.circolari.InMemoryCacheLayerNotiziaSitoDB;
import comune.tivoli.rm.it.ComuneTivoliServer.model.GAE_NotiziaSitoDB_V1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by stefano on 31/03/16.
 */
public class LoadExternalDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final InMemoryCacheLayerNotiziaSitoDB ee = DataLayerBuilder.getLoaderNewsSito();
        final List<GAE_NotiziaSitoDB_V1> elencoNotizie = ee.allEntities();
        Set<String> nodeLinksInDB = new TreeSet<>();
        for (GAE_NotiziaSitoDB_V1 x : elencoNotizie) {
            nodeLinksInDB.add(x.getUrl());
        }

        MyToken t = new MyToken();
        t.token = DataLayerBuilder.maxToken();

        //todo debug:come demo per evitare il download totale di tutto il sito
        nodeLinksInDB.add("/node/2585");

        //download delle pagine non ancora analizzate
        ArrayList<NotiziaWWWComuneTivoli> pagine = ParserEngine.parseFromWeb(nodeLinksInDB);
        System.out.println("Found " + pagine.size() + " nodi");

        for (NotiziaWWWComuneTivoli p : pagine) {
            final GAE_NotiziaSitoDB_V1 nv = new GAE_NotiziaSitoDB_V1();
            nv.setData(new Date());
            nv.setFlagDelete(false);
            t.token++;
            nv.setTitolo(p.titolo);
            nv.setTesto(p.html);
            nv.setToken(t.token);
            nv.setUrl(p.link);
            nv.setKey(p.keyPath);
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
