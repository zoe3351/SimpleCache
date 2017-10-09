package DesignCache;

/**
 * Created by jindong on 10/5/17.
 * The MRU Cache Strategy relevant to put, evict and rank {@link CacheEntry} in {@link CacheEntryList} and {@link CacheIndex}
 */
public class MRUCacheStrategy<K, V> implements CacheStrategy<K, V> {

    /**
     * {@inheritDoc}
     */
    public void postGet(CacheEntryList<K, V> cacheEntryList, CacheEntry<K, V> target) {
        cacheEntryList.removeEntry(target);
        // move current to head
        cacheEntryList.prependEntry(target);
    }

    /**
     * {@inheritDoc}
     */
    public K evict(CacheIndex<K, V> cacheIndex, CacheEntryList<K, V> cacheEntryList) {
        // evict entry from head
        K keyEvicted = cacheEntryList.evictHead();
        cacheIndex.removeEntry(keyEvicted);
        return keyEvicted;
    }

    /**
     * {@inheritDoc}
     */
    public void doPut(CacheIndex<K, V> cacheIndex, CacheEntryList<K, V> cacheEntryList, CacheEntry<K, V> entry) {
        cacheIndex.putEntry(entry.key, entry);
        // prepend entry to head
        cacheEntryList.prependEntry(entry);
    }
}
