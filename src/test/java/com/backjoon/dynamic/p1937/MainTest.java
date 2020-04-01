package com.backjoon.dynamic.p1937;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.04.01
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[][] forest = {
                {14, 9, 12, 10},
                {1, 11, 5, 4},
                {7, 15, 2, 13},
                {6, 3, 16, 8}};

        Assert.assertThat(4, CoreMatchers.is(Main.solve(forest)));

    }
}
