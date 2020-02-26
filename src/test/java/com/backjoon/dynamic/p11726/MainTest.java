package com.backjoon.dynamic.p11726;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author 송훤출
 * @since 20.02.26
 */
public class MainTest {

    @Test
    public void 예제입력1() {
        Assert.assertThat(2L, is(Main.solve(2)));
    }

    @Test
    public void 예제입력2() {
        Assert.assertThat(55L, is(Main.solve(9)));
    }

    @Test
    public void 큰_수() {
        Assert.assertThat(1115L, is(Main.solve(1000)));
    }
}
