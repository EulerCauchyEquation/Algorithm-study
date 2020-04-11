package com.backjoon.bitmask.p1102;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author 송훤출
 * @since 20.04.10
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[][] costs = {
                {0, 10, 11},
                {10, 0, 12},
                {12, 13, 0}};
        String state = "YNN";
        int p = 3;

        Assert.assertThat(21, is(Main.solve(costs, state, p)));
    }

    @Test
    public void 예제2() {
        int[][] costs = {
                {0, 10, 11},
                {10, 0, 12},
                {12, 13, 0}};
        String state = "NNN";
        int p = 3;

        Assert.assertThat(-1, is(Main.solve(costs, state, p)));
    }

    @Test
    public void 예제3() {
        int[][] costs = {
                {0, 10, 11},
                {10, 0, 12},
                {12, 13, 0}};
        String state = "YYN";
        int p = 1;

        Assert.assertThat(0, is(Main.solve(costs, state, p)));
    }
}
