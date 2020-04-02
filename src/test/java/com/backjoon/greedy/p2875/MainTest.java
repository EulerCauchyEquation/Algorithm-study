package com.backjoon.greedy.p2875;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.04.02
 */
public class MainTest {

    @Test
    public void 예제1() {
        int n = 6;
        int m = 3;
        int k = 2;

        Assert.assertThat(2, CoreMatchers.is(Main.solve(n, m, k)));
    }

    @Test
    public void 예제2() {
        int n = 6;
        int m = 6;
        int k = 6;

        Assert.assertThat(2, CoreMatchers.is(Main.solve(n, m, k)));
    }

    @Test
    public void 예제3() {
        int n = 5;
        int m = 6;
        int k = 2;

        Assert.assertThat(2, CoreMatchers.is(Main.solve(n, m, k)));
    }

    @Test
    public void 예제4() {
        int n = 0;
        int m = 6;
        int k = 6;

        Assert.assertThat(0, CoreMatchers.is(Main.solve(n, m, k)));
    }

    @Test
    public void 예제5() {
        int n = 2;
        int m = 2;
        int k = 0;

        Assert.assertThat(1, CoreMatchers.is(Main.solve(n, m, k)));
    }
}
