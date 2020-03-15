package com.backjoon.dynamic.p2193;

import java.util.Scanner;

/**
 * 백준 2193번 : 이친수
 *
 * @author 송훤출
 * @since 20.03.15
 */
public class Main {
    static long[] memo;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        System.out.println(solve(n));
        in.close();
    }

    public static long solve(int n) {
        memo = new long[n];
        return dfs(n - 1);
    }

    private static long dfs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = dfs(n - 1) + dfs(n - 2);
        return memo[n];
    }
}
