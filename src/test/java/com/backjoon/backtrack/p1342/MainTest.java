package com.backjoon.backtrack.p1342;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.14
 */
public class MainTest {

    @Test
    public void 예제1() {
        Assert.assertThat(1, CoreMatchers.is(Main.solve("aabbbaa")));
    }

    @Test
    public void 예제0() {
        Assert.assertThat(2, CoreMatchers.is(Main.solve("aabb")));
    }

    @Test
    public void 예제2() {
        Assert.assertThat(0, CoreMatchers.is(Main.solve("")));
    }

    @Test
    public void 예제3() {
        Assert.assertThat(0, CoreMatchers.is(Main.solve("aaa")));
    }
}
