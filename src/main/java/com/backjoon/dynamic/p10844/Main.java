package com.backjoon.dynamic.p10844;

import java.util.Scanner;

/**
 * 백준 10844 : 쉬운 계단 수
 *
 * @author 송훤출
 * @since 20.03.23
 */
public class Main {
    static final long FACTOR_CORRECTION = 1_000_000_000L;
    static long[][] memo;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        System.out.println(solve(n));
        in.close();
    }

    public static long solve(int n) {
        memo = new long[n][10];

        long answer = 0;
        for (int root = 1; root <= 9; root++) {
            answer += dfs(n - 1, root);
        }
        return answer % FACTOR_CORRECTION;
    }

    private static long dfs(int n, int node) {
        if (n == 0) {
            return 1;
        }
        if (memo[n][node] > 0) {
            return memo[n][node];
        }

        long[] cases = new long[2];
        cases[0] = (node != 0) ? dfs(n - 1, node - 1) : 0;
        cases[1] = (node != 9) ? dfs(n - 1, node + 1) : 0;
        memo[n][node] = (cases[0] + cases[1]) % FACTOR_CORRECTION;

        return memo[n][node];
    }
}
