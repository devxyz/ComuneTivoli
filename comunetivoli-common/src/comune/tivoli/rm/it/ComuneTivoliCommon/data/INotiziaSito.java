package comune.tivoli.rm.it.ComuneTivoliCommon.data;

import java.util.Date;

/**
 * Created by stefano on 11/07/16.
 */
public interface INotiziaSito {
    String getCategoria();

    String getUrl();

    long getToken();

    String getTitolo();

    String getTesto();

    String getHtml();

    Date getData();


    int getVersion();

    boolean isFlagDelete();
}
