package DesignCache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jindong on 10/5/17.
 * The ConcurrentHashMap of {@link CacheEntry} with the key of the CacheEntry as the key, and the CacheEntry as the value, tread safe
 */
public class CacheIndex<K, V> {

    private Map<K, V> cacheEntryHashMap = new ConcurrentHashMap<>();

    public V getEntry(K key) {
        return cacheEntryHashMap.get(key);
    }

    public void putEntry(K key, V value) {
        cacheEntryHashMap.put(key, value);
    }

    public void removeEntry(K key) {
        cacheEntryHashMap.remove(key);
    }

    public int getSize() {
        return cacheEntryHashMap.size();
    }
}
