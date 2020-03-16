package com.backjoon.backtrack.p1339;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.16
 */
public class MainTest {

    @Test
    public void 예제1() {
        String[] words = {
                "GCF",
                "ACDEB"};
        Assert.assertThat(99437L, CoreMatchers.is(Main.solve(words)));
    }

    @Test
    public void 예제2() {
        String[] words = {
                "AAA",
                "AAA"};
        Assert.assertThat(1998L, CoreMatchers.is(Main.solve(words)));
    }
}
