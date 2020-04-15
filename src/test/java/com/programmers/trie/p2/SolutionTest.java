package com.programmers.trie.p2;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * 프로그래머스 : 전화번호 목록
 *
 * @author 송훤출
 * @since 20.04.15
 */
public class SolutionTest {

    @Test
    public void 예제1() {
        String[] phone_book = {"119", "97674223", "1195524421"};

        Assert.assertThat(Solution.solution(phone_book), is(false));
    }

    @Test
    public void 예제2() {
        String[] phone_book = {"123", "456", "789"};

        Assert.assertThat(Solution.solution(phone_book), is(true));
    }

    @Test
    public void 예제3() {
        String[] phone_book = {"12", "123", "1235", "567", "88"};

        Assert.assertThat(Solution.solution(phone_book), is(false));
    }
}
