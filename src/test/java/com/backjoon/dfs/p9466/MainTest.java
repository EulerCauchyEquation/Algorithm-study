package com.backjoon.dfs.p9466;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.31
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[] wanted = {0, 3, 1, 3, 7, 3, 4, 6};

        Assert.assertThat(3, CoreMatchers.is(Main.solve(wanted)));
    }

    @Test
    public void 예제2() {
        int[] wanted = {0, 1, 2, 3, 4, 5, 6, 7, 8};

        Assert.assertThat(0, CoreMatchers.is(Main.solve(wanted)));
    }

    @Test
    public void 예제3() {
        int[] wanted = {0, 2, 3, 1, 5, 5};

        Assert.assertThat(1, CoreMatchers.is(Main.solve(wanted)));
    }
}
