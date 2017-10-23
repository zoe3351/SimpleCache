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

        Cache<String, String> lruCache = CacheFactory.createCache(new LRUCacheStrategy<String>(), 3, 3);

        lruCache.put("random", "mache");
        lruCache.put("string", "23");
        lruCache.put("else", "345");
        lruCache.put("what", "sdf");
        lruCache.put("make", "45");
        lruCache.put("dela", "21");
        lruCache.put("random", "24");

        assertNull(lruCache.get("what"));
        assertEquals(lruCache.get("random"), "24");
    }

    public static void testMRUCache() {

        Cache<Integer, Integer> mruCache = CacheFactory.createCache(new MRUCacheStrategy<Integer>(), 3, 3);

        mruCache.put(1, 22);
        mruCache.put(2, 23);
        mruCache.put(3, 27);
        mruCache.put(4, 29);
        mruCache.put(5, 28);
        mruCache.put(6, 21);
        mruCache.put(7, 24);

        assertEquals(mruCache.get(1).intValue(), 22);
        assertEquals(mruCache.get(7).intValue(), 24);
    }
}
