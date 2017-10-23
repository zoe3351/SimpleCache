package DesignCache;

/**
 * Created by jindong on 10/4/17.
 */
public class CacheFactory {

    /**
     * Create 4-way associative cache of corresponding data type using LRU cache strategy as default
     * @param capacity the total size of the cache
     * @return Cache with default LRU cache strategy
     */
    public static <K, V> Cache<K, V> createCache(int capacity) {
        return new Cache<>(new LRUCacheStrategy<K>(), capacity, 4);
    }

    /**
     * Create cache of corresponding data type using LRU cache strategy as default
     * @param capacity the total size of the cache
     * @param associativity the associativity of the cache i.e. the size of each cache bucket
     * @return Cache with default LRU cache strategy
     */
    public static <K, V> Cache<K, V> createCache(int capacity, int associativity) {
        return new Cache<>(new LRUCacheStrategy<K>(), capacity, associativity);
    }

    /**
     * Create cache of corresponding data type using particular cache strategy
     * @param cacheStrategy the strategy of cache i.e. LRU, MRU
     * @param capacity the total size of the cache
     * @param associativity the associativity of the cache i.e. the size of each cache bucket
     * @return Cache
     */
    public static <K, V> Cache<K, V> createCache(CacheStrategy<K> cacheStrategy, int capacity, int associativity) {
        return new Cache<>(cacheStrategy, capacity, associativity);
    }
}