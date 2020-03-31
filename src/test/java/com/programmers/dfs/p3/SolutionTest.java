package com.programmers.dfs.p3;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.31
 */
public class SolutionTest {

    @Test
    public void 예제1() {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        Assert.assertThat(4, CoreMatchers.is(Solution.solution(begin, target, words)));
    }

    @Test
    public void 예제2() {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};

        Assert.assertThat(0, CoreMatchers.is(Solution.solution(begin, target, words)));
    }
}
