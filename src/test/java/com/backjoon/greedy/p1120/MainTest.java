package com.backjoon.greedy.p1120;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.20
 */
public class MainTest {

    @Test
    public void 예제1() {
        String[] stringList = {
                "adaabc",
                "aababbc"};
        Assert.assertThat(2, CoreMatchers.is(Main.solve(stringList)));
    }

    @Test
    public void 예제2() {
        String[] stringList = {
                "adaabc",
                "aababb"};
        Assert.assertThat(3, CoreMatchers.is(Main.solve(stringList)));
    }

    @Test
    public void 예제3() {
        String[] stringList = {
                "a",
                "aababb"};
        Assert.assertThat(0, CoreMatchers.is(Main.solve(stringList)));
    }

}
