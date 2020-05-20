package com.kakao.v2019.codingtest.route;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * 2019 KAKAO 블라인드 코딩 테스트 : 길 찾기 게임 test
 *
 * @author 송훤출
 * @since 20.05.20
 */
public class SolutionTest {

    @Test
    public void 예제1() {
        final int[][] nodeinfo = {
                {5, 3},
                {11, 5},
                {13, 3},
                {3, 5},
                {6, 1},
                {1, 3},
                {8, 6},
                {7, 2},
                {2, 2}
        };
        final int[][] result = {
                {7, 4, 6, 9, 1, 8, 5, 2, 3},
                {9, 6, 5, 8, 1, 4, 3, 2, 7}
        };

        Assert.assertThat(Solution.solution(nodeinfo), is(result));
    }
}
