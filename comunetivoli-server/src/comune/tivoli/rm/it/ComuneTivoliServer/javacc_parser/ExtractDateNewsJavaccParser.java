package comune.tivoli.rm.it.ComuneTivoliServer.javacc_parser;

import comune.tivoli.rm.it.ComuneTivoliServer.javacc_parser.impl.Token;
import comune.tivoli.rm.it.ComuneTivoliServer.javacc_parser.impl.WordParser;
import comune.tivoli.rm.it.ComuneTivoliServer.javacc_parser.impl.WordParserConstants;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by stefano on 08/05/16.
 */
public class ExtractDateNewsJavaccParser {
    private static final Calendar c = Calendar.getInstance();

    private static Date extractDate(Token t) {
        switch (t.kind) {
            case WordParserConstants.DATA_TIVOLI:
            case WordParserConstants.DATA: {
                String n = t.image.toLowerCase()
                        .replace("gennaio", "01")
                        .replace("febbraio", "02")
                        .replace("marzo", "03")
                        .replace("aprile", "04")
                        .replace("maggio", "05")
                        .replace("giugno", "06")
                        .replace("luglio", "07")
                        .replace("agosto", "08")
                        .replace("settembre", "09")
                        .replace("ottobre", "10")
                        .replace("novembre", "11")
                        .replace("dicembre", "12")
                        .replace("-", "/")
                        .replace("tivoli", "")
                        .replace(",", "")
                        .trim()
                        .replaceAll("[ /-]+", "/");
                String[] s = n.split("/");

                try {
                    c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(s[0]));
                    c.set(Calendar.MONTH, Integer.parseInt(s[1]) - 1);
                    c.set(Calendar.YEAR, Integer.parseInt(s[2]));
                    c.set(Calendar.HOUR, 0);
                    c.set(Calendar.MINUTE, 0);
                    c.set(Calendar.SECOND, 0);
                    c.set(Calendar.MILLISECOND, 0);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Errore nell'analisi della data " + t.image + "(norm:" + n + ")", e);
                }
                return c.getTime();
            }
            default:
                throw new IllegalArgumentException("???");

        }
    }

    public static void main(String[] args) {

        final String s = "A seguito della richiesta avanzata da Acea Ato2 per effettuare lavori urgenti e indifferibili alla rete idrica, la Polizia locale ha disposto per domani, venerdì 6 maggio, la chiusura al traffico veicolare di via dei Sosii, dalle ore 9 alle ore 21.\n" +
                "Per consentire ai veicoli di raggiungere l'area di piazza del Plebiscito, del Municipio e delle vie limitrofe, per l'intera giornata sarà disattivato il varco elettronico numero 3 di via Domenico Giuliani della zona a traffico limitato \"Medievale\". Anche i veicoli senza autorizzazione per la ztl, transitando per via Giuliani, potranno raggiungere la suddetta area del centro cittadino attraverso il percorso piazza Rivarola, via San Valerio, Arco del Macello, via Macera.\n" +
                "\n" +
                "Tivoli, 5 maggio 2016";
        Date d = extractDate(s);
        System.out.println(d);
    }

    public static Date extractDate(String s) {
        final WordParser parser = new WordParser(new StringReader(s));
        List<Date> listaDateTivoli = new ArrayList<>();
        List<Date> listaDateGeneriche = new ArrayList<>();
        Token nextToken;
        do {
            nextToken = parser.getNextToken();
            if (nextToken.kind == WordParserConstants.DATA_TIVOLI) {
                Date normalize = extractDate(nextToken);
                listaDateTivoli.add(normalize);
            } else {
                if (nextToken.kind == WordParserConstants.DATA) {
                    Date normalize = extractDate(nextToken);
                    listaDateGeneriche.add(normalize);
                }
            }
        } while (nextToken.kind != WordParserConstants.EOF);

        Date d = null;
        if (listaDateTivoli.size() > 0) {
            d = listaDateTivoli.get(listaDateTivoli.size() - 1);
        } else if (listaDateGeneriche.size() > 0) {
            d = listaDateGeneriche.get(listaDateGeneriche.size() - 1);

        }
        return d;
    }
}
