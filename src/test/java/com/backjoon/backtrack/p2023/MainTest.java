package com.backjoon.backtrack.p2023;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author 송훤출
 * @since 20.03.20
 */
public class MainTest {

    @Test
    public void 예제1() {
        Integer[] primeNumber = {
                2333,
                2339,
                2393,
                2399,
                2939,
                3119,
                3137,
                3733,
                3739,
                3793,
                3797,
                5939,
                7193,
                7331,
                7333,
                7393};
        List<Integer> result = Arrays.asList(primeNumber);
        Assert.assertThat(result, CoreMatchers.is(Main.solve(4)));
    }

    @Test
    public void 예제2() {
        Integer[] primeNumber = {
                2,
                3,
                5,
                7};
        List<Integer> result = Arrays.asList(primeNumber);
        Assert.assertThat(result, CoreMatchers.is(Main.solve(1)));
    }
}
