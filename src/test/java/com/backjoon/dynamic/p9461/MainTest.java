package com.backjoon.dynamic.p9461;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.03
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[] values = {6, 12};
        Assert.assertArrayEquals(new long[]{3L, 16L}, Main.solve(values));
    }

    @Test
    public void 테이스케이스_수_0개() {
        int[] values = {};
        Assert.assertArrayEquals(new long[]{}, Main.solve(values));
    }

    @Test
    public void 테이스케이스_수_1개() {
        int[] values = {6};
        Assert.assertArrayEquals(new long[]{3L}, Main.solve(values));
    }
}
