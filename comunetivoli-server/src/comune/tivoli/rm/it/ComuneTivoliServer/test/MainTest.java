package comune.tivoli.rm.it.ComuneTivoliServer.test;

import comune.tivoli.rm.it.ComuneTivoliServer.crawler.NotiziaWWWComuneTivoli;
import comune.tivoli.rm.it.ComuneTivoliServer.crawler.ParserNotizieEngine;

import java.io.IOException;

/**
 * Created by stefano on 15/04/16.
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        //http://www.comune.tivoli.rm.it/node/2664
        final NotiziaWWWComuneTivoli notiziaWWWComuneTivoli = ParserNotizieEngine.parse("node/2663");
        System.out.println(notiziaWWWComuneTivoli);
    }
}
