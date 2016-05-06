package comune.tivoli.rm.it.ComuneTivoliServer.crawler;

import comune.tivoli.rm.it.ComuneTivoliCommon.util.CommonTextUtil;
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
public class ParserEngine {
    static final String baseUrl = "http://www.comune.tivoli.rm.it/";

    /**
     * estrae il numero di pagina da una url del genere:
     * /node?page=1
     *
     * @param s
     * @return
     */
    private static int extractPageNumber(String s) {
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
    private static int extractNodeNumber(String s) {
        final String[] s1 = s.split("/");
        return Integer.parseInt(s1[s1.length - 1]);
    }

    private static String composeUrl(String... ss) {
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

    public static NotiziaWWWComuneTivoli extractNewsFromPage(String baseUrl, String relativePathID) throws IOException {
        //versione stampabile
        String complete = composeUrl(baseUrl, relativePathID, "/print");
        System.out.println("Download " + complete + "( id " + relativePathID + ")");
        final Document parse = Jsoup.parse(new URL(complete), 10000);
        final Elements title_centro = parse.getElementsByClass("title");
        final Elements content = parse.getElementsByClass("content");

        final StringBuilder titolo = new StringBuilder();
        for (Element t : title_centro) {
            titolo.append(t.html()).append(" ");
        }

        final StringBuilder contenuto = new StringBuilder();
        for (Element t : content) {
            contenuto.append(t.html()).append(" ");
        }

        final String titolo1 = titolo.toString().trim();
        final String html = String.format("<html><head>\n<base href=\"http://www.comune.tivoli.rm.it/\">\n</head><body>%s</body></html>", contenuto.toString());
        String html2 = CommonTextUtil.normalizeTextFromHtml(html);

        return new NotiziaWWWComuneTivoli(
                titolo1, html2, complete, null, relativePathID);

    }

    public static void main(String[] args) throws IOException {


        //ipotetico elenco di nodi gia' nel db
        final Set<String> nodeLinksInDB = new TreeSet<>();
        nodeLinksInDB.add("/node/2585");


        ArrayList<NotiziaWWWComuneTivoli> pagine = parseFromWeb(nodeLinksInDB);
        for (NotiziaWWWComuneTivoli x : pagine) {
            System.out.println(x);
        }
        //System.out.println(pagine);
    }

    public static ArrayList<NotiziaWWWComuneTivoli> parseFromWeb(Set<String> nodeLinksInDB) throws IOException {
        System.out.println("Check Homepage (searching page-index links)");
        //dalla homepage individua tutte le pagine dei link esistenti, compresa la home
        final ArrayList<String> allIndexLinks = extractIndexPageUrlFromHomepage(baseUrl, -1);
        System.out.println("Found page-index links: " + allIndexLinks.size() + " pages");
        System.out.println("  - " + allIndexLinks);
        final ArrayList<String> allLinkArticoli = extractNodeUrlsFromIndexPages(baseUrl, nodeLinksInDB, allIndexLinks);

        System.out.println("LINKS");
        System.out.println(allLinkArticoli);
        ArrayList<NotiziaWWWComuneTivoli> pagine = new ArrayList<>();

        for (String urk : allLinkArticoli) {
//            System.out.println("=============================================");
            final NotiziaWWWComuneTivoli n = extractNewsFromPage(baseUrl, urk);
            pagine.add(n);
            //          System.out.println(n);
        }
        return pagine;
    }


    private static ArrayList<String> extractNodeUrlsFromIndexPages(String baseUrl, Set<String> nodeLinksInDB, ArrayList<String> allIndexLinks) throws IOException {
        //================================================================
        final ArrayList<String> allLinkArticoli = new ArrayList<>();
        boolean finish = false;
        for (String pageLink : allIndexLinks) {
            System.out.println();
            System.out.println("Checking index-page " + pageLink);
            if (finish) break;


            final ArrayList<String> ris = extractNodeLinksFromPages(baseUrl, pageLink);
            System.out.println("Found " + ris.size() + " nodes: " + ris);
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

    private static ArrayList<String> extractNodeLinksFromPages(String baseUrl, String pageLink) throws IOException {
        final ArrayList<String> ris = new ArrayList<>();
        final Document node = Jsoup.parse(new URL(composeUrl(baseUrl, pageLink)), 10000);
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
    private static ArrayList<String> extractIndexPageUrlFromHomepage(String baseUrl, int limit) throws IOException {
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
        int lastPageNumber = linkPage.size() == 0 ? 0 : extractPageNumber(linkPage.get(linkPage.size() - 1));
        //System.out.println(lastPageNumber);
        //System.out.println(linkPage);
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
            Integer v1 = extractPageNumber(o1);
            Integer v2 = extractPageNumber(o2);
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
            Integer v1 = extractNodeNumber(o1);
            Integer v2 = extractNodeNumber(o2);
            return v1.compareTo(v2);
        }
    }
}
