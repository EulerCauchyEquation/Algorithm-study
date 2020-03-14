package com.backjoon.backtrack.p1987;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.11
 */
public class MainTest {

    @Test
    public void 예제1() {
        char[][] board = {
                {'C', 'A', 'A', 'B'},
                {'A', 'D', 'C', 'B'}};
        Assert.assertThat(3, CoreMatchers.is(Main.solve(board)));
    }

    @Test
    public void 예제2() {
        char[][] board = {
                {'C'}};
        Assert.assertThat(1, CoreMatchers.is(Main.solve(board)));
    }

    @Test
    public void 예제3() {
        char[][] board = {
                {'C', 'C', 'C', 'C'},
                {'C', 'C', 'A', 'A'}};
        Assert.assertThat(1, CoreMatchers.is(Main.solve(board)));
    }
}
