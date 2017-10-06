package DesignCache;

/**
 * Created by jindong on 10/5/17.
 */
public class CacheEntry<K, V> {
    public CacheEntry<K, V> prev;
    public CacheEntry<K, V> next;
    public K key;
    public V value;

    public CacheEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
