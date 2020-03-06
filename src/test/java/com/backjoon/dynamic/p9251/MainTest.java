package com.backjoon.dynamic.p9251;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.05
 */
public class MainTest {

    @Test
    public void 예제1() {
        String firstString = "ACAYKP";
        String secondString = "CAPCAK";
        Assert.assertThat(4, CoreMatchers.is(Main.solve(firstString, secondString)));
    }

    @Test
    public void 두_빈_문자열() {
        String firstString = "";
        String secondString = "";
        Assert.assertThat(0, CoreMatchers.is(Main.solve(firstString, secondString)));
    }

    @Test
    public void 한_빈_문자열() {
        String firstString = "A";
        String secondString = "";
        Assert.assertThat(0, CoreMatchers.is(Main.solve(firstString, secondString)));
    }

    @Test
    public void 예제2() {
        String firstString = "ABCDE";
        String secondString = "BCDEA";
        Assert.assertThat(4, CoreMatchers.is(Main.solve(firstString, secondString)));
    }

    @Test
    public void 예제3() {
        String firstString = "ABCDE";
        String secondString = "EFGHI";
        Assert.assertThat(1, CoreMatchers.is(Main.solve(firstString, secondString)));
    }
}
