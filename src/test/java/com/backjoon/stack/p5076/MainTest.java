package com.backjoon.stack.p5076;

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
        String[] webPage = {
                "<body> <strong>Oops, this is</body> naughty </strong>",
                "<body> <strong>Hello</strong> <br /> </body>",
                "Just text, no tags.",
                "<p> Oh dear, we are missing something.",
                "<a href=http://www.nzprogcontest.org.nz>This is a link</a>" };


        String[] result = {
                "illegal",
                "legal",
                "legal",
                "illegal",
                "legal"
        };

        Assert.assertThat(Main.solve(webPage), is(result));
    }
}
