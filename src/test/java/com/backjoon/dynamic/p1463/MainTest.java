package com.backjoon.dynamic.p1463;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author 송훤출
 * @since 20.02.26
 */
public class MainTest {

    @Test
    public void 예제1() {
        Assert.assertThat(1, is(Main.solve(2)));
    }

    @Test
    public void 예제2() {
        Assert.assertThat(3, is(Main.solve(10)));
    }

    @Test
    public void 더_높은_수() {
        Assert.assertThat(5, is(Main.solve(60)));
    }
}
