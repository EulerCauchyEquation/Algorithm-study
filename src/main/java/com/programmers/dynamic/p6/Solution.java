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
        for (int[] m : memo) {
            Arrays.fill(m, NOT_VISITED);
        }

        int answer = 0;
        for (Act act : Act.values()) {
            int next = act.next;
            int money = act.isStealAction() ? houses[0] : 0;
            hasSelectedFirstElement = act.isStealAction();

            System.out.println();
            answer = Math.max(
                    dfs(next, act, houses) + money,
                    answer);
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
        /*if (memo[n][act.ordinal()] != NOT_VISITED) {
            return memo[n][act.ordinal()];
        }*/

        int stolenMoney = 0;
        for (Act nextAct : Act.values()) {
            int next = n + nextAct.next;
            int money = nextAct.isStealAction() ? houses[n] : 0;

            stolenMoney = Math.max(
                    dfs(next, nextAct, houses) + money,
                    stolenMoney);
        }
        memo[n][act.ordinal()] = stolenMoney;

        System.out.println(n + "\t" + stolenMoney + "\t" + act);
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
