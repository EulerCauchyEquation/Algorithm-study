package com.programmers.dynamic.p6;

import java.util.Arrays;

/**
 * 프로그래머스 : 도둑질 (동적 계획법)
 *
 * @author 송훤출
 * @since 20.03.24
 */
public class Solution {
    static final int NOT_VISITED = -1;

    static int[][] memo;
    static boolean hasSelectedFirstElement;

    public static int solution(int[] houses) {
        memo = new int[houses.length][Act.values().length];

        int answer = 0;
        for (Act act : Act.values()) {
            for (int[] m : memo) {
                Arrays.fill(m, NOT_VISITED);
            }
            hasSelectedFirstElement = act.isStealAction();

            answer = Math.max(dfs(0, act, houses), answer);
        }

        return answer;
    }

    private static int dfs(int n, Act act, int[] houses) {
        if ((n == houses.length - 1) && hasSelectedFirstElement) {
            return 0;
        }
        if (n >= houses.length) {
            return 0;
        }
        if (memo[n][act.ordinal()] != NOT_VISITED) {
            return memo[n][act.ordinal()];
        }

        int money = act.isStealAction() ? houses[n] : 0;
        memo[n][act.ordinal()] = Math.max(
                dfs(n + act.next, Act.PASS, houses),
                dfs(n + act.next, Act.STEAL, houses)) + money;

        return memo[n][act.ordinal()];
    }

    enum Act {
        PASS(1),
        STEAL(2);

        int next;

        Act(int next) {
            this.next = next;
        }

        private boolean isStealAction() {
            return this.next == STEAL.next;
        }
    }
}
