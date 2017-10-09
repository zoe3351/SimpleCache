package DesignCache;

/**
 * Created by jindong on 10/9/17.
 * LRC (Least Recent Created) eviction strategy, as an example how to create your own eviction strategy.
 */
public class LRCCacheStrategy<K, V> implements CacheStrategy<K, V> {

    /**
     * {@inheritDoc}
     */
    @Override
    public void postGet(CacheEntryList<K, V> cacheEntryList, CacheEntry<K, V> target) {
        // Do nothing for LRC.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public K evict(CacheIndex<K, V> cacheIndex, CacheEntryList<K, V> cacheEntryList) {
        // evict entry from head
        K keyEvicted = cacheEntryList.evictHead();
        cacheIndex.removeEntry(keyEvicted);
        return keyEvicted;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doPut(CacheIndex<K, V> cacheIndex, CacheEntryList<K, V> cacheEntryList, CacheEntry<K, V> entry) {
        cacheIndex.putEntry(entry.key, entry);
        // prepend entry to tail
        cacheEntryList.appendEntry(entry);
    }
}
