package comune.tivoli.rm.it.ComuneTivoliServer.util;

import comune.tivoli.rm.it.ComuneTivoliCommon.data.NotiziaSitoDTO;
import comune.tivoli.rm.it.ComuneTivoliServer.ServerConfiguration;
import comune.tivoli.rm.it.ComuneTivoliServer.crawler.notizieWWW.NotiziaSitoPARSER;
import comune.tivoli.rm.it.ComuneTivoliServer.model.NotiziaSitoSERVERDB;

/**
 * Created by stefano on 11/07/16.
 */
public class CopyUtil {
    public static NotiziaSitoSERVERDB convertToDB(NotiziaSitoPARSER from, long token, boolean flagDelete) {
        NotiziaSitoSERVERDB to = new NotiziaSitoSERVERDB(token, from.titolo, from.testo, from.categoria, from.html, from.data,
                ServerConfiguration.PERISTENCE_VERSION_NUMBER, from.absoluteUrl, flagDelete);
        return to;
    }

    public static NotiziaSitoDTO convertToDTO(NotiziaSitoSERVERDB from) {
        NotiziaSitoDTO to = new NotiziaSitoDTO(from.token, from.version, from.titolo, from.categoria, from.testo, from.html, from.data,
                from.url, from.flagDelete);
        return to;
    }
}
