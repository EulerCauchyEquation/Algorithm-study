package com.backjoon.dynamic.p9663;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.13
 */
public class MainTest {

    @Test
    public void 예제1() {
        Assert.assertThat(92, CoreMatchers.is(Main.solve(8)));
    }

    @Test
    public void 예제2() {
        Assert.assertThat(1, CoreMatchers.is(Main.solve(1)));
    }
}
