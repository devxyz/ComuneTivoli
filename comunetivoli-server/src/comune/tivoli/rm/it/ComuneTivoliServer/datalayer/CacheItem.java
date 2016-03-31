package comune.tivoli.rm.it.ComuneTivoliServer.datalayer;

/**
 * Created by stefano on 16/03/16.
 */
public interface CacheItem<K> {
    public K getKey();

    public long getToken();

    public boolean isFlagDelete();
}
