package com.backjoon.dynamic.p2011;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.07
 */
public class MainTest {

    @Test
    public void 예제1() {
        String value = "25114";
        Assert.assertThat(6, CoreMatchers.is(Main.solve(value)));
    }

    @Test
    public void 예제2() {
        String value = "1020";
        Assert.assertThat(1, CoreMatchers.is(Main.solve(value)));
    }

    @Test
    public void 예제3() {
        String value = "3333";
        Assert.assertThat(1, CoreMatchers.is(Main.solve(value)));
    }

    @Test
    public void 예제4() {
        String value = "010";
        Assert.assertThat(0, CoreMatchers.is(Main.solve(value)));
    }

    @Test
    public void 예제5() {
        String value = "0";
        Assert.assertThat(0, CoreMatchers.is(Main.solve(value)));
    }

    @Test
    public void 예제6() {
        String value = "2727";
        Assert.assertThat(1, CoreMatchers.is(Main.solve(value)));
    }
}
