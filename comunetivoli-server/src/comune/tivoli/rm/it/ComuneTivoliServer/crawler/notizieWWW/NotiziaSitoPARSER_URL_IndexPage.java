package comune.tivoli.rm.it.ComuneTivoliServer.crawler.notizieWWW;

/**
 * URL delle pagine che indicizzano le notizie (home page e pagine successive)
 */
public class NotiziaSitoPARSER_URL_IndexPage implements Comparable<NotiziaSitoPARSER_URL_IndexPage> {
    public final String absoluteUrl;

    public NotiziaSitoPARSER_URL_IndexPage(String absoluteUrl) {
        if (!absoluteUrl.startsWith("http://"))
            throw new IllegalArgumentException("Invalid absolute url " + absoluteUrl);
        this.absoluteUrl = absoluteUrl;
    }

    public String toString() {
        return absoluteUrl;
    }

    @Override
    public int compareTo(NotiziaSitoPARSER_URL_IndexPage o) {
        return absoluteUrl.compareTo(o.absoluteUrl);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotiziaSitoPARSER_URL_IndexPage that = (NotiziaSitoPARSER_URL_IndexPage) o;

        return absoluteUrl.equals(that.absoluteUrl);

    }

    @Override
    public int hashCode() {
        return absoluteUrl.hashCode();
    }
}
