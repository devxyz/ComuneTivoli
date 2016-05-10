package comune.tivoli.rm.it.ComuneTivoliCommon.data;

import java.util.ArrayList;

/**
 * Created by stefano on 06/05/16.
 */
public class CommonDataServerResponse {
    public int version;
    public ArrayList<CommonNotiziaSito> notizie;

    public CommonDataServerResponse(int version, ArrayList<CommonNotiziaSito> notizie) {
        this.version = version;
        this.notizie = notizie;
    }

    public CommonDataServerResponse(int version) {
        this.version = version;
        notizie = new ArrayList<>();
    }

    public CommonDataServerResponse() {

    }
}
