package com.backjoon.dynamic.p2193;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.15
 */
public class MainTest {

    @Test
    public void 예제1() {
        Assert.assertThat(2L, CoreMatchers.is(Main.solve(3)));
    }

    @Test
    public void 예제2() {
        Assert.assertThat(1L, CoreMatchers.is(Main.solve(1)));
    }

    @Test
    public void 예제3() {
        Assert.assertThat(5L, CoreMatchers.is(Main.solve(5)));
    }
}
