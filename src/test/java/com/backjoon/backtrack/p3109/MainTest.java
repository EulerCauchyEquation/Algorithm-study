package com.backjoon.backtrack.p3109;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.17
 */
public class MainTest {

    @Test
    public void 예제1() {
        char[][] map = {
                {'.', 'x', 'x', '.', '.'},
                {'.', '.', 'x', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', 'x', '.'},
                {'.', '.', '.', 'x', '.'}};
        Assert.assertThat(2, CoreMatchers.is(Main.solve(map)));
    }

    @Test
    public void 예제2() {
        char[][] map = {
                {'.'},
                {'.'},
                {'.'},
                {'.'},
                {'.'}};
        Assert.assertThat(5, CoreMatchers.is(Main.solve(map)));
    }

    @Test
    public void 예제3() {
        char[][] map = {
                {'.', '.', '.', 'x', '.'},
                {'.', '.', '.', 'x', '.'},
                {'.', '.', '.', 'x', '.'},
                {'.', '.', '.', 'x', '.'},
                {'.', '.', '.', 'x', '.'}};
        Assert.assertThat(0, CoreMatchers.is(Main.solve(map)));
    }
}
