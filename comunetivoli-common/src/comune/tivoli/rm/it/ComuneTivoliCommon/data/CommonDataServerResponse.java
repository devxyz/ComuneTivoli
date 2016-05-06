package comune.tivoli.rm.it.ComuneTivoliCommon.data;

import java.util.ArrayList;

/**
 * Created by stefano on 06/05/16.
 */
public class CommonDataServerResponse {
    public CommonDataServerResponse(ArrayList<CommonNotiziaSito> notizie) {
        this.notizie = notizie;
    }

    public ArrayList<CommonNotiziaSito> notizie;
}
