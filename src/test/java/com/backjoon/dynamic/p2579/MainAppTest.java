package com.backjoon.dynamic.p2579;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author 송훤출
 * @since 20.02.25
 */
public class MainAppTest {

    @Test
    public void 예제_입력() {
        int[] values = {0, 10, 20, 15, 25, 10, 20};
        Assert.assertThat(75, is(MainApp.solve(values)));
    }

    @Test
    public void 계단_1개() {
        int[] values = {0, 6};
        Assert.assertThat(6, is(MainApp.solve(values)));
    }

    @Test
    public void 계단_2개() {
        int[] values = {0, 6, 20};
        Assert.assertThat(26, is(MainApp.solve(values)));
    }

    @Test
    public void 계단_3개() {
        int[] values = {0, 6, 20, 30};
        Assert.assertThat(50, is(MainApp.solve(values)));
    }

    @Test
    public void 계단형태_한_종류() {
        int[] values = {0, 10, 10, 10, 10, 10, 10};
        Assert.assertThat(40, is(MainApp.solve(values)));
    }

    @Test
    public void 계단형태_두_종류() {
        int[] values = {0, 10, 10, 10, 10, 50, 50, 50, 50};
        Assert.assertThat(180, is(MainApp.solve(values)));
    }

    @Test
    public void 동일크기_계단_간헐적() {
        int[] values = {0, 10, 50, 50, 10, 25, 50, 5, 15, 15, 25};
        Assert.assertThat(215, is(MainApp.solve(values)));
    }

    @Test
    public void 오르막_계단() {
        int[] values = {0, 10, 20, 30, 40, 50, 60, 70};
        Assert.assertThat(210, is(MainApp.solve(values)));
    }

    @Test
    public void 내리막_계단() {
        int[] values = {0, 70, 60, 50, 40, 30, 20, 10};
        Assert.assertThat(210, is(MainApp.solve(values)));
    }
}
