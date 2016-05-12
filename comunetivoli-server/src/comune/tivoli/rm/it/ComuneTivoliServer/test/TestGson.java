package comune.tivoli.rm.it.ComuneTivoliServer.test;

import com.google.appengine.repackaged.com.google.gson.Gson;
import comune.tivoli.rm.it.ComuneTivoliCommon.data.CommonDataServerResponse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by stefano on 12/05/16.
 */
public class TestGson {
    public static void main(String[] args) throws FileNotFoundException {
        File s=new File("/Users/stefano/Downloads/data 3.json");

        Gson g=new Gson();
        final CommonDataServerResponse commonNotiziaSito = g.fromJson(new FileReader(s), CommonDataServerResponse.class);
    }
}
