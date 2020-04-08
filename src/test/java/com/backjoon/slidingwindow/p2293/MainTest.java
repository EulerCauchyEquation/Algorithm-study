package com.backjoon.slidingwindow.p2293;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.04.08
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[] coins = {1, 2, 5};
        int k = 10;

        Assert.assertThat(10, CoreMatchers.is(Main.solve(coins, k)));
    }

    @Test
    public void 예제2() {
        int[] coins = {1, 2, 5};
        int k = 5;

        Assert.assertThat(4, CoreMatchers.is(Main.solve(coins, k)));
    }
}
