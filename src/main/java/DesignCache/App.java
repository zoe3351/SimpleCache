package DesignCache;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        testLRUCache();
        testMRUCache();
    }


    public static void testLRUCache() {

        System.out.println("=========================================");
        System.out.println("*********** LRUCache Test Start *********");
        System.out.println("=========================================");

        Cache<Integer, Integer> lruCache = CacheFactory.createLRUCache(3);

        lruCache.put(1, 22);
        lruCache.put(2, 23);
        lruCache.put(3, 27);
        lruCache.put(4, 29);
        lruCache.put(5, 28);
        lruCache.put(6, 21);
        lruCache.put(7, 24);

        if (lruCache.size() != 3) {
            throw new RuntimeException("test failed!");
        }

        if (lruCache.get(4) != null) {
            throw new RuntimeException("test failed!");
        }

        if (lruCache.get(7) != 24) {
            throw new RuntimeException("test failed!");
        }

        System.out.println("********* LRUCache Test Success *********");
        System.out.println("=========================================");
        System.out.println("*********** LRUCache Test End ***********");
        System.out.println("=========================================");

    }

    public static void testMRUCache() {

        System.out.println("=========================================");
        System.out.println("*********** MRUCache Test Start *********");
        System.out.println("=========================================");

        Cache<Integer, Integer> mruCache = CacheFactory.createMRUCache(3);

        mruCache.put(1, 22);
        mruCache.put(2, 23);
        mruCache.put(3, 27);
        mruCache.put(4, 29);
        mruCache.put(5, 28);
        mruCache.put(6, 21);
        mruCache.put(7, 24);

        if (mruCache.size() != 3) {
            throw new RuntimeException("test failed!");
        }

        if (mruCache.get(1) != 22) {
            throw new RuntimeException("test failed!");
        }

        if (mruCache.get(7) != 24) {
            throw new RuntimeException("test failed!");
        }

        System.out.println("********* MRUCache Test Success *********");
        System.out.println("=========================================");
        System.out.println("*********** MRUCache Test End ***********");
        System.out.println("=========================================");

    }
}
