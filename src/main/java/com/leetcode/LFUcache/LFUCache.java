package com.leetcode.LFUcache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * leetcode LFU Cache
 *
 * @author 송훤출
 * @since 20.05.25
 */
public class LFUCache {
    private final Map<Integer, Cache> cacheTable;
    private final int capacity;

    public LFUCache(int capacity) {
        this.cacheTable = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        final Cache cache = cacheTable.get(key);
        if (cache != null) {
            cacheTable.remove(key);
            cache.frequency++;
            cache.value = value;
        } else {
            if (isFull()) {
                int min = getLeastReferencedCache();
                cacheTable.remove(min);
            }
        }
        Cache newCache = (cache != null) ? cache : new Cache(key, value);
        cacheTable.put(key, newCache);
    }

    private int getLeastReferencedCache() {
        int min = 0;
        int frequency = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Cache> entry : cacheTable.entrySet()) {
            Cache cache = entry.getValue();
            if (frequency - cache.frequency > 0) {
                min = entry.getKey();
                frequency = cache.frequency;
            }
        }
        return min;
    }

    private boolean isFull() {
        return cacheTable.size() == capacity;
    }

    public int get(int key) {
        final Cache cache = cacheTable.get(key);
        if (cache == null) {
            return -1;
        }
        cacheTable.remove(key);
        cacheTable.put(key, cache);
        cache.frequency++;
        return cache.value;
    }

    private static class Cache {
        final int key;
        int value;
        int frequency;

        Cache(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key);
        }
    }
}
