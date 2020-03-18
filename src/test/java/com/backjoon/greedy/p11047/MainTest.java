package com.backjoon.greedy.p11047;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.18
 */
public class MainTest {

    @Test
    public void 예제0() {
        Integer[] coinType = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        Assert.assertThat(10000, CoreMatchers.is(Main.solve(coinType, 10000)));
    }

    @Test
    public void 예제1() {
        Integer[] coinType = {1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000};
        Assert.assertThat(6, CoreMatchers.is(Main.solve(coinType, 4200)));
    }

    @Test
    public void 예제2() {
        Integer[] coinType = {1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000};
        Assert.assertThat(12, CoreMatchers.is(Main.solve(coinType, 4790)));
    }
}
