package com.kakao.v2020.mocktest.p4;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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

    @Test
    public void ㄴㅇ() {
        Set<Long> set = new HashSet<>();

        long a = 1L;
        set.add(a);
        set.add(3L);
        for (long i = a; i < 20; i++) {
            if (!set.contains(i)) {
                set.add(i);
                break;
            }
        }

        boolean result = set.contains(2L);
        Assert.assertThat(true, CoreMatchers.is(result));


    }
}
