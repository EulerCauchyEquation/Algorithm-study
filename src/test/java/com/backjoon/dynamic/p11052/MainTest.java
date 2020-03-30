package com.backjoon.dynamic.p11052;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.30
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[] cardPack = {1, 5, 6, 7};
        Assert.assertThat(10, CoreMatchers.is(Main.solve(cardPack)));
    }

    @Test
    public void 예제2() {
        int[] cardPack = {10, 9, 8, 7, 6};
        Assert.assertThat(50, CoreMatchers.is(Main.solve(cardPack)));
    }

    @Test
    public void 예제3() {
        int[] cardPack = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
        Assert.assertThat(55, CoreMatchers.is(Main.solve(cardPack)));
    }

    @Test
    public void 예제4() {
        int[] cardPack = {5, 10, 11, 12, 13, 30, 35, 40, 45, 47};
        Assert.assertThat(50, CoreMatchers.is(Main.solve(cardPack)));
    }

    @Test
    public void 예제5() {
        int[] cardPack = {5, 2, 8, 10};
        Assert.assertThat(20, CoreMatchers.is(Main.solve(cardPack)));
    }

    @Test
    public void 예제6() {
        int[] cardPack = {3, 5, 15, 16};
        Assert.assertThat(18, CoreMatchers.is(Main.solve(cardPack)));
    }
}
