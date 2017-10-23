package DesignCache;

/**
 * Created by jindong on 10/4/17.
 * The Cache Strategy Interface.
 */
public interface CacheStrategy<K> {

    /**
     */
    void onGet(K key);

    /**
     * @return key to evict
     */
    K evict();

    /**
     */
    void onPut(K key);
}
