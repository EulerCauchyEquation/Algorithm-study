package com.backjoon.trie.p5670;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author 송훤출
 * @since 20.04.15
 */
public class MainTest {

    @Test
    public void 예제1() {
        String[] words = {
                "hello",
                "hell",
                "heaven",
                "goodbye"
        };

        Assert.assertThat(Main.solve(words), is("2.00"));
    }

    @Test
    public void 예제2() {
        String[] words = {
                "hi",
                "he",
                "h"
        };

        Assert.assertThat(Main.solve(words), is("1.67"));
    }

    @Test
    public void 예제3() {
        String[] words = {
                "structure",
                "structures",
                "ride",
                "riders",
                "stress",
                "solstice",
                "ridiculous"
        };

        Assert.assertThat(Main.solve(words), is("2.71"));
    }
}
