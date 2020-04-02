package com.backjoon.dynamic.p1495;

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
        int s = 5;
        int m = 10;
        int[] volumes = {5, 3, 7};

        Assert.assertThat(10, CoreMatchers.is(Main.solve(s, m, volumes)));
    }

    @Test
    public void 예제2() {
        int s = 10;
        int m = 20;
        int[] volumes = {1, 2, 3};

        Assert.assertThat(16, CoreMatchers.is(Main.solve(s, m, volumes)));
    }
}
