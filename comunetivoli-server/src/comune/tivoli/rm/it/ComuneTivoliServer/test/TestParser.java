package comune.tivoli.rm.it.ComuneTivoliServer.test;

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
public class TestParser {
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

    public static void main(String[] args) throws IOException {
        final String baseUrl = "http://www.comune.tivoli.rm.it/";

        //ipotetico elenco di nodi gia' nel db
        final Set<String> nodeLinksInDB = new TreeSet<>();

        System.out.println("Check Homepage (searching page-index links)");
        //dalla homepage individua tutte le pagine dei link esistenti, compresa la home
        final ArrayList<String> allIndexLinks = extractIndexPageUrlFromHomepage(baseUrl);
        System.out.println("Found page-index links: " + allIndexLinks.size() + " pages");
        System.out.println("  - " + allIndexLinks);


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


    }

    private static ArrayList<String> extractNodeLinksFromPages(String baseUrl, String pageLink) throws IOException {
        final ArrayList<String> ris = new ArrayList<>();
        final Document node = Jsoup.parse(new URL(baseUrl + pageLink), 10000);
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
    private static ArrayList<String> extractIndexPageUrlFromHomepage(String baseUrl) throws IOException {
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
