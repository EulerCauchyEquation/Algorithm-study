package com.backjoon.slidingwindow.p2003;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author 송훤출
 * @since 20.04.07
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[] sequence = {1, 1, 1, 1};
        int m = 2;

        Assert.assertThat(3, is(Main.solve(sequence, m)));
    }

    @Test
    public void 예제2() {
        int[] sequence = {1, 2, 3, 4, 2, 5, 3, 1, 1, 2};
        int m = 5;

        Assert.assertThat(3, is(Main.solve(sequence, m)));
    }

    @Test
    public void 예제3() {
        int[] sequence = {10, 1, 3};
        int m = 3;

        Assert.assertThat(1, is(Main.solve(sequence, m)));
    }
}
