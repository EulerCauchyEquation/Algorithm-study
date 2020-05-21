package com.kakao.v2020.codingtest.article;

import java.util.stream.Stream;

/**
 * 2020 KAKAO 블라인드 코딩 테스트 : 기사 검색
 *
 * @author 송훤출
 * @since 20.05.21
 */
public class Solution {
    public static int[] solution(String[] words, String[] queries) {
        return Stream.of(queries)
                .mapToInt(query -> getMatchedCount(words, query))
                .toArray();
    }

    private static int getMatchedCount(String[] words, String query) {
        final String formatQuery = query.replace("?", ".");
        return (int) Stream.of(words)
                .filter(word -> word.matches(formatQuery))
                .count();
    }
}
