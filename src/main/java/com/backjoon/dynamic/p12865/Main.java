package com.backjoon.dynamic.p12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 : 12865번 평범한 배낭
 *
 * @author 송훤출
 * @since 20.03.27
 */
public class Main {
    static final int NOT_VISITED = -1;
    static int[][] productsInfo;
    static int[][] memo;

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int k;
        int[][] products;
        try {
            String line = in.readLine();
            StringTokenizer stk = new StringTokenizer(line);

            int n = Integer.parseInt(stk.nextToken());
            k = Integer.parseInt(stk.nextToken());
            products = new int[n][2];
            for (int i = 0; i < n; i++) {
                line = in.readLine();
                stk = new StringTokenizer(line);
                products[i][0] = Integer.parseInt(stk.nextToken());
                products[i][1] = Integer.parseInt(stk.nextToken());
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }

        System.out.println(solve(k, products));
    }

    public static int solve(int k, int[][] products) {
        productsInfo = products;
        memo = new int[productsInfo.length][k + 1];
        for (int[] m : memo) {
            Arrays.fill(m, NOT_VISITED);
        }

        return dfs(0, k);
    }

    private static int dfs(int n, int weightAllowance) {
        if (n == productsInfo.length) {
            return 0;
        }

        if (memo[n][weightAllowance] != NOT_VISITED) {
            return memo[n][weightAllowance];
        }

        int weight = productsInfo[n][0];
        int value = productsInfo[n][1];
        int select = (weight <= weightAllowance)
                ? value + dfs(n + 1, weightAllowance - weight)
                : 0;
        int notSelect = dfs(n + 1, weightAllowance);
        memo[n][weightAllowance] = Math.max(select, notSelect);
        return memo[n][weightAllowance];
    }
}
