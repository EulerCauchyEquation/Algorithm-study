package com.kakao.v2018.codingtest.caches;

/**
 * 2018 카카오 블라인드 코딩 테스트 : 캐시 문제
 *
 * @author 송훤출
 * @since 20.05.10
 */
public class Solution {

    public static int solution(int cacheSize, String[] cities) {
        Scheduler scheduler = new Scheduler(cacheSize);
        scheduler.execute(cities);

        return scheduler.getHit() + scheduler.getMiss() * 5;
    }
}
