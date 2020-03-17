package com.backjoon.backtrack.p2210;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.17
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[][] board = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 2, 1},
                {1, 1, 1, 1, 1}};
        Assert.assertThat(15, CoreMatchers.is(Main.solve(board)));
    }

    @Test
    public void 예제2() {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        Assert.assertThat(1, CoreMatchers.is(Main.solve(board)));
    }
}
