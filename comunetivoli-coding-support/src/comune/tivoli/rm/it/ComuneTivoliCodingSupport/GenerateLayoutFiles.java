package comune.tivoli.rm.it.ComuneTivoliCodingSupport;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stefano on 22/04/16.
 */
public class GenerateLayoutFiles {
    public static void main(String[] args) throws IOException {


        File r1 = new File("/Users/stefano/DATA/dev/android/ComuneTivoliApp/ComuneTivoli/github/ComuneTivoli/comunetivoli-android/res/layout");
        File r2 = new File("/Users/stefano/DATA/dev/android/ComuneTivoliApp/ComuneTivoli/github/ComuneTivoli/comunetivoli-android/res/layout-port");
        final String fileContent = StreamUtil.getFileContent(new FileReader(new File(r1, "empty_layout.xml")));

        List<File> ff = Arrays.asList(r1, r2);


        for (File source : ff) {

            for (File file : source.listFiles()) {
                if (file.getName().contains("empty_layout")) continue;
                if (file.getName().endsWith("_decorated.xml")) continue;
                if (file.getName().startsWith("listview_")) continue;
                System.out.println(file);
                String c = StreamUtil.getFileContent(new FileReader(file));

                c = c.replaceAll("\\<\\?xml(?m).*$", "");
                final int start = c.indexOf(">");
                final int end = c.lastIndexOf("</");
                c = c.substring(start + 1, end);
                System.out.println(c);
                System.out.println("=============================");
                System.out.println("=============================");
                System.out.println("=============================");

                final String ris = fileContent.replaceFirst("</RelativeLayout>", c + "</RelativeLayout>");
                //System.out.println(ris);

                File out = new File(source, file.getName().replace(".xml", "_decorated.xml"));
                FileWriter w = new FileWriter(out);
                w.write(ris);
                w.close();


            }
        }
    }
}
