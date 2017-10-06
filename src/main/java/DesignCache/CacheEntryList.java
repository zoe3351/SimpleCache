package DesignCache;

/**
 * Created by jindong on 10/5/17.
 */
public class CacheEntryList<K, V> {
    CacheEntry<K, V> head = new CacheEntry<>(null, null);
    CacheEntry<K, V> tail = new CacheEntry<>(null, null);

    public CacheEntryList() {
        tail.prev = head;
        head.next = tail;
    }

    public void appendEntry(CacheEntry entry) {
        entry.prev = tail.prev;
        tail.prev = entry;
        entry.prev.next = entry;
        entry.next = tail;
    }

    public void prependEntry(CacheEntry entry) {
        entry.next = head.next;
        head.next = entry;
        entry.next.prev = entry;
        entry.prev = head;
    }

    public void removeEntry(CacheEntry entry) {
        entry.prev.next = entry.next;
        entry.next.prev = entry.prev;
    }

    public K evictHead() {
        K keyEvicted = head.next.key;
        head.next = head.next.next;
        head.next.prev = head;
        return keyEvicted;
    }
}
