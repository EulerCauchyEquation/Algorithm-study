package com.programmers.dynamic.p3;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.24
 */
public class MainTest {

    @Test
    public void 예제1() {
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}};
        Assert.assertThat(30, CoreMatchers.is(Solution.solution(triangle)));
    }
}
