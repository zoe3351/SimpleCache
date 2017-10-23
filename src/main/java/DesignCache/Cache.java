package DesignCache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jindong on 10/6/17.
 * The central role to manipulate in-memory N-Way Set-Associative cache
 * Able to store any arbitrary data types
 *
 */
public class Cache<K, V> {
    private int associativity;
    private int size;
    private CacheBucket<K, V>[] cacheBuckets;

    public Cache(CacheStrategy<K> strategy, int size) {
        this(strategy, size, 4);
    }

    public Cache(CacheStrategy<K> strategy, int size, int associativity) {
        if (associativity > 0 && size > 0 && size % associativity == 0) {
            this.size = size;
            this.associativity = associativity;

            cacheBuckets = new CacheBucket[getSetNum()];

            for (int i = 0; i < getSetNum(); i++) {
                cacheBuckets[i] = new CacheBucket<>(strategy, associativity);
            }
        } else {
            throw new IllegalArgumentException(String.format("Illegal cache size %d, cache associativity %d.", size, associativity));
        }
    }

    /**
     * Get the record from cache using the key
     * @param key the key to get the record from cache
     * @return value the value associated with the given key. null if key not exists
     */
    public V get(K key) {
        int bucketId = getBucketId(key);
        return cacheBuckets[bucketId].get(key);
    }

    /**
     * Put key-value entry into the cache
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        int bucketId = getBucketId(key);
        cacheBuckets[bucketId].put(key, value);
    }

    private int getBucketId(K key){
        return Math.abs(key.hashCode() % getSetNum());
    }

    private int getSetNum() {
        return this.size / this.associativity;
    }

    @Override
    public String toString() {
        List<String> res = new ArrayList<>();
        for (CacheBucket<K, V> cacheBucket : cacheBuckets) {
            res.add(cacheBucket.toString());
        }
        return Arrays.toString(res.toArray());
    }

}
