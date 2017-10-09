package DesignCache;

/**
 * Created by jindong on 10/5/17.
 * The basic key-value record of the cache, with the pointer to its previous entry and the next entry inside of the {@link CacheEntryList}
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

    public String toString() {
        return String.format("(%s, %s)", key, value);
    }
}
