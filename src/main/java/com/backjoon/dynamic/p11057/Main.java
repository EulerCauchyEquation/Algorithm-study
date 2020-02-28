package com.backjoon.dynamic.p11057;

import java.util.Scanner;

/**
 * 백준 11057번 문제
 *
 * @author 송훤출
 * @since 20.02.27
 */
public class Main {
    static final long CORRECTION = 10007;
    static long[][] memo;

    public static void main(String[] args) {
        int n = ScannerService();
        System.out.println(solve(n));
    }

    public static int ScannerService() {
        Scanner in = new Scanner(System.in);
        int input = Integer.parseInt(in.nextLine());
        in.close();
        return input;
    }

    public static long solve(int n) {
        memo = new long[n + 1][10];
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += util(n, i);
        }
        return sum % CORRECTION;
    }

    private static long util(int n, int x) {
        if (n == 1) {
            memo[n][x] = 1;
        }
        if (memo[n][x] > 0) {
            return memo[n][x];
        }
        for (int i = 0; i <= x; i++) {
            memo[n][x] += util(n - 1, i) % CORRECTION;
        }
        return memo[n][x] % CORRECTION;
    }
}
