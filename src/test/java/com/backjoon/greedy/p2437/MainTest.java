package com.backjoon.greedy.p2437;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.21
 */
public class MainTest {

    @Test
    public void 에제1() {
        int[] ballasts = {3, 1, 6, 2, 7, 30, 1};
        Assert.assertThat(21, CoreMatchers.is(Main.solve(ballasts)));
    }

    @Test
    public void 에제2() {
        int[] ballasts = {1};
        Assert.assertThat(2, CoreMatchers.is(Main.solve(ballasts)));
    }
}
