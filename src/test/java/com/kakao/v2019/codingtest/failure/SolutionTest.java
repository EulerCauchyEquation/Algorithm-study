package com.kakao.v2019.codingtest.failure;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * 2019 KAKAO 블라인드 코딩 테스트 : 실패율 test
 *
 * @author 송훤출
 * @since 20.05.20
 */
public class SolutionTest {

    @Test
    public void 예제1() {
        int n = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        Assert.assertThat(Solution.solution(n, stages), is(new int[]{3, 4, 2, 1, 5}));
    }

    @Test
    public void 예제2() {
        int n = 4;
        int[] stages = {4, 4, 4, 4, 4};
        Assert.assertThat(Solution.solution(n, stages), is(new int[]{4, 1, 2, 3}));
    }

    @Test
    public void 예제3() {
        int n = 5;
        int[] stages = {2, 2, 2, 2, 2};
        Assert.assertThat(Solution.solution(n, stages), is(new int[]{2, 1, 3, 4, 5}));
    }
}
