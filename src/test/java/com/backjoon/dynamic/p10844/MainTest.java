package com.backjoon.dynamic.p10844;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.23
 */
public class MainTest {

    @Test
    public void 예제1() {
        int n = 1;
        Assert.assertThat(9L, CoreMatchers.is(Main.solve(n)));
    }

    @Test
    public void 예제2() {
        int n = 2;
        Assert.assertThat(17L, CoreMatchers.is(Main.solve(n)));
    }

}
