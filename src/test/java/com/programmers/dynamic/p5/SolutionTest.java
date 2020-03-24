package com.programmers.dynamic.p5;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.24
 */
public class SolutionTest {

    @Test
    public void 예제1() {
        int[] left = {3, 2, 5};
        int[] right = {2, 4, 1};
        Assert.assertThat(7, CoreMatchers.is(Solution.solution(left, right)));
    }

    @Test
    public void 예제2() {
        int[] left = {1, 1, 1};
        int[] right = {1, 1, 1};
        Assert.assertThat(0, CoreMatchers.is(Solution.solution(left, right)));
    }

    @Test
    public void 예제3() {
        int[] left = {1, 1, 3};
        int[] right = {2, 3, 1, 1, 1};
        Assert.assertThat(3, CoreMatchers.is(Solution.solution(left, right)));
    }
}
