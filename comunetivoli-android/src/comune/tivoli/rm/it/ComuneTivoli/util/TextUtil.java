package comune.tivoli.rm.it.ComuneTivoli.util;


/**
 * Created by stefano on 11/03/15.
 */
public class TextUtil {


    public static String normalizeTextFromHtml(String testo) {
        //if (true)return testo;

        return normalize_UTF8__to__ASCII(testo);
    }

    public static String normalize_UTF8__to__ASCII(String c) {
        if (c == null) return null;
        StringBuilder sb = new StringBuilder(c.length());
        for (int i = 0; i < c.length(); i++) {
            sb.append(normalize_UTF8__to__ASCII(c.charAt(i)));
        }
        return sb.toString();
    }

    private static boolean isEmpty(String s) {
        return s.trim().length() == 0;
    }

    public static String normalize_forTextToSpeech(String s) {
        //normalizza i caratteri, inserisce e riscrive abbreviazioni e simili e sistema gli a-capo
        String x = normalize_UTF8__to__ASCII(s);
        x = normalize_lineFeed(x);

        String[][] replace = new String[][]{
                {"A'", "à"},
                {"a'", "à"},
                {"e'", "é"},
                {"i'", "ì"},
                {"o'", "ò"},
                {"u'", "ù"},
                {"prof.[ ]*ssa'", "professoressa"},
                {"Prof.[ ]*ssa'", "professoressa"},
                {"n.'", "numero"},
        };
        for (int i = 0; i < replace.length; i++) {
            String from = replace[i][0];
            String to = replace[i][1];
            x = x.replaceAll(from, to);
        }
        return x;

    }

    public static String normalize_UTF8__to__ASCII(char c) {

        switch (c) {
            case 61482:
                return "F";
            //punto elenco
            case 61623:
                return "*";
            case 8217:
                return "\'";
            case 8221:
            case 8220:
                return "\"";
            case 8211:
                return "-";
            case 192:
                return "A'";
            case 249:
                return "u'";
            case 224:
                return "a'";
            case 236:
                return "i'";
            case 232:
                return "e'";
            case 176:
                return "'";
            //punto elenco
            case 183:
                return "*";
            //punti elenco
            case 61656:
            case 61607:
                return "*";
            case 200:
                return "E'";
            case 233:
                return "e'";
            case 242:
                return "o'";
            case 8364:
                return "euro";

            case 'ê':
            case 'ë':
                return "e'";
            case 'û':
                return "u'";
            case 'ï':
            case 'î':
                return "i'";
            case 'â':
                return "a'";
            case 160://à
                return " ";
            case 'Ô':
                return "o'";

            case 'É':
            case 'Ê':
            case 'Ë':
                return "E'";
            case 'Û':
            case 'Ù':
                return ("U'");
            case 'Ï':
            case 'Î':
                return ("I'");
            case 'Â':
            case 'Ã':
                return ("A'");


            default:
                if (c > 255)
                    return "#" + (int) c + "#";
                return "" + c;
        }
    }

    private static boolean endsWithPoint(String s) {
        return s.endsWith(".") || s.endsWith(":") || s.endsWith(";");
    }

    private static boolean startWithUppercaseOrNumber(String s) {
        if (s.length() <= 0) return false;

        return Character.isUpperCase(s.charAt(0)) && !Character.isUpperCase(s.charAt(1)) || Character.isDigit(s.charAt(0));
    }



    /**
     * normalizza un testo eliminando gli \n non necessari in funzione dellle maiuscole
     *
     * @param text
     * @return
     */
    public static String normalize_lineFeed(String text) {
        text = text.trim();
        final String[] split = text.split("[\n]");
        StringBuilder sb = new StringBuilder(text.length());
        String prevTrim = "";
        for (String line : split) {
            String trim = line.trim();
            //controlla se cancellare
            if (trim.length() == 0) {
                if (prevTrim.length() > 0)
                    sb.append(".\n");
                else
                    sb.append("\n");
                prevTrim = trim;
                continue;
            }

            if (sb.length() == 0) {
                sb.append(line);
                continue;
            }
            boolean b = endsWithPoint(prevTrim);

            if (startWithUppercaseOrNumber(trim) || b) {

                if (!b) {
                    if (prevTrim.length() > 0)
                        sb.append(".\n");
                    else
                        sb.append("\n");
                } else
                    sb.append("\n");
                sb.append(line);
            } else {
                sb.append(" ");
                sb.append(line);
            }
            prevTrim = trim;

        }

        return sb.toString();
    }




}
