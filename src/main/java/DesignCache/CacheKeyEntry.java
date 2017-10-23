package DesignCache;

/**
 * Created by jindong on 10/21/17.
 * The basic key-value record of the cache, with the pointer to its previous entry and the next entry inside of the {@link CacheEntryList}
 */
public class CacheKeyEntry<K> {
    public CacheKeyEntry<K> prev;
    public CacheKeyEntry<K> next;
    public K key;

    public CacheKeyEntry(K key) {
        this.key = key;
        this.prev = null;
        this.next = null;
    }

    public String toString() {
        return String.format("(%s)", key);
    }
}
