package com.backjoon.bitmask.p1562;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author 송훤출
 * @since 20.04.10
 */
public class MainTest {

    @Test
    public void 에제1() {
        int n = 10;

        Assert.assertThat(1, is(Main.solve(n)));
    }

    @Test
    public void 에제2() {
        int n = 7;

        Assert.assertThat(0, is(Main.solve(n)));
    }
}
