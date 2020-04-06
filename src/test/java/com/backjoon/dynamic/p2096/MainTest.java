package com.backjoon.dynamic.p2096;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author 송훤출
 * @since 20.04.06
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[][] board = {
                {1, 2, 3},
                {4, 5, 6},
                {4, 9, 0}
        };

        Assert.assertThat(new int[]{18, 6}, is(Main.solve(board)));
    }

    @Test
    public void 예제2() {
        int[][] board = {
                {0, 0},
                {0, 0},
        };

        Assert.assertThat(new int[]{0, 0}, is(Main.solve(board)));
    }
}
