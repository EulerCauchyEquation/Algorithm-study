package com.leetcode.LRUcache;

import java.util.HashMap;
import java.util.Map;

/**
 * 리트코드 : LRU Cache
 *
 * @author 송훤출
 * @since 20.05.25
 */
public class LRUCache {
    private final Map<Integer, Cache> demandQueue;
    private final int capacity;
    private Cache head;
    private Cache tail;

    public LRUCache(int capacity) {
        this.demandQueue = new HashMap<>();
        this.capacity = capacity;
    }

    // if the key exists in the cache (independent value), remove it from our doubly linked list
    // and add it back, overwriting the existing cache
    // if the cache is full, remove back of our doubly linked list to insert the new cache
    public void put(int key, int value) {
        if (demandQueue.containsKey(key)) {
            remove(key);
        } else {
            if (isFull()) {
                removeFirst();
            }
        }
        addLast(key, value);
    }

    private void addLast(int key, int value) {
        final Cache newCache = new Cache(key, value);
        if (head == null) {
            head = tail = newCache;
            demandQueue.put(key, newCache);
            return;
        }
        tail.next = newCache;
        newCache.prev = tail;
        tail = newCache;
        demandQueue.put(key, newCache);
    }

    private void remove(int key) {
        final Cache cache = demandQueue.get(key);
        if (cache.prev == null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            cache.prev.next = cache.next;
        }
        if (cache.next == null) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            cache.next.prev = cache.prev;
        }
        demandQueue.remove(key);
    }

    private void removeFirst() {
        demandQueue.remove(head.key);
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    private boolean isFull() {
        return demandQueue.size() == capacity;
    }

    // if the value is in the cache, remove it and re-add it
    // to the front of our doubly linked list
    public int get(int key) {
        final Cache cache = demandQueue.get(key);
        if (cache != null) {
            remove(cache.key);
            addLast(cache.key, cache.value);
        }
        return cache == null ? -1 : cache.value;
    }

    private static class Cache {
        final int key;
        final int value;
        Cache prev;
        Cache next;

        Cache(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
