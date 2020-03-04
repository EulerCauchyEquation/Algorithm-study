package com.backjoon.dynamic.p1890;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.04
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[][] values = {
                {2, 3, 3, 1},
                {1, 2, 1, 3},
                {1, 2, 3, 1},
                {3, 1, 1, 0}};
        Assert.assertThat(3L, CoreMatchers.is(Main.solve(values)));
    }

    @Test
    public void 영이_존재하는_보드() {
        int[][] values = {
                {2, 3, 3, 1},
                {1, 2, 1, 3},
                {0, 2, 3, 1},
                {3, 1, 1, 0}};
        Assert.assertThat(1L, CoreMatchers.is(Main.solve(values)));
    }
}
