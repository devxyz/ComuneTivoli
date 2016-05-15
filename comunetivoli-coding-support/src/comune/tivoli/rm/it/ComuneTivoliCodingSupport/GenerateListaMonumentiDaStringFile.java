package comune.tivoli.rm.it.ComuneTivoliCodingSupport;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
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

        PrintStream out = new PrintStream(new File("/Users/stefano/DATA/dev/android/ComuneTivoliApp/ComuneTivoli/github/ComuneTivoli/comunetivoli-android/src/comune/tivoli/rm/it/ComuneTivoli/util/MonumentiUtil.java"));

        out.println("package comune.tivoli.rm.it.ComuneTivoli.util;\n" +
                "\n" +
                "import android.app.Activity;\n" +
                "import comune.tivoli.rm.it.ComuneTivoli.R;\n" +
                "import comune.tivoli.rm.it.ComuneTivoli.model.MonumentiComune;\n" +
                "\n" +
                "import java.util.ArrayList;\n" +
                "import java.util.Collections;\n" +
                "import java.util.List;\n" +
                "import java.util.TreeSet;\n" +
                "\n" +
                "/**\n" +
                " * todo: aumentare la dimensione delle immagini \"big\", portandola ad almeno 400 pixel di larghezza\n" +
                " */\n" +
                "public class MonumentiUtil {\n" +
                "public static List<String> estraiCategorie(List<MonumentiComune> a) {\n" +
                "        TreeSet<String> r = new TreeSet<>();\n" +
                "        for (MonumentiComune monumentiComune : a) {\n" +
                "            r.add(monumentiComune.categoria);\n" +
                "        }\n" +
                "        return new ArrayList<>(r);\n" +
                "    }\n" +
                "\n" +
                "    public static MonumentiComune findById(List<MonumentiComune> a,int id) {\n" +
                "        \n" +
                "        for (MonumentiComune monumentiComune : a) {\n" +
                "            if (monumentiComune.id==id)return monumentiComune;\n" +
                "        }\n" +
                "        return null;\n" +
                "    }" +


                "\n" +
                "    public static List<MonumentiComune> elencoMonumenti(Activity a) {\n" +
                "        ArrayList<MonumentiComune> monumenti;\n" +
                "        monumenti = new ArrayList<>();");

        int id = 1;
        for (String n : nomi) {
            out.println("   //" + n);
            final String s1 = ("new MonumentiComune(\n" + id + ", " +
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
            out.println("monumenti.add(" + s1 + ");");
            id++;
        }

        out.println("        return monumenti;\n" +
                "    }\n" +
                "}\n");
        out.close();
    }
}
