package DesignCache;

/**
 * Created by jindong on 10/5/17.
 * The MRU Cache Strategy relevant to put, evict and rank {@link CacheEntry} in {@link CacheEntryList} and {@link CacheIndex}
 */
public class MRUCacheStrategy<K> implements CacheStrategy<K> {

    private K mostRecentlyUsedKey = null;
    /**
     * {@inheritDoc}
     */
    public void onGet(K key) {
        mostRecentlyUsedKey = key;
    }

    /**
     * {@inheritDoc}
     */
    public K evict() {
        // evict entry from head
        K keyEvicted = mostRecentlyUsedKey;
        return keyEvicted;
    }

    /**
     * {@inheritDoc}
     */
    public void onPut(K key) {
        mostRecentlyUsedKey = key;
    }
}
