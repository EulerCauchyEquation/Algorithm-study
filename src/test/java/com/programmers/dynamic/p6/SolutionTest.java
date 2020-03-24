package com.programmers.dynamic.p6;

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
        int[] money = {1, 2, 3, 1};
        Assert.assertThat(4, CoreMatchers.is(Solution.solution(money)));
    }

    @Test
    public void 예제2() {
        int[] money = {5, 1, 2, 100, 3};
        Assert.assertThat(105, CoreMatchers.is(Solution.solution(money)));
    }
}
