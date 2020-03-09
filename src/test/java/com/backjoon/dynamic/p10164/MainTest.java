package com.backjoon.dynamic.p10164;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.09
 */
public class MainTest {

    @Test
    public void 예제1() {
        Assert.assertThat(9, CoreMatchers.is(Main.solve(3, 5, 8)));
    }

    @Test
    public void 예제2() {
        Assert.assertThat(15, CoreMatchers.is(Main.solve(3, 5, 0)));
    }

    @Test
    public void 예제3() {
        Assert.assertThat(1, CoreMatchers.is(Main.solve(2, 1, 0)));
    }

    @Test
    public void 예제4() {
        Assert.assertThat(5, CoreMatchers.is(Main.solve(3, 5, 10)));
    }

}
