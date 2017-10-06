package DesignCache;

/**
 * Created by jindong on 10/5/17.
 */
public class MRUCacheStrategy<K, V> implements CacheStrategy<K, V> {
    public void postGet(CacheEntryList<K, V> cacheEntryList, CacheEntry<K, V> target) {
        cacheEntryList.removeEntry(target);
        // move current to head
        cacheEntryList.prependEntry(target);
    }

    public K evict(CacheIndex<K, V> cacheIndex, CacheEntryList<K, V> cacheEntryList) {
        // evict entry from head
        K keyEvicted = cacheEntryList.evictHead();
        cacheIndex.removeEntry(keyEvicted);
        return keyEvicted;
    }

    public void doPut(CacheIndex<K, V> cacheIndex, CacheEntryList<K, V> cacheEntryList, CacheEntry<K, V> entry) {
        cacheIndex.putEntry(entry.key, entry);
        // prepend entry to head
        cacheEntryList.prependEntry(entry);
    }
}
