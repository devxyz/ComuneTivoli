package comune.tivoli.rm.it.ComuneTivoliServer.crawler;

import comune.tivoli.rm.it.ComuneTivoliCommon.util.CommonTextUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by stefano on 09/07/16.
 */
public class ParserEventiEngine {
    private static final String URL_EVENTI_ATTIVI = "/news-ed-eventi.php?lang=IT";
    private static final String URL_EVENTI_ARCHIVIATI = "/news-ed-eventi/archivio.php";
    private static final String BASE_URL_EVENTI = "http://www.visittivoli.eu";
    private static final String PREFIX = "/news-ed-eventi/";
    private static final int timeout_millisec = 20000;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static List<String> listAllActiveEvents() throws Exception {
        final URL url = new URL(BASE_URL_EVENTI + URL_EVENTI_ATTIVI);
        return __listaAllEvents(url);
    }

    public static List<String> listAllArchivedEvents() throws Exception {
        final URL url = new URL(BASE_URL_EVENTI + URL_EVENTI_ARCHIVIATI);
        return __listaAllEvents(url);
    }

    private static List<String> __listaAllEvents(URL url) throws java.io.IOException {
        final Document parse = Jsoup.parse(url, timeout_millisec);

        final Elements a = parse.getElementsByTag("a");

        List<String> ris = new ArrayList<>();
        for (Element element : a) {
            final String href = element.attr("href");
            if (href.equalsIgnoreCase(URL_EVENTI_ARCHIVIATI))
                continue;

            if (href.startsWith(PREFIX))
                ris.add(href);
        }
        return ris;
    }

    public static void main(String[] args) {

        final EventoSitoPARSER parse;
        try {
            parse = parse("/news-ed-eventi/55/tivoli-festival");
            System.out.println(parse);
        } catch (Exception e) {
            System.out.println("\n\n\n=============================");
            e.printStackTrace(System.out);

        }


/*
        final List<String> urls = listAllArchivedEvents();
        for (String url : urls) {
            if (url.equalsIgnoreCase(URL_EVENTI_ARCHIVIATI))
                continue;

            if (url.startsWith("/news-ed-eventi/"))
                System.out.println(url);
        }*/
    }

    public static EventoSitoPARSER parse(String relativeUrl) throws Exception {
        final Document parse = Jsoup.parse(new URL(BASE_URL_EVENTI + relativeUrl), timeout_millisec);

        final Elements container1 = parse.getElementsByClass("container");
        // System.out.println(container1.size());

        final Element container = container1.get(2);
        final Elements row = container.getElementsByClass("row");
        // System.out.println(parse.html());
        //System.out.println("\n\n\n\n\n=======================");


        final Element content1 = row.get(0);
        final Element content2 = row.size() > 1 ? row.get(1) : null;

        //System.out.println(container.html());
        //System.out.println("=======================");
        // System.out.println(content1.html());
        // System.out.flush();


        final Element imageContainer = content1.getElementsByClass("col-lg-3").get(0);
        final Element textContainerContainer = content1.getElementsByClass("col-lg-9").get(0);
        final Element categoryContainer = textContainerContainer.select("h5.grigio").get(0);
        final Element titoloContainer = textContainerContainer.select("h4.fontTitolo").get(0);
        final Element dateContainer = textContainerContainer.select("h5.verdeScuro").get(0);

        final String imageUrl = BASE_URL_EVENTI + imageContainer.getElementsByTag("img").get(0).attr("src");

        String categoria = categoryContainer.text().toLowerCase();
        String titolo = titoloContainer.text();


        final Element elementTextContent = textContainerContainer.getElementsByTag("p").get(0);


        final String html;
        final String testo;


        if (content2 != null) {
            final String htmlOriginale = String.format("<html><head>\n<base href=\"%s\">\n</head><body>%s</body></html>",
                    BASE_URL_EVENTI, elementTextContent.html() + " " + content2.html()
            );
            html = CommonTextUtil.normalizeTextFromHtml(htmlOriginale);
            testo = elementTextContent.text() + " " + content2.text();
        } else {
            final String htmlOriginale = String.format("<html><head>\n<base href=\"%s\">\n</head><body>%s</body></html>",
                    BASE_URL_EVENTI, elementTextContent.html()
            );
            html = CommonTextUtil.normalizeTextFromHtml(htmlOriginale);
            testo = elementTextContent.text();

        }


        Date dataInizio;
        Date dataFine;
        final String[] split = dateContainer.text().split("-");
        if (split.length == 1) {
            dataInizio = dateFormat.parse(split[0].trim());
            dataFine = dateFormat.parse(split[0].trim());
        } else {
            dataInizio = dateFormat.parse(split[0].trim());
            dataFine = dateFormat.parse(split[1].trim());
        }

        String keyPath = relativeUrl;


        return new EventoSitoPARSER(categoria, titolo, html, testo, dataInizio, dataFine, imageUrl, keyPath);
    }

    public static List<EventoSitoPARSER> parse(Set<String> databaseUrl, boolean parseArchive) throws Exception {
        final Set<String> strings = new TreeSet<>(listAllActiveEvents());
        if (parseArchive) {
            strings.addAll(listAllArchivedEvents());
        }

        if (databaseUrl != null)
            strings.removeAll(databaseUrl);

        List<EventoSitoPARSER> ris = new ArrayList<>(strings.size());

        return ris;
    }
}
