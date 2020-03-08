package com.backjoon.dynamic.p2302;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.08
 */
public class MainTest {

    @Test
    public void 예제1() {
        int seats = 9;
        int[] vip = {4, 7};
        Assert.assertThat(12L, CoreMatchers.is(Main.solve(seats, vip)));
    }

    @Test
    public void 예제2() {
        int seats = 1;
        int[] vip = {};
        Assert.assertThat(1L, CoreMatchers.is(Main.solve(seats, vip)));
    }

    @Test
    public void 예제3() {
        int seats = 1;
        int[] vip = {1};
        Assert.assertThat(1L, CoreMatchers.is(Main.solve(seats, vip)));
    }

    @Test
    public void 예제4() {
        int seats = 3;
        int[] vip = {};
        Assert.assertThat(3L, CoreMatchers.is(Main.solve(seats, vip)));
    }

    @Test
    public void 예제5() {
        int seats = 3;
        int[] vip = {1, 2, 3};
        Assert.assertThat(1L, CoreMatchers.is(Main.solve(seats, vip)));
    }

    @Test
    public void 예제6() {
        int seats = 4;
        int[] vip = {1, 2};
        Assert.assertThat(2L, CoreMatchers.is(Main.solve(seats, vip)));
    }
}
