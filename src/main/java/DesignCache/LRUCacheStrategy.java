package DesignCache;

/**
 * Created by jindong on 10/5/17.
 */
public class LRUCacheStrategy<K, V> implements CacheStrategy<K, V> {

    public void postGet(CacheEntryList<K, V> cacheEntryList, CacheEntry<K, V> target) {
        cacheEntryList.removeEntry(target);
        // move current to tail
        cacheEntryList.appendEntry(target);
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
        cacheEntryList.appendEntry(entry);
    }
}
