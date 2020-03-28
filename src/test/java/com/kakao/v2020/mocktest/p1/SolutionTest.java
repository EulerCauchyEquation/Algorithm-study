package com.kakao.v2020.mocktest.p1;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.28
 */
public class SolutionTest {

    @Test
    public void 예제1() {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        Assert.assertThat(4, CoreMatchers.is(Solution.solution(board, moves)));
    }

    @Test
    public void 예제2() {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        Assert.assertThat(0, CoreMatchers.is(Solution.solution(board, moves)));
    }
}
