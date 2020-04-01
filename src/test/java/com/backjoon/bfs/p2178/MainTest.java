package com.backjoon.bfs.p2178;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.04.01
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[][] maze = {
                {1, 0, 1, 1, 1, 1},
                {1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1}};

        Assert.assertThat(15, CoreMatchers.is(Main.solve(maze)));
    }

    @Test
    public void 예제2() {
        int[][] maze = {
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1}};

        Assert.assertThat(9, CoreMatchers.is(Main.solve(maze)));
    }

    @Test
    public void 예제3() {
        int[][] maze = {
                {1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1}};

        Assert.assertThat(38, CoreMatchers.is(Main.solve(maze)));
    }

    @Test
    public void 예제4() {
        int[][] maze = {
                {1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}};

        Assert.assertThat(13, CoreMatchers.is(Main.solve(maze)));
    }
}
