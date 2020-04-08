package com.backjoon.slidingwindow.p1484;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author 송훤출
 * @since 20.04.08
 */
public class MainTest {

    @Test
    public void 예제1() {
        int g = 15;

        List<Integer> result = Arrays.asList(4, 8);
        Assert.assertThat(result, is(Main.solve(g)));
    }

    @Test
    public void 예제2() {
        int g = 10;

        List<Integer> result = Collections.singletonList(-1);
        Assert.assertThat(result, is(Main.solve(g)));
    }
}
