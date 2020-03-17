package com.backjoon.dynamic.p1520;

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
        int[][] board = {
                {50, 45, 37, 32, 30},
                {35, 50, 40, 20, 25},
                {30, 30, 25, 17, 28},
                {27, 24, 22, 15, 10}};
        Assert.assertThat(3, CoreMatchers.is(Main.solve(board)));
    }

    @Test
    public void 예제3() {
        int[][] board = {
                {50, 45, 37},
                {35, 50, 10},
                {30, 10, 25}};
        Assert.assertThat(0, CoreMatchers.is(Main.solve(board)));
    }

    @Test
    public void 예제4() {
        int[][] board = {
                {16, 9, 8, 1},
                {15, 10, 7, 2},
                {14, 11, 6, 3},
                {13, 12, 5, 4}};
        Assert.assertThat(10, CoreMatchers.is(Main.solve(board)));
    }

    @Test
    public void 예제5() {
        int[][] board = {
                {16, 20},
                {15, 10}};
        Assert.assertThat(1, CoreMatchers.is(Main.solve(board)));
    }

    @Test
    public void 예제2() {
        int[][] board = {
                {50}};
        Assert.assertThat(1, CoreMatchers.is(Main.solve(board)));
    }
}
