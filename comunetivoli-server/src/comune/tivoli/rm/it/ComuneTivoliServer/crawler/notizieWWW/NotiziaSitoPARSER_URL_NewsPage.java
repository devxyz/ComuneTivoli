package comune.tivoli.rm.it.ComuneTivoliServer.crawler.notizieWWW;

/**
 * URL delle pagine che contengono le notizie
 */
public class NotiziaSitoPARSER_URL_NewsPage implements Comparable<NotiziaSitoPARSER_URL_NewsPage> {
    public final String absoluteUrl;

    public NotiziaSitoPARSER_URL_NewsPage(String absoluteUrl) {
        if (!absoluteUrl.startsWith("http://"))
            throw new IllegalArgumentException("Invalid absolute url " + absoluteUrl);
        this.absoluteUrl = absoluteUrl;
    }

    public String toString() {
        return absoluteUrl;
    }

    @Override
    public int compareTo(NotiziaSitoPARSER_URL_NewsPage o) {
        return absoluteUrl.compareTo(o.absoluteUrl);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotiziaSitoPARSER_URL_NewsPage that = (NotiziaSitoPARSER_URL_NewsPage) o;

        return absoluteUrl.equals(that.absoluteUrl);

    }

    @Override
    public int hashCode() {
        return absoluteUrl.hashCode();
    }
}
