package comune.tivoli.rm.it.ComuneTivoliServer.crawler;

import comune.tivoli.rm.it.ComuneTivoliCommon.util.CommonTextUtil;
import comune.tivoli.rm.it.ComuneTivoliServer.javacc_parser.ExtractDateNewsJavaccParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created by stefano on 27/03/16.
 */
public class ParserNotizieEngine {
    public static final String BASE_URL = "http://www.comune.tivoli.rm.it/";

    private static final boolean DEBUG = true;

    /**
     * estrae il numero di pagina da una url del genere:
     * /node?page=1
     *
     * @param s
     * @return
     */
    private static int __extractPageNumber(String s) {
        final String[] s1 = s.split("=");
        return Integer.parseInt(s1[s1.length - 1]);
    }

    /**
     * estrae il numero di nodo da una url del genere:
     * /node/2567
     *
     * @param s
     * @return
     */
    private static int __extractNodeNumber(String s) {
        final String[] s1 = s.split("/");
        return Integer.parseInt(s1[s1.length - 1]);
    }

    private static String __composeUrl(String... ss) {
        StringBuilder sb = new StringBuilder();
        if (ss.length == 0) return "";

        sb.append(ss[0]);
        for (int i = 1; i < ss.length; i++) {
            String s = ss[i];
            if (!sb.toString().endsWith("/")) {
                sb.append("/");
            }
            if (s.startsWith("/")) {
                sb.append(s.substring(1));
            } else
                sb.append(s);
        }
        return sb.toString();
    }


    /**
     * parsing
     *
     * @param relativePathID: in genere nella forma node/1234 (percorso relativo rispetto al sito comune di tivoli)
     * @return
     * @throws IOException
     */
    public static NotiziaWWWComuneTivoli parse(String relativePathID) throws IOException {
        //versione stampabile
        String url = __composeUrl(BASE_URL, relativePathID);

        if (DEBUG)
            System.out.println("ParserEngine: " + "Download " + url + "( id " + relativePathID + ")");
        final Document parse = Jsoup.parse(new URL(url), 10000);
        final Elements title_centro = parse.getElementsByClass("title_centro");
        final Element main = parse.getElementById("main");
        final Elements nodeCategory = parse.getElementsByClass("sticky");
        final Elements content = main == null ? null : main.getElementsByClass("content");

        final StringBuilder titolo = new StringBuilder();
        for (Element t : title_centro) {
            titolo.append(t.html()).append(" ");
        }

        final StringBuilder contenuto = new StringBuilder();
        if (content != null)
            for (Element t : content) {
                contenuto.append(t.html()).append(" ");
            }

        //rimuove i commenti alla ricerca della categoria
        final String categoria;
        final String replace = nodeCategory.toString().replace("<!--", "").replace("-->", "");
        {
            final String html = "<html><body>" + replace + "</html></body>";
            //System.out.println(html);
            final Document parse1 = Jsoup.parse(html);
            final Elements taxonomy = parse1.getElementsByClass("taxonomy");

            categoria = taxonomy.text().trim().toLowerCase();
        }

        final String titoloNormalizzato = CommonTextUtil.normalize_UTF8__to__ASCII(Jsoup.parse("<html><body>" + titolo.toString().trim() + "</html></body>").body().text());
        final String htmlOriginale = String.format("<html><head>\n<base href=\"http://www.comune.tivoli.rm.it/\">\n</head><body>%s</body></html>", contenuto.toString());
        final String htmlNormalizzato = CommonTextUtil.normalizeTextFromHtml(htmlOriginale);

        final Document doc = Jsoup.parse(htmlNormalizzato);
        final String textNormalizzato = CommonTextUtil.normalize_UTF8__to__ASCII(doc.body().text());

        //done: manca ricerca data nel documento
        final Date date = ExtractDateNewsJavaccParser.extractDate(textNormalizzato);


        return new NotiziaWWWComuneTivoli(
                categoria, titoloNormalizzato,
                htmlNormalizzato, textNormalizzato,
                __composeUrl(BASE_URL, relativePathID, "print"), url,
                date,
                relativePathID);

    }

    public static void main(String[] args) throws IOException {


        //ipotetico elenco di nodi gia' nel db
        final Set<String> nodeLinksInDB = new TreeSet<>();
        //   nodeLinksInDB.add("/node/2585");


        ArrayList<NotiziaWWWComuneTivoli> pagine = parseFromWeb(nodeLinksInDB, 10);
        for (NotiziaWWWComuneTivoli x : pagine) {
            System.out.println("ParserEngine: " + x);
        }
        //System.out.println("ParserEngine: "+pagine);
    }

    public static ArrayList<NotiziaWWWComuneTivoli> parseFromWeb(Set<String> nodeLinksInDB, int limit) throws IOException {
        if (DEBUG)
            System.out.println("ParserEngine: " + "Check Homepage (searching page-index links)");
        //dalla homepage individua tutte le pagine dei link esistenti, compresa la home
        final ArrayList<String> allIndexLinks = __extractIndexPageUrlFromHomepage(BASE_URL, -1);
        if (DEBUG) System.out.println("ParserEngine: " + "Found page-index links: " + allIndexLinks.size() + " pages");
        if (DEBUG) System.out.println("ParserEngine: " + "  - " + allIndexLinks);
        final ArrayList<String> allLinkArticoli = __extractNodeUrlsFromIndexPages(BASE_URL, nodeLinksInDB, allIndexLinks);

        if (DEBUG) System.out.println("ParserEngine: " + "LINKS");
        if (DEBUG) System.out.println("ParserEngine: " + allLinkArticoli);
        ArrayList<NotiziaWWWComuneTivoli> pagine = new ArrayList<>();

        //dall'ultimo al primo
        Collections.reverse(allLinkArticoli);


        for (String url : allLinkArticoli) {
            //se limite, si ignorano altri
            if (limit == 0) break;
            limit--;

//            System.out.println("ParserEngine: "+"=============================================");
            try {
                final NotiziaWWWComuneTivoli n = parse(url);
                pagine.add(n);
            } catch (Exception e) {
                //ignora le pagine che non vengono caricate
                String urlPrint = __composeUrl(BASE_URL, url, "print");
                String urlOriginale = __composeUrl(BASE_URL, url);

                NotiziaWWWComuneTivoli n = new NotiziaWWWComuneTivoli(null, "Pagina non trovata", null, null, urlPrint, urlOriginale, null, url);
                pagine.add(n);
            }

        }
        return pagine;
    }


    private static ArrayList<String> __extractNodeUrlsFromIndexPages(String baseUrl, Set<String> nodeLinksInDB, ArrayList<String> allIndexLinks) throws IOException {
        //================================================================
        final ArrayList<String> allLinkArticoli = new ArrayList<>();
        boolean finish = false;
        for (String pageLink : allIndexLinks) {
            if (DEBUG)
                System.out.println("ParserEngine: " + "Checking index-page " + pageLink);
            if (finish) break;


            final ArrayList<String> ris = __extractNodeLinksFromPages(baseUrl, pageLink);
            if (DEBUG)
                System.out.println("ParserEngine: " + "Found " + ris.size() + " nodes: " + ris);
            for (String x : ris) {
                if (nodeLinksInDB.contains(x)) {
                    finish = true;
                } else {
                    allLinkArticoli.add(x);
                }
            }
        }
        return allLinkArticoli;
    }

    private static ArrayList<String> __extractNodeLinksFromPages(String baseUrl, String pageLink) throws IOException {
        final ArrayList<String> ris = new ArrayList<>();
        final Document node = Jsoup.parse(new URL(__composeUrl(baseUrl, pageLink)), 10000);
        final Elements elementsByClass = node.getElementsByClass("title");
        for (Element e : elementsByClass) {

            final Elements a = e.getElementsByTag("a");
            for (Element ee : a) {
                final String link = ee.attributes().get("href");
                ris.add(link);


            }
        }
        return ris;
    }

    /**
     * ritorna le url di tutte le pagine che contengono i link alle notizie
     *
     * @param baseUrl
     * @return
     * @throws IOException
     */
    private static ArrayList<String> __extractIndexPageUrlFromHomepage(String baseUrl, int limit) throws IOException {
        String mainUrl = baseUrl + "node";
        final Document parse = Jsoup.parse(new URL(mainUrl), 10000);


        //=====================================================================================
        // cerca le varie pagine indice delle notizie
        final ArrayList<String> linkPage = new ArrayList<>();
        final Elements indici = parse.getElementById("pager").getElementsByTag("a");
        for (Element tagA : indici) {
            final String href = tagA.attributes().get("href");
            linkPage.add(href);

        }
        Collections.sort(linkPage, new SortAscPage());
        int lastPageNumber = linkPage.size() == 0 ? 0 : __extractPageNumber(linkPage.get(linkPage.size() - 1));
        final ArrayList<String> allPageLinks = new ArrayList<>();
        allPageLinks.add("/node");//link al primo indice (homepage)
        for (int i = 1; i <= lastPageNumber; i++) {
            if (limit > 0 && allPageLinks.size() >= limit) break;
            allPageLinks.add("/node?page=" + i);

        }
        return allPageLinks;
    }

    /**
     * compara in senso decrescente gli indirizzi del tipo
     * /node?page=1
     * /node?page=2
     * /node?page=3
     * /node?page=4
     * /node?page=5
     * /node?page=6
     * /node?page=7
     * /node?page=8
     * /node?page=1
     * /node?page=110
     */
    public static class SortAscPage implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            Integer v1 = __extractPageNumber(o1);
            Integer v2 = __extractPageNumber(o2);
            return v1.compareTo(v2);
        }
    }

    /**
     * compara in senso decrescente gli indirizzi del tipo
     * /node/2567
     * /node/2566
     * /node/2565
     * /node/2564
     * /node/2563
     * /node/2562
     * /node/2561
     * /node/2560
     * /node/2559
     * /node/2558
     */
    public static class SortAscNode implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            Integer v1 = __extractNodeNumber(o1);
            Integer v2 = __extractNodeNumber(o2);
            return v1.compareTo(v2);
        }
    }
}
