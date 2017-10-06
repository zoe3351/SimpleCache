package DesignCache;

/**
 * Created by jindong on 10/4/17.
 */
public class LRUCache<K, V> extends Cache<K, V> {
    public LRUCache(int capacity) {
        super(new LRUCacheStrategy(), capacity);
    }
}