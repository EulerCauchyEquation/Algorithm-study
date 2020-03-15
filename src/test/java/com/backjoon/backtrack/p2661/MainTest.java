package com.backjoon.backtrack.p2661;

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
        Assert.assertThat("1213121", CoreMatchers.is(Main.solve(7)));
    }

    @Test
    public void 예제2() {
        Assert.assertThat("1", CoreMatchers.is(Main.solve(1)));
    }

    @Test
    public void 예제3() {
        Assert.assertThat("121", CoreMatchers.is(Main.solve(3)));
    }

}
