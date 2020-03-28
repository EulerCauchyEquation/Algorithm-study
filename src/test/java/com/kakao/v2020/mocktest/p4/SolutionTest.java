package com.kakao.v2020.mocktest.p4;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.28
 */
public class SolutionTest {

    @Test
    public void 예제1() {
        long[] room_number = {1, 3, 4, 1, 3, 1};
        long k = 10;

        Assert.assertThat(new long[]{1L, 3L, 4L, 2L, 5L, 6L}, CoreMatchers.is(Solution.solution(k, room_number)));
    }
}
