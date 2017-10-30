package DesignCache;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by jindong on 10/26/17.
 */
public class randomCacheStrategy<K> implements CacheStrategy<K> {

    Map<Integer, K> map = new HashMap<Integer, K>();

    int currIdx = 0;

    /**
     */
    public void onGet(K key){

    }

    /**
     * @return key to evict
     */
    public K evict(){
        int random = Math.random(this.map.size());

        while(!this.map.containsKey(random)) {
            random = Math.random(this.map.size());
        }

        K keyToEvict = map.get(random);
        map.remove(keyToEvict);
        return keyToEvict;
    }

    /**
     */
    void onPut(K key){
        int idx = currIdx + 1;
        if (!map.contaninsKey(key)) {
            map.put(idx, key);
        }
        currIdx++;
    }



}
