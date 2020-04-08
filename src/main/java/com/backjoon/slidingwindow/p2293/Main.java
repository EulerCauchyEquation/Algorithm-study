package com.backjoon.slidingwindow.p2293;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 백준 2293 : 동전 1
 *
 * @author 송훤출
 * @since 20.04.08
 */
public class Main {
    static int[] mCoins;
    static int[][] memo;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();
        StringTokenizer stk = new StringTokenizer(line);

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(in.nextLine());
        }

        System.out.println(solve(coins, k));

    }

    public static int solve(int[] coins, int k) {
        mCoins = coins.clone();
        memo = new int[mCoins.length][k + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return dfs(0, k);
    }

    private static int dfs(int n, int k) {
        if (n == mCoins.length) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (memo[n][k] != -1) {
            return memo[n][k];
        }

        memo[n][k] = 0;
        int[] cases = new int[mCoins.length];
        for (int i = n; i < cases.length; i++) {
            if (mCoins[i] <= k) {
                memo[n][k] += dfs(i, k - mCoins[i]);
            }
        }

        return memo[n][k];
    }
}
