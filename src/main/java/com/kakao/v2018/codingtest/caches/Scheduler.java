package com.kakao.v2018.codingtest.caches;

import java.util.*;
import java.util.stream.Collectors;

public class Scheduler {
    private final HashMap<Cache, CacheItem> cacheTable;
    private final int frameSize;
    private CacheItem head;
    private CacheItem tail;
    private int hit;
    private int miss;

    public Scheduler(int frameSize) {
        this.frameSize = frameSize;
        this.cacheTable = new HashMap<>();
    }

    public void execute(String[] caches) {
        List<Cache> demandList = Arrays.stream(caches)
                .map(Cache::new)
                .collect(Collectors.toList());

        for (Cache cache : demandList) {
            analyze(cache);
        }
    }

    private void analyze(Cache cache) {
        if (cacheTable.containsKey(cache)) {
            remove(cache);
            hit++;
        } else {
            if (isFull()) {
                removeFirst();
            }
            miss++;
        }
        addFirst(cache);
    }

    private void remove(Cache cache) {
        CacheItem cacheItem = cacheTable.get(cache);

        if (cacheTable.isEmpty() || cacheItem == null) {
            throw new NoSuchElementException();
        }

        cacheTable.remove(cache);

        if (cacheItem == head) {
            head = head.next;
            head.prev = null;
        } else {
            cacheItem.prev.next = cacheItem.next;
        }
        if (cacheItem == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            cacheItem.next.prev = cacheItem.prev;
        }

    }

    private void removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        cacheTable.remove(head.cache);

        head = head.next;
        head.prev = null;

    }

    private void addFirst(Cache cache) {
        CacheItem cacheItem = new CacheItem(cache);
        cacheTable.put(cache, cacheItem);

        if (tail == null) {
            head = tail = cacheItem;
            return;
        }

        tail.next = cacheItem;
        cacheItem.prev = tail;
        tail = cacheItem;
    }

    private boolean isFull() {
        return frameSize != 0 && cacheTable.size() == frameSize;
    }

    public int getHit() {
        return hit;
    }

    public int getMiss() {
        return miss;
    }

    static private class Cache {
        private final String name;

        public Cache(String name) {
            this.name = name.toLowerCase();
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj instanceof Cache) {
                Cache another = (Cache) obj;
                return this.name.equals(another.name);
            }
            return false;
        }
    }

    static private class CacheItem {
        private final Cache cache;
        private CacheItem prev;
        private CacheItem next;

        public CacheItem(Cache cache) {
            this(null, cache, null);
        }

        public CacheItem(CacheItem prev, Cache cache, CacheItem next) {
            this.cache = cache;
            this.prev = prev;
            this.next = next;
        }
    }
}
