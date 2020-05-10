package com.kakao.v2018.codingtest.caches;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * 카카오 블라인드 코딩 테스트 : 캐시 문제 test
 *
 * @author 송훤출
 * @since 20.05.10
 */
public class SolutionTest {

    @Test
    public void 예제1() {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        Assert.assertThat(Solution.solution(cacheSize, cities), is(50));
    }

    @Test
    public void 예제2() {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

        Assert.assertThat(Solution.solution(cacheSize, cities), is(21));
    }

    @Test
    public void 예제3() {
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

        Assert.assertThat(Solution.solution(cacheSize, cities), is(60));
    }

    @Test
    public void 예제4() {
        int cacheSize = 5;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

        Assert.assertThat(Solution.solution(cacheSize, cities), is(52));
    }

    @Test
    public void 예제5() {
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};

        Assert.assertThat(Solution.solution(cacheSize, cities), is(16));
    }

    @Test
    public void 예제6() {
        int cacheSize = 0;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        Assert.assertThat(Solution.solution(cacheSize, cities), is(25));
    }

    @Test
    public void 예제7() {
        int cacheSize = 3;
        String[] cities = {"0", "1", " 2", "3", "0", "1", "4", "0", "1", "2", "3", "4"};

        Assert.assertThat(Solution.solution(cacheSize, cities), is(52));
    }
}
