package DesignCache;

import java.util.HashMap;

/**
 * Created by jindong on 10/4/17.
 */

public class Cache<K, V> {

    int capacity;
    CacheIndex<K, V> cacheIndex = new CacheIndex<>();
    CacheEntryList<K, V> cacheEntryList = new CacheEntryList<>();

    private CacheStrategy<K, V> strategy;

    public Cache(CacheStrategy strategy, int capacity) {
        this.strategy = strategy;
        this.capacity = capacity;
    }

    public V get(K key) {
        if(cacheIndex.getEntry(key) == null) {
            return null;
        }

        CacheEntry<K, V> target = cacheIndex.getEntry(key);
        strategy.postGet(cacheEntryList, target);
        return target.value;
    }

    public void put(K key, V value) {
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

    public void remove(K key) {
        CacheEntry cahceEntry = cacheIndex.getEntry(key);
        if (cahceEntry != null) {
            cahceEntry.prev.next = cahceEntry.next;
            cacheIndex.removeEntry(key);
        }
    }

//    public void clear() {
//        this.hs.clear();
//        this.head.next = this.tail;
//        this.tail.prev = this.head;
//    }
}
