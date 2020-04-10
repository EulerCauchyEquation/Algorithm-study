package com.backjoon.bfs.p1327;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author 송훤출
 * @since 20.04.10
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[] sequence = {3, 2, 1};
        int k = 3;

        Assert.assertThat(1, is(Main.solve(sequence, k)));
    }

    @Test
    public void 예제2() {
        int[] sequence = {5, 4, 3, 2, 1};
        int k = 3;

        Assert.assertThat(4, is(Main.solve(sequence, k)));
    }
}
