package com.backjoon.greedy.p2352;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.04.03
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[] connections = {4, 2, 6, 3, 1, 5};

        Assert.assertThat(3, CoreMatchers.is(Main.solve(connections)));
    }

    @Test
    public void 예제2() {
        int[] connections = {4, 1, 2, 3};

        Assert.assertThat(3, CoreMatchers.is(Main.solve(connections)));
    }

    @Test
    public void 예제3() {
        int[] connections = {4, 5, 1, 2, 3};

        Assert.assertThat(3, CoreMatchers.is(Main.solve(connections)));
    }

    @Test
    public void 예제4() {
        int[] connections = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6};

        Assert.assertThat(6, CoreMatchers.is(Main.solve(connections)));
    }
}
