package comune.tivoli.rm.it.ComuneTivoliServer.test;

import comune.tivoli.rm.it.ComuneTivoliServer.crawler.NotiziaWWWComuneTivoli;
import comune.tivoli.rm.it.ComuneTivoliServer.crawler.ParserEngine;

import java.io.IOException;

/**
 * Created by stefano on 15/04/16.
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        final NotiziaWWWComuneTivoli notiziaWWWComuneTivoli = ParserEngine.extractNewsFromPage_siteVersion(ParserEngine.baseUrl, "node/2617");
        System.out.println(notiziaWWWComuneTivoli);
    }
}
