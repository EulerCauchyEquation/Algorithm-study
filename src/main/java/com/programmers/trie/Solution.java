package com.programmers.trie;

import java.util.Arrays;

/**
 * 프로그래머스 : 전화번호 목록
 *
 * @author 송훤출
 * @since 20.04.15
 */
public class Solution {

    public static boolean solution(String[] phone_book) {
        return Arrays.stream(phone_book)
                .allMatch(phone -> Arrays.stream(phone_book)
                        .filter(other -> !other.equals(phone))
                        .allMatch(other_phone -> !other_phone.startsWith(phone))
                );
    }
}
