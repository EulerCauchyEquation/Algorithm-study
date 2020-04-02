package com.backjoon.dfs.p1697;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.04.02
 */
public class MainTest {

    @Test
    public void 예제1() {
        int n = 5;
        int k = 17;

        Assert.assertThat(4, CoreMatchers.is(Main.solve(n, k)));
    }
}
