package com.backjoon.dynamic.p2240;

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
        int w = 2;
        int[] times = {2, 1, 1, 2, 2, 1, 1};
        Assert.assertThat(6, CoreMatchers.is(Main.solve(times, w)));
    }

    @Test
    public void 예제2() {
        int w = 2;
        int[] times = {2, 1, 1, 2};
        Assert.assertThat(3, CoreMatchers.is(Main.solve(times, w)));
    }
}
