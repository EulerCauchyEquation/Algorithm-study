package com.backjoon.dynamic.p1149;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author 송훤출
 * @since 20.02.29
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[][] value = {
                {26, 40, 83},
                {49, 60, 57},
                {13, 89, 99}};
        Assert.assertThat(96, is(Main.solve(value)));
    }

    @Test
    public void 색상비용값이_동일한_선택지가_있는_경우() {
        int[][] value = {
                {5, 1, 5},
                {5, 1, 1},
                {1, 5, 1}};
        Assert.assertThat(3, is(Main.solve(value)));
    }

    @Test
    public void 까다로운_경우() {
        int[][] value = {
                {1, 100, 200},
                {1, 201, 101},
                {202, 102, 1}};
        Assert.assertThat(102, is(Main.solve(value)));
    }
}
