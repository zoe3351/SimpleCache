package DesignCache;

/**
 * Created by jindong on 10/4/17.
 */
public interface CacheStrategy<K, V> {

    void postGet(CacheEntryList<K, V> cacheEntryList, CacheEntry<K, V> target);

    K evict(CacheIndex<K, V> cacheIndex, CacheEntryList<K, V> cacheEntryList);

    void doPut(CacheIndex<K, V> cacheIndex, CacheEntryList<K, V> cacheEntryList, CacheEntry<K, V> entry);
}
