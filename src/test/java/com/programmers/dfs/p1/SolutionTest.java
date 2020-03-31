package com.programmers.dfs.p1;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.31
 */
public class SolutionTest {

    @Test
    public void 에제1() {
        int[] number = {1, 1, 1, 1, 1};
        int target = 3;

        Assert.assertThat(5, CoreMatchers.is(Solution.solution(number, target)));
    }
}
