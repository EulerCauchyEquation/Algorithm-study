package com.backjoon.stack.p2493;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author 송훤출
 * @since 20.04.12
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[] tops = {6, 9, 5, 7, 4};
        int[] result = {0, 0, 2, 2, 4};

        Assert.assertThat(Main.solve(tops), is(result));
    }

    @Test
    public void 예제2() {
        int[] tops = {6, 4, 5, 2, 5, 1};
        int[] result = {0, 1, 1, 3, 3, 5};

        Assert.assertThat(Main.solve(tops), is(result));
    }

    @Test
    public void 예제3() {
        int[] tops = {1, 2, 3};
        int[] result = {0, 0, 0};

        Assert.assertThat(Main.solve(tops), is(result));
    }

    @Test
    public void 예제4() {
        int[] tops = {3, 2, 1};
        int[] result = {0, 1, 2};

        Assert.assertThat(Main.solve(tops), is(result));
    }
}
