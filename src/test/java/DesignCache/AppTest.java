package DesignCache;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testApp()
    {
        testLRUCache();
        testMRUCache();
    }

    public static void testLRUCache() {

        Cache<Integer, Integer> lruCache = CacheFactory.createCache(new LRUCacheStrategy<Integer, Integer>(), 3, 3);

        lruCache.put(1, 22);
        System.out.println(lruCache);
        lruCache.put(2, 23);
        System.out.println(lruCache);
        lruCache.put(3, 27);
        System.out.println(lruCache);
        lruCache.put(4, 29);
        System.out.println(lruCache);
        lruCache.put(5, 28);
        System.out.println(lruCache);
        lruCache.put(6, 21);
        System.out.println(lruCache);
        lruCache.put(7, 24);
        System.out.println(lruCache);

        assertNull(lruCache.get(4));
        assertEquals(lruCache.get(7).intValue(), 24);
    }

    public static void testMRUCache() {

        Cache<Integer, Integer> mruCache = CacheFactory.createCache(new MRUCacheStrategy<Integer, Integer>(), 3, 3);

        mruCache.put(1, 22);
        System.out.println(mruCache);
        mruCache.put(2, 23);
        System.out.println(mruCache);
        mruCache.put(3, 27);
        System.out.println(mruCache);
        mruCache.put(4, 29);
        System.out.println(mruCache);
        mruCache.put(5, 28);
        System.out.println(mruCache);
        mruCache.put(6, 21);
        System.out.println(mruCache);
        mruCache.put(7, 24);

        assertEquals(mruCache.get(1).intValue(), 22);
        assertEquals(mruCache.get(7).intValue(), 24);
    }
}
