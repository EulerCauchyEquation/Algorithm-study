package com.backjoon.dynamic.p12865;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.27
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[][] products = {
                {6, 13},
                {4, 8},
                {3, 6},
                {5, 12}};
        int k = 7;
        Assert.assertThat(14, CoreMatchers.is(Main.solve(k, products)));
    }
}
