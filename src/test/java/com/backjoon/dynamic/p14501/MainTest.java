package com.backjoon.dynamic.p14501;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.02
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[][] values = {
                {3, 10},
                {5, 20},
                {1, 10},
                {1, 20},
                {2, 15},
                {4, 40},
                {2, 200}};
        Assert.assertThat(45, CoreMatchers.is(Main.solve(values)));
    }

    @Test
    public void 예제2() {
        int[][] values = {
                {1, 1},
                {1, 2},
                {1, 3},
                {1, 4},
                {1, 5},
                {1, 6},
                {1, 7},
                {1, 8},
                {1, 9},
                {1, 10}};
        Assert.assertThat(55, CoreMatchers.is(Main.solve(values)));
    }

    @Test
    public void 예제() {
        int[][] values = {
                {5, 10},
                {5, 9},
                {5, 8},
                {5, 7},
                {5, 6},
                {5, 10},
                {5, 9},
                {5, 8},
                {5, 7},
                {5, 6}};
        Assert.assertThat(20, CoreMatchers.is(Main.solve(values)));
    }

    @Test
    public void 예제4() {
        int[][] values = {
                {5, 50},
                {4, 40},
                {3, 30},
                {2, 20},
                {1, 10},
                {1, 10},
                {2, 20},
                {3, 30},
                {4, 40},
                {5, 50}};
        Assert.assertThat(90, CoreMatchers.is(Main.solve(values)));
    }

    @Test
    public void 상담수_1개일_때() {
        int[][] values = {
                {5, 50}};
        Assert.assertThat(0, CoreMatchers.is(Main.solve(values)));
    }

    @Test
    public void 상담수_1개일_때2() {
        int[][] values = {
                {1, 50}};
        Assert.assertThat(50, CoreMatchers.is(Main.solve(values)));
    }
}
