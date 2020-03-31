package com.programmers.dfs.p1;

/**
 * 프로그래머스 : 타겟 넘버 (DFS/BFS)
 *
 * @author 송훤출
 * @since 20.03.31
 */
public class Solution {
    static int[] mNumbers;
    static int mTarget;
    static int result;

    public static int solution(int[] numbers, int target) {
        mNumbers = numbers.clone();
        mTarget = target;
        result = 0;

        dfs(0, 0);

        return result;
    }

    private static void dfs(int n, int sum) {
        if (n == mNumbers.length) {
            result = (sum == mTarget) ? result += 1 : result;
            return;
        }

        dfs(n + 1, sum + (-1) * mNumbers[n]);
        dfs(n + 1, sum + mNumbers[n]);
    }
}
