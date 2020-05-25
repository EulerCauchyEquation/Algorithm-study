package com.leetcode.LFUcache;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * leetcode LFU Cache test
 *
 * @author 송훤출
 * @since 20.05.25
 */
public class LFUCacheTest {

    @Test
    public void 예제1() {
        final LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertThat(cache.get(1), is(1));
        cache.put(3, 3);
        Assert.assertThat(cache.get(2), is(-1));
        Assert.assertThat(cache.get(3), is(3));
        cache.put(4, 4);
        Assert.assertThat(cache.get(1), is(-1));
        Assert.assertThat(cache.get(3), is(3));
        Assert.assertThat(cache.get(4), is(4));
    }

    @Test
    public void 예제2() {
        final LFUCache cache = new LFUCache(2);
        cache.put(2, 1);
        cache.put(3, 2);
        Assert.assertThat(cache.get(3), is(2));
        Assert.assertThat(cache.get(2), is(1));
        cache.put(4, 3);
        Assert.assertThat(cache.get(2), is(1));
        Assert.assertThat(cache.get(3), is(-1));
        Assert.assertThat(cache.get(4), is(3));
    }

    @Test
    public void 예제3() {
        final LFUCache cache = new LFUCache(2);
        cache.put(3, 1);
        cache.put(2, 1);
        cache.put(2, 2);
        cache.put(4, 4);
        Assert.assertThat(cache.get(2), is(2));
    }
}
