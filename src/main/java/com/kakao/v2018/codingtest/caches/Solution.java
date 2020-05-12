package com.kakao.v2018.codingtest.caches;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2018 카카오 블라인드 코딩 테스트 : 캐시 문제
 *
 * @author 송훤출
 * @since 20.05.10
 */
public class Solution {

    public static int solution(int cacheSize, String[] caches) {
        final Queue<String> cacheTable = new LinkedList<>();
        int hit = 0;
        int miss = 0;

        for (String cache : caches) {
            cache = cache.toLowerCase();

            if (cacheTable.contains(cache)) {
                cacheTable.remove(cache);
                hit++;
            } else {
                if (cacheSize != 0 && cacheTable.size() == cacheSize) {
                    cacheTable.poll();
                }
                miss++;
            }
            cacheTable.offer(cache);
        }

        return cacheSize == 0
                ? caches.length * 5
                : hit + miss * 5;
    }
}
