package com.backjoon.dynamic.p2169;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.10
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[][] board = {
                {10, 25, 7, 8, 13},
                {68, 24, -78, 63, 32},
                {12, -69, 100, -29, -25},
                {-16, -22, -57, -33, 99},
                {7, -76, -11, 77, 15}
        };
        Assert.assertThat(319, CoreMatchers.is(Main.solve(board)));
    }

    @Test
    public void 예제0() {
        int[][] board = {
                {-1, -5, -1, -1},
                {-4, -1, -3, -2}
        };
        Assert.assertThat(-10, CoreMatchers.is(Main.solve(board)));
    }

    @Test
    public void 예제2() {
        int[][] board = {
                {0}
        };
        Assert.assertThat(0, CoreMatchers.is(Main.solve(board)));
    }

    @Test
    public void 예제3() {
        int[][] board = {
                {10, 25},
                {68, 24},
                {90, -69}};
        Assert.assertThat(148, CoreMatchers.is(Main.solve(board)));
    }

}
