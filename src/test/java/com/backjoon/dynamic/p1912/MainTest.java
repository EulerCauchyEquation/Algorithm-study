package com.backjoon.dynamic.p1912;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * 백준 1912
 *
 * @author 송훤출
 * @since 20.02.27
 */
public class MainTest {

    @Test
    public void 예제1() {
        long[] values = {10, -4, 3, 1, 5, 6, -35, 12, 21, -1};
        Assert.assertThat(33L, is(Main.solve(values)));
    }

    @Test
    public void 모든_음수_중_양끝만_큰양수() {
        long[] values = {100, -1, -1, -1, -1, -1, -1, -1, -1, 100};
        Assert.assertThat(192L, is(Main.solve(values)));
    }

    @Test
    public void 모든_양수() {
        long[] values = {100, 10, 20, 30, 100};
        Assert.assertThat(260L, is(Main.solve(values)));
    }

    @Test
    public void 모든_음수() {
        long[] values = {-10, -20, -30, -40};
        Assert.assertThat(-10L, is(Main.solve(values)));
    }
}
