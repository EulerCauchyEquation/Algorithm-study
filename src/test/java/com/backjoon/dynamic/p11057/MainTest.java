package com.backjoon.dynamic.p11057;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * 백준 11057번 문제
 *
 * @author 송훤출
 * @since 20.02.27
 */
public class MainTest {

    @Test
    public void 예제1() {
        Assert.assertThat(10L, is(Main.solve(1)));
    }

    @Test
    public void 예제2() {
        Assert.assertThat(55L, is(Main.solve(2)));
    }

    @Test
    public void 예제3() {
        Assert.assertThat(220L, is(Main.solve(3)));
    }
}
