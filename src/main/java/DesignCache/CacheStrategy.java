package DesignCache;

/**
 * Created by jindong on 10/4/17.
 * The Cache Strategy relevant to put, evict and rank cacheEntry in CacheIndex and CacheEntryList
 */
public interface CacheStrategy<K, V> {

    /**
     * Move the cache entry in cacheEntryList after each get operation to the entry
     * @param cacheEntryList
     * @param target the cacheEntry got from cache.
     */
    void postGet(CacheEntryList<K, V> cacheEntryList, CacheEntry<K, V> target);

    /**
     * Evict the cacheEntry in the cacheEntryList when the cache capacity is met
     * also remove the entry from the cacheIndex
     * @param cacheIndex
     * @param cacheEntryList
     * @return
     */
    K evict(CacheIndex<K, V> cacheIndex, CacheEntryList<K, V> cacheEntryList);

    /**
     * Put the cacheEntry into the cacheIndex as well as put it into the cacheEntryList
     * @param cacheIndex
     * @param cacheEntryList
     * @param entry the cacheEntry that need to be put
     */
    void doPut(CacheIndex<K, V> cacheIndex, CacheEntryList<K, V> cacheEntryList, CacheEntry<K, V> entry);
}
