package com.backjoon.greedy.p1931;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.19
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[][] meetings = {
                {1, 4},
                {3, 5},
                {0, 6},
                {5, 7},
                {3, 8},
                {5, 9},
                {6, 10},
                {8, 11},
                {8, 12},
                {2, 13},
                {1, 2},
                {1, 4}};
        Assert.assertThat(4, CoreMatchers.is(Main.solve(meetings)));
    }

    @Test
    public void 예제2() {
        int[][] meetings = {
                {1, 4},
                {1, 4}};
        Assert.assertThat(1, CoreMatchers.is(Main.solve(meetings)));
    }

    @Test
    public void 예제3() {
        int[][] meetings = {
                {8, 8},
                {5, 8},
                {3, 4},
                {2, 5},
                {2, 7},
                {8, 8},
                {1, 10},
                {3, 3},
                {10, 10}};
        Assert.assertThat(6, CoreMatchers.is(Main.solve(meetings)));
    }
}
