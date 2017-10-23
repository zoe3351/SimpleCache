package DesignCache;

/**
 * Created by jindong on 10/5/17.
 * The LRU Cache Strategy relevant to put, evict and rank {@link CacheEntry} in {@link CacheEntryList} and {@link CacheIndex}
 */
public class LRUCacheStrategy<K> implements CacheStrategy<K> {

    private CacheIndex<K, CacheKeyEntry<K>> cacheKeyMap = new CacheIndex<>();
    private CacheKeyList<K> cacheKeyList = new CacheKeyList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void onGet(K key) {
        CacheKeyEntry<K> target = cacheKeyMap.getEntry(key);
        cacheKeyList.removeKey(target);
        // move current to tail
        cacheKeyList.appendKey(target);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public K evict() {
        // evict entry from head
        K keyEvicted = cacheKeyList.evictHead();
        cacheKeyMap.removeEntry(keyEvicted);
        return keyEvicted;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onPut(K key) {
        CacheKeyEntry<K> newEntry = new CacheKeyEntry<>(key);
        cacheKeyMap.putEntry(key, newEntry);
        // prepend entry to tail
        cacheKeyList.appendKey(newEntry);
    }
}
