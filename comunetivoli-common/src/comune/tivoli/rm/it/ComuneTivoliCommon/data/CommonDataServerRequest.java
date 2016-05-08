package comune.tivoli.rm.it.ComuneTivoliCommon.data;

/**
 * Created by stefano on 06/05/16.
 */
public class CommonDataServerRequest {
    public long maxClientToken;
    public long version;
    public boolean responseInZipFormat;

    @Override
    public String toString() {
        return "CommonDataServerRequest{" +
                "maxClientToken=" + maxClientToken +
                ", version=" + version +
                ", responseInZipFormat=" + responseInZipFormat +
                '}';
    }
}
