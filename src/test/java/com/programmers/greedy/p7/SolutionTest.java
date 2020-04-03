package com.programmers.greedy.p7;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.04.03
 */
public class SolutionTest {

    @Test
    public void 예제1() {
        int[] weights = {3, 1, 6, 2, 7, 30, 1};

        Assert.assertThat(21, CoreMatchers.is(Solution.solution(weights)));
    }
}
