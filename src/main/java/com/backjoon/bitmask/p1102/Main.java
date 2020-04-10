package com.backjoon.bitmask.p1102;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 백준 1102 : 발전소
 *
 * @author 송훤출
 * @since 20.04.10
 */
public class Main {
    static int[][] mCosts;
    static int[] memo;
    static int P;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[][] costs = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            StringTokenizer stk = new StringTokenizer(line);

            for (int j = 0; j < n; j++) {
                costs[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        String state = in.nextLine();
        int p = Integer.parseInt(in.nextLine());

        System.out.println(solve(costs, state, p));
    }

    public static int solve(int[][] costs, String state, int p) {
        mCosts = costs.clone();
        memo = new int[(1 << (costs.length + 1)) - 1];
        Arrays.fill(memo, -1);
        int init = 0;
        int cnt = 0;
        P = p;

        for (int i = 0; i < state.length(); i++) {
            if (state.charAt(i) == 'Y') {
                init = init | (1 << i);
                cnt++;
            }
        }

        int result = dfs(init, cnt);
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }

    private static int dfs(int state, int cnt) {
        if (cnt >= P) {
            return 0;
        }

        if (memo[state] != -1) {
            return memo[state];
        }

        memo[state] = Integer.MAX_VALUE;

        for (int i = 0; i < mCosts.length; i++) {
            int from = 1 << i;

            if ((state & from) == from) {
                // 고장나지 않은 기계들 중
                for (int j = 0; j < mCosts.length; j++) {
                    int to = 1 << j;

                    if ((~state & to) == to) {
                        // 고장난 기계들을 대상으로
                        memo[state] = Math.min(memo[state],
                                dfs(state | to, cnt + 1) + mCosts[i][j]);
                    }
                }
            }
        }

        return memo[state];
    }

}
