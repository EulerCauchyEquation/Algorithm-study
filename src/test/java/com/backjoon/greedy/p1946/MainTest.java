package com.backjoon.greedy.p1946;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.04.01
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[][] ranks = {
                {3, 2},
                {1, 4},
                {4, 1},
                {2, 3},
                {5, 5}};
        Assert.assertThat(4, CoreMatchers.is(Main.solve(ranks)));
    }

    @Test
    public void 예제2() {
        int[][] ranks = {
                {3, 6},
                {7, 3},
                {4, 2},
                {1, 4},
                {5, 7},
                {2, 5},
                {6, 1}};
        Assert.assertThat(3, CoreMatchers.is(Main.solve(ranks)));
    }

    @Test
    public void 예제3() {
        int[][] ranks = {
                {1, 1},
                {3, 2},
                {2, 3}};
        Assert.assertThat(1, CoreMatchers.is(Main.solve(ranks)));
    }
}
