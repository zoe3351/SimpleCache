package DesignCache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jindong on 10/5/17.
 * The doubly-linked list of {@link CacheEntry} to rank the CacheEntry in a way that help to implement specific {@link CacheStrategy}
 * Containing two dummy node indicating the head and the tail of the list
 */
public class CacheEntryList<K, V> {
    CacheEntry<K, V> head = new CacheEntry<>(null, null);
    CacheEntry<K, V> tail = new CacheEntry<>(null, null);

    public CacheEntryList() {
        tail.prev = head;
        head.next = tail;
    }

    /**
     * Append the entry to the tail of the CacheEntryList
     * @param entry
     */
    public void appendEntry(CacheEntry entry) {
        entry.prev = tail.prev;
        tail.prev = entry;
        entry.prev.next = entry;
        entry.next = tail;
    }

    /**
     * Prepend the entry to the head of the CacheEntryList
     * @param entry
     */
    public void prependEntry(CacheEntry entry) {
        entry.next = head.next;
        head.next = entry;
        entry.next.prev = entry;
        entry.prev = head;
    }

    /**
     * Remove the entry from the CacheEntryList
     * @param entry
     */
    public void removeEntry(CacheEntry entry) {
        entry.prev.next = entry.next;
        entry.next.prev = entry.prev;
    }

    /**
     * Evict the entry from the head of the CacheEntryList
     * @return
     */
    public K evictHead() {
        K keyEvicted = head.next.key;
        head.next = head.next.next;
        head.next.prev = head;
        return keyEvicted;
    }

    @Override
    public String toString() {
        CacheEntry<K, V> it = head.next;

        List<String> res = new ArrayList<>();
        while (it != tail) {
            res.add(it.toString());
            it = it.next;
        }

        return Arrays.toString(res.toArray());
    }
}
