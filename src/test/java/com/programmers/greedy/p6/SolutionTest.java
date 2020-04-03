package com.programmers.greedy.p6;

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
        int[][] routes = {
                {-20, 15},
                {-14, -5},
                {-18, -13},
                {-5, -3}};

        Assert.assertThat(2, CoreMatchers.is(Solution.solution(routes)));
    }
}
