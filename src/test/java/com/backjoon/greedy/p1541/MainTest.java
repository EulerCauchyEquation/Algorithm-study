package com.backjoon.greedy.p1541;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.20
 */
public class MainTest {

    @Test
    public void 예제1() {
        String line = "55-50+40";
        Assert.assertThat(-35, CoreMatchers.is(Main.solve(line)));
    }

    @Test
    public void 예제2() {
        String line = "5";
        Assert.assertThat(5, CoreMatchers.is(Main.solve(line)));
    }

    @Test
    public void 예제3() {
        String line = "-55-50+40";
        Assert.assertThat(-145, CoreMatchers.is(Main.solve(line)));
    }
}
