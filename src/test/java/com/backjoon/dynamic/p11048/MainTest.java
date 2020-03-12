package com.backjoon.dynamic.p11048;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.12
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[][] maze = {
                {1, 2, 3, 4},
                {0, 0, 0, 5},
                {9, 8, 7, 6}};
        Assert.assertThat(31, CoreMatchers.is(Main.solve(maze)));
    }

    @Test
    public void 예제2() {
        int[][] maze = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}};
        Assert.assertThat(3, CoreMatchers.is(Main.solve(maze)));
    }

    @Test
    public void 예제3() {
        int[][] maze = {
                {1, 2, 3},
                {6, 5, 4},
                {7, 8, 9},
                {12, 11, 10}};
        Assert.assertThat(47, CoreMatchers.is(Main.solve(maze)));
    }

    @Test
    public void 예제4() {
        int[][] maze = {
                {0}};
        Assert.assertThat(0, CoreMatchers.is(Main.solve(maze)));
    }
}
