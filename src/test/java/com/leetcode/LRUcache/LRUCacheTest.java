package com.leetcode.LRUcache;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * leetcode LRU cache
 *
 * @author 송훤출
 * @since 20.05.25
 */
public class LRUCacheTest {

    @Test
    public void 예제1() {
        final LRUCache cache = new LRUCache(1);
        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertThat(cache.get(1), is(1));
        cache.put(3, 3);
        Assert.assertThat(cache.get(2), is(-1));
        cache.put(4, 4);
        Assert.assertThat(cache.get(1), is(-1));
        Assert.assertThat(cache.get(3), is(3));
        Assert.assertThat(cache.get(4), is(4));
    }
}
