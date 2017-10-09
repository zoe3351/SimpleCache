package DesignCache;

/**
 * Created by jindong on 10/5/17.
 * The LRU Cache Strategy relevant to put, evict and rank {@link CacheEntry} in {@link CacheEntryList} and {@link CacheIndex}
 */
public class LRUCacheStrategy<K, V> implements CacheStrategy<K, V> {

    /**
     * {@inheritDoc}
     */
    @Override
    public void postGet(CacheEntryList<K, V> cacheEntryList, CacheEntry<K, V> target) {
        cacheEntryList.removeEntry(target);
        // move current to tail
        cacheEntryList.appendEntry(target);
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
