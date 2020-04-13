package com.backjoon.stack.p9012;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author 송훤출
 * @since 20.04.13
 */
public class MainTest {

    @Test
    public void 예제1() {
        String[] testCases = {
                "(())())",
                "(((()())()",
                "(()())((()))",
                "((()()(()))(((())))()",
                "()()()()(()()())()",
                "(()((())()(",
        };

        boolean[] result = {
                false,
                false,
                true,
                false,
                true,
                false
        };

        Assert.assertThat(Main.solve(testCases), is(result));
    }

    @Test
    public void 예제2() {
        String[] testCases = {
                "((",
                "))",
                "())(()"
        };

        boolean[] result = {
                false,
                false,
                false
        };

        Assert.assertThat(Main.solve(testCases), is(result));
    }
}
