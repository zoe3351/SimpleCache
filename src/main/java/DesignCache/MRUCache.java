package DesignCache;

/**
 * Created by jindong on 10/4/17.
 */
public class MRUCache<K, V> extends Cache<K, V> {
    public MRUCache(int capacity) {
        super(new MRUCacheStrategy(), capacity);
    }

}
