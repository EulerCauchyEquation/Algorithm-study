package com.backjoon.dynamic.p11053;

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
        int[] sequence = {10, 20, 40, 25, 20, 50, 30, 70, 85};

        Assert.assertThat(6, CoreMatchers.is(Main.solve(sequence)));
    }

    @Test
    public void 예제2() {
        int[] sequence = {85, 50, 35};

        Assert.assertThat(1, CoreMatchers.is(Main.solve(sequence)));
    }

    @Test
    public void 예제3() {
        int[] sequence = {85};

        Assert.assertThat(1, CoreMatchers.is(Main.solve(sequence)));
    }

    @Test
    public void 예제4() {
        int[] sequence = {10, 50, 60, 11, 12};

        Assert.assertThat(3, CoreMatchers.is(Main.solve(sequence)));
    }

    @Test
    public void 예제5() {
        int[] sequence = {10, 20, 5, 10, 20};

        Assert.assertThat(3, CoreMatchers.is(Main.solve(sequence)));
    }
}
