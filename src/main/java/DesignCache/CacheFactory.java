package DesignCache;

/**
 * Created by jindong on 10/4/17.
 */
public class CacheFactory {
    public static <K, V> Cache<K, V> createLRUCache(int capacity) {
        return new LRUCache<>(capacity);
    }

    public static <K, V> Cache<K, V> createMRUCache(int capacity) {
        return new MRUCache<>(capacity);
    }

    public static <K, V> Cache<K, V> createCache(int capacity, CacheStrategy<K, V> cacheStrategy) {
        return new Cache<>(cacheStrategy, capacity);
    }
}

//public class CacheFactory {
//    public static Cache create(int capacity) {
//        Cache cache = new Cache(capacity);
//        return cache;
//    }
//}
