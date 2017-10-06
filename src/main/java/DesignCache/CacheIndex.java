package DesignCache;

import java.util.HashMap;

/**
 * Created by jindong on 10/5/17.
 */
public class CacheIndex<K, V> {

    private HashMap<K, CacheEntry<K, V>> cacheEntryHashMap = new HashMap<>();

    public CacheEntry<K, V> getEntry(K key) {
        return cacheEntryHashMap.get(key);
    }

    public void putEntry(K key, CacheEntry cacheEntry) {
        cacheEntryHashMap.put(key, cacheEntry);
    }

    public void removeEntry(K key) {
        cacheEntryHashMap.remove(key);
    }

    public int getSize() {
        return cacheEntryHashMap.size();
    }
}
