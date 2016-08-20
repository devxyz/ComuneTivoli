package comune.tivoli.rm.it.ComuneTivoliServer.test;

import comune.tivoli.rm.it.ComuneTivoliServer.crawler.notizieWWW.NotiziaSitoPARSER;
import comune.tivoli.rm.it.ComuneTivoliServer.crawler.notizieWWW.NotiziaSitoPARSER_URL_NewsPage;
import comune.tivoli.rm.it.ComuneTivoliServer.crawler.notizieWWW.ParserNotizieSitoEngine;

import java.io.IOException;

/**
 * Created by stefano on 15/04/16.
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        //http://www.comune.tivoli.rm.it/node/2664
        final NotiziaSitoPARSER notiziaWWWComuneTivoli = ParserNotizieSitoEngine.parse(new NotiziaSitoPARSER_URL_NewsPage("node/2663"));
        System.out.println(notiziaWWWComuneTivoli);
    }
}
