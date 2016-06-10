package comune.tivoli.rm.it.ComuneTivoliServer.test;

import comune.tivoli.rm.it.ComuneTivoliServer.crawler.NotiziaWWWComuneTivoli;
import comune.tivoli.rm.it.ComuneTivoliServer.crawler.ParserNotizieEngine;

import java.io.IOException;

/**
 * Created by stefano on 15/04/16.
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        final NotiziaWWWComuneTivoli notiziaWWWComuneTivoli = ParserNotizieEngine.extractNewsFromPage_siteVersion(ParserNotizieEngine.baseUrl, "node/2633");
        System.out.println(notiziaWWWComuneTivoli);
    }
}
