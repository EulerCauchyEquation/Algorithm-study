package com.backjoon.dynamic.p2156;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.01
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[] values = {0, 6, 10, 13, 9, 8, 1};
        Assert.assertThat(33, CoreMatchers.is(Main.solve(values)));
    }

    @Test
    public void 예제2() {
        int[] values = {0, 10, 10, 1, 1, 10, 10};
        Assert.assertThat(40, CoreMatchers.is(Main.solve(values)));
    }

    @Test
    public void 입력_한개() {
        int[] values = {0, 10};
        Assert.assertThat(10, CoreMatchers.is(Main.solve(values)));
    }

    @Test
    public void 입력_두개() {
        int[] values = {0, 10, 20};
        Assert.assertThat(30, CoreMatchers.is(Main.solve(values)));
    }

    @Test
    public void 입력_세개() {
        int[] values = {0, 10, 20, 50};
        Assert.assertThat(70, CoreMatchers.is(Main.solve(values)));
    }

    @Test
    public void 모든_데이터가_0인_경우() {
        int[] values = {0, 0, 0, 0, 0};
        Assert.assertThat(0, CoreMatchers.is(Main.solve(values)));
    }
}
