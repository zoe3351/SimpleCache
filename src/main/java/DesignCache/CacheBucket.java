package DesignCache;

/**
 * Created by jindong on 10/4/17.
 * The CacheEntry group of {@link Cache} with specific {@link CacheStrategy}
 * Has two main data structures: {@link CacheIndex} and {@link CacheEntryList}
 */

public class CacheBucket<K, V> {

    private int capacity;
    private CacheIndex<K, V> cacheIndex = new CacheIndex<>();
    private CacheEntryList<K, V> cacheEntryList = new CacheEntryList<>();

    private CacheStrategy<K, V> strategy;

    public CacheBucket(CacheStrategy strategy, int capacity) {
        this.strategy = strategy;
        this.capacity = capacity;
    }

    /**
     * Get the value of CacheEntry with the key
     * @param key
     * @return value
     */
    public V get(K key) {
        if(cacheIndex.getEntry(key) == null) {
            return null;
        }

        synchronized (this) {
            CacheEntry<K, V> target = cacheIndex.getEntry(key);
            strategy.postGet(cacheEntryList, target);
            return target.value;
        }
    }

    /**
     * Put the CacheEntry into the CacheIndex as well as the CacheEntryList and arrange it in a specific strategy way
     * @param key
     * @param value
     */
    public synchronized void put(K key, V value) {
        // this internal `get` method will update the key's position in the linked list.
        if (get(key) != null) {
            cacheIndex.getEntry(key).value = value;
            return;
        }

        if (cacheIndex.getSize() == capacity) {
            strategy.evict(cacheIndex, cacheEntryList);
        }

        CacheEntry<K, V> newEntry = new CacheEntry<>(key, value);
        strategy.doPut(cacheIndex, cacheEntryList, newEntry);
    }

    public int size() {
        return cacheIndex.getSize();
    }

    @Override
    public String toString() {
        return cacheEntryList.toString();
    }
}
