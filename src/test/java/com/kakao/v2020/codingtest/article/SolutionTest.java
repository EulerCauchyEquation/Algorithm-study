package com.kakao.v2020.codingtest.article;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * 2020 KAKAO 블라인드 코딩 테스트 : 기사 검색 test
 *
 * @author 송훤출
 * @since 20.05.21
 */
public class SolutionTest {

    @Test
    public void 예제1() {
        final String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        final String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        Assert.assertThat(Solution.solution(words, queries), is(new int[]{3, 2, 4, 1, 0}));
    }
}
