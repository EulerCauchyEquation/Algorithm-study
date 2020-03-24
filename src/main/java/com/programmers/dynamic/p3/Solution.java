package com.programmers.dynamic.p3;

import java.util.Arrays;

/**
 * 프로그래머스 : 정수 삼각형 ( 동적 계획법 )
 *
 * @author 송훤출
 * @since 20.03.24
 */
public class Solution {
    static final int NOT_VISITED = -1;

    static int[][] memo;

    public static int solution(int[][] triangle) {
        memo = new int[triangle.length][triangle.length];
        for (int[] m : memo) {
            Arrays.fill(m, NOT_VISITED);
        }
        return dfs(0, 0, triangle);
    }

    private static int dfs(int m, int n, int[][] triangle) {
        if (m == triangle.length) {
            return 0;
        }
        if (memo[m][n] != NOT_VISITED) {
            return memo[m][n];
        }

        memo[m][n] = Math.max(
                dfs(m + 1, n, triangle),
                dfs(m + 1, n + 1, triangle)) + triangle[m][n];
        return memo[m][n];
    }
}
