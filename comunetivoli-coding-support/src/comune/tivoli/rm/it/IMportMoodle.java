package comune.tivoli.rm.it;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefano on 16/05/16.
 */
public class IMportMoodle {
    private static boolean isNewQuestion_multipleChoice(String q) {
        for (int i = 1; i <= 10; i++) {
            if (q.equals(i + "-A")) return true;
            if (q.equals(i + "-B")) return true;
        }
        return false;
    }

    private static boolean isNewQuestion_Short(String q) {
        for (int i = 1; i <= 4; i++) {
            if (q.equals(i + "P-A")) return true;
            if (q.equals(i + "P-B")) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        final Document parse = Jsoup.parse(new File("/Users/stefano/DATA/scuola/insegnamento/scuola-AS-2015-16/FalconeBorsellino-Zagarolo-15-16/quiz-fisica/import/termodinamica maggio2016.htm"), "iso-8859-1");

        List<DomandaRispostaMultipla> risposteMultiple = new ArrayList<>();
        List<DomandaRispostaAperta> risposteAperte = new ArrayList<>();
        DomandaRispostaMultipla lastDomandaRispostaMultipla = null;
        DomandaRispostaAperta lastDomandaAperta = null;


        final Elements p = parse.getElementsByTag("P");
        for (Element el : p) {
            final String text = el.text();
            if (text.trim().length() == 0) continue;


            if (isNewQuestion_multipleChoice(text)) {
                DomandaRispostaMultipla d;
                d = new DomandaRispostaMultipla();
                d.titolo = text;
                lastDomandaRispostaMultipla = d;
                risposteMultiple.add(d);
                lastDomandaAperta = null;
                continue;
            }

            if (isNewQuestion_Short(text)) {
                lastDomandaAperta = new DomandaRispostaAperta();
                risposteAperte.add(lastDomandaAperta);
                lastDomandaAperta.titolo = text;
                lastDomandaRispostaMultipla = null;
                continue;
            }

            if (lastDomandaAperta != null) {
                lastDomandaAperta.domandaTesto.append(text);
                lastDomandaAperta.domandaHtml.append(el.html());
                continue;
            }

            if (lastDomandaRispostaMultipla != null) {
                if (lastDomandaRispostaMultipla.domandaHtml == null) {
                    lastDomandaRispostaMultipla.domandaHtml = el.html();
                    lastDomandaRispostaMultipla.domandaTesto = el.text();
                } else {
                    lastDomandaRispostaMultipla.domandeHtml.add(el.html());
                    lastDomandaRispostaMultipla.domandeText.add(el.text());
                }
                continue;
            }

            System.out.println(el.text());
            System.out.println("=============================");
        }


        System.out.println("<?xml version=\"1.0\" ?><quiz>");
        System.out.println("  <question type=\"category\">\n" +
                "    <category>\n" +
                "        <text>$course$/Default per FISICA/CLASSE-IIIB/</text>\n" +
                "\n" +
                "    </category>\n" +
                "  </question>\n");
        for (DomandaRispostaMultipla x : risposteMultiple) {

            final String s1 = "<question type=\"multichoice\">\n" +
                    "<name>\n" +
                    "         <text>" + x.titolo + "</text>\n" +
                    "     </name>\n" +
                    "     <questiontext format=\"html\">\n" +
                    "         <text><![CDATA[" + x.domandaHtml + "]]></text>\n" +
                    "     </questiontext>" +
                    " <answer fraction=\"100\">\n" +
                    "     <text> <![CDATA[" + x.domandeText.get(3) + "]]> </text>\n" +
                    "    <feedback><text></text></feedback>\n" +
                    " </answer>\n" +

                    " <answer fraction=\"0\">\n" +
                    "     <text> <![CDATA[" + x.domandeText.get(0) + "]]> </text>\n" +
                    "    <feedback><text>Errata</text></feedback>\n" +
                    " </answer>\n" +

                    " <answer fraction=\"0\">\n" +
                    "     <text> <![CDATA[" + x.domandeText.get(1) + "]]> </text>\n" +
                    "    <feedback><text>Errata</text></feedback>\n" +
                    " </answer>\n" +

                    " <answer fraction=\"0\">\n" +
                    "     <text> <![CDATA[" + x.domandeText.get(2) + "]]> </text>\n" +
                    "    <feedback><text>Errata</text></feedback>\n" +
                    " </answer>\n" +

                    " <shuffleanswers>1</shuffleanswers>\n" +
                    " <single>true</single></question>";
            System.out.println(s1);
        }


        for (DomandaRispostaAperta x : risposteAperte) {
            String s1="  <question type=\"essay\">\n" +
                    "    <name>\n" +
                    "      <text>"+ x.titolo+ "</text>\n" +
                    "    </name>\n" +
                    "    <questiontext format=\"html\">\n" +
                    "      <text><![CDATA["+

                    x.domandaHtml+
                    "]]></text>\n" +
                    "    </questiontext>\n" +
                    "    <generalfeedback format=\"html\">\n" +
                    "      <text></text>\n" +
                    "    </generalfeedback>\n" +
                    "    <defaultgrade>20.0000000</defaultgrade>\n" +
                    "    <penalty>0.0000000</penalty>\n" +
                    "    <hidden>0</hidden>\n" +
                    "    <responseformat>editor</responseformat>\n" +
                    "    <responsefieldlines>30</responsefieldlines>\n" +
                    "    <attachments>0</attachments>\n" +
                    "    <graderinfo format=\"html\">\n" +
                    "      <text><![CDATA["+
                    x.domandaHtml+

                    "]]></text>\n" +
                    "    </graderinfo>\n" +
                    "    <responsetemplate format=\"html\">\n" +
                    "      <text><![CDATA[" +
                    "<p><span style=\"color: #ff0000;\"><strong>RISPOSTA ALLA PUNTO 1</strong></span></p>\n" +
                    "\n" +
                    "<p>.......................</p>\n" +
                    "\n" +
                    "<p> </p>\n" +
                    "\n" +
                    "<p><span style=\"color: #ff0000;\"><strong>RISPOSTA ALLA PUNTO 2</strong></span></p>\n" +
                    "\n" +
                    "<p>.......................</p>\n" +
                    "\n" +
                    "<p> </p>\n" +
                    "\n" +
                    "<p><span style=\"color: #ff0000;\"><strong>RISPOSTA ALLA PUNTO 3</strong></span></p>\n" +
                    "\n" +
                    "<p>.......................</p>\n" +
                    "\n" +
                    "<p> </p>\n" +
                    "\n" +
                    "<p><span style=\"color: #ff0000;\"><strong>RISPOSTA ALLA PUNTO 4</strong></span></p>\n" +
                    "\n" +
                    "<p>.......................</p>]]></text>\n" +
                    "    </responsetemplate>\n" +
                    "  </question>";
            System.out.println(s1);

        }

        System.out.println("</quiz>");
    }

    private static class DomandaRispostaMultipla {
        String titolo;
        String domandaHtml;
        String domandaTesto;
        ArrayList<String> domandeHtml = new ArrayList<>();
        ArrayList<String> domandeText = new ArrayList<>();

        @Override
        public String toString() {

            return "DomandaRispostaMultipla{" +
                    "titolo='" + titolo + '\'' +
                    ", domandeText=" + domandeText +
                    '}';
        }
    }

    private static class DomandaRispostaAperta {
        String titolo;
        StringBuilder domandaHtml = new StringBuilder();
        StringBuilder domandaTesto = new StringBuilder();
    }
}
