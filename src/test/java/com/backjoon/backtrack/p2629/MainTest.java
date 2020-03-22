package com.backjoon.backtrack.p2629;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.21
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[] weights = {1, 4};
        int[] marbles = {3, 2};
        Assert.assertThat(new boolean[]{true, false}, CoreMatchers.is(Main.solve(weights, marbles)));
    }

    @Test
    public void 예제2() {
        int[] weights = {1, 1, 6};
        int[] marbles = {3, 4};
        Assert.assertThat(new boolean[]{false, true}, CoreMatchers.is(Main.solve(weights, marbles)));
    }
}
