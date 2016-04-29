package comune.tivoli.rm.it.ComuneTivoliCodingSupport;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by stefano on 29/04/16.
 */
public class GenerateListaMonumentiDaStringFile {
    public static void main(String[] args) throws IOException {
        Pattern p = Pattern.compile("[\"][^\"]+[_][^\"]+[\"]");
        File source = new File("/Users/stefano/DATA/dev/android/ComuneTivoliApp/ComuneTivoli/github/ComuneTivoli/comunetivoli-android/res/values/monumenti_strings.xml");
        final String fileContent = StreamUtil.getFileContent(new FileReader(source));
        final String[] split = fileContent.split("\n");
        TreeSet<String> nomi = new TreeSet<>();
        for (String row : split) {
            final Matcher matcher = p.matcher(row);
            if (matcher.find()) {
                //System.out.println("=====================");
                final String value = matcher.group().replace("\"", "");
                //System.out.println(value);
                final String substring = value.substring(0, value.lastIndexOf("_"));
                //System.out.println(substring);
                nomi.add(substring);

            }
        }

        for (String n : nomi) {
            System.out.println("//"+n);
            final String s1 = ("new MonumentiComune(\n" +
                    "                a.getResources().getString(R.string.#_titolo),\n" +
                    "                a.getResources().getString(R.string.#_descrizione),\n" +
                    "                a.getResources().getString(R.string.#_descrizionebig),\n" +
                    "                (R.drawable.#_fotosmall),\n" +
                    "                (R.drawable.#_fotobig),\n" +
                    "                a.getResources().getString(R.string.#_url),\n" +
                    "                a.getResources().getString(R.string.#_maps),\n" +
                    "                a.getResources().getString(R.string.#_tred),\n" +
                    "                a.getResources().getString(R.string.#_video),\n" +
                    "                a.getResources().getString(R.string.#_categoria),\n" +
                    "                a.getResources().getString(R.string.#_gallery)\n" +
                    "        )").replace("#", n);
            System.out.println("monumenti.add("+s1+");");
        }

    }
}
