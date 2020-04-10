package com.backjoon.bitmask.p11723;

import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.04.10
 */
public class MainTest {

    @Test
    public void 예제1() {
        String[] command = {
                "add 1",
                "add 2",
                "check 1",
                "check 2",
                "check 3",
                "remove 2",
                "check 1",
                "check 2",
                "toggle 3",
                "check 1",
                "check 2",
                "check 3",
                "check 4",
                "all",
                "check 10",
                "check 20",
                "toggle 10",
                "remove 20",
                "check 10",
                "check 20",
                "empty",
                "check 1",
                "toggle 1",
                "check 1",
                "toggle 1",
                "check 1"
        };

        int[] result = {
                1,
                1,
                0,
                1,
                0,
                1,
                0,
                1,
                0,
                1,
                1,
                0,
                0,
                0,
                1,
                0
        };
    }
}
