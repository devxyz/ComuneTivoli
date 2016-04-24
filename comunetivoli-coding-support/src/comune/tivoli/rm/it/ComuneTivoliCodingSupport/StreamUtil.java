package comune.tivoli.rm.it.ComuneTivoliCodingSupport;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by stefano on 03/12/14.
 */
public class StreamUtil {
    public static String getFileContent(Reader r) throws IOException {
        StringBuilder sb = new StringBuilder();

        char[] buf = new char[1024];
        int amt = r.read(buf);
        while (amt > 0) {
            sb.append(buf, 0, amt);
            amt = r.read(buf);
        }
        return sb.toString();
    }
}
