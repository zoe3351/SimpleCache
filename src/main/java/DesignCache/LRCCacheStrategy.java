package DesignCache;

/**
 * Created by jindong on 10/9/17.
 * LRC (Least Recent Created) eviction strategy, as an example how to create your own eviction strategy.
 */
public class LRCCacheStrategy<K> implements CacheStrategy<K> {

    private CacheKeyList<K> cacheKeyList = new CacheKeyList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void onGet(K key) {
        // Do nothing for LRC.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public K evict() {
        // evict entry from head
        K keyEvicted = cacheKeyList.evictHead();
        return keyEvicted;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onPut(K key) {
        // prepend entry to tail
        CacheKeyEntry<K> newEntry = new CacheKeyEntry<>(key);
        cacheKeyList.appendKey(newEntry);
    }
}
