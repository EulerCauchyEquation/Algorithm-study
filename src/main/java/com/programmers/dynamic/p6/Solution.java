package com.programmers.dynamic.p6;

import java.util.Arrays;

/**
 * 프로그래머스 : 도둑질 (동적 계획법)
 *
 * @author 송훤출
 * @since 20.03.24
 */
public class Solution {
    static int[] memo;

    public static int solution(int[] houses) {
        int n = houses.length;
        memo = new int[n];
        int answer = 0;

        memo[0] = houses[0];
        memo[1] = houses[0];
        for (int i = 2; i < n - 1; i++) {
            memo[i] = Math.max(
                    memo[i - 2] + houses[i],
                    memo[i - 1]);
        }
        answer = Math.max(memo[n - 2], answer);

        Arrays.fill(memo, 0);
        memo[1] = houses[1];
        for (int i = 2; i < n; i++) {
            memo[i] = Math.max(
                    memo[i - 2] + houses[i],
                    memo[i - 1]);
        }

        return Math.max(memo[n - 1], answer);
    }
}
