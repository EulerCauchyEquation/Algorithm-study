package com.backjoon.bitmask.p1562;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 1562 : 계단 수
 *
 * @author 송훤출
 * @since 20.04.10
 */
public class Main {
    static final int FACTOR = 1000000000;
    static int[][][] memo;
    static int check = (1 << 10) - 1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        System.out.println(solve(n));

        in.close();
    }

    public static int solve(int n) {
        memo = new int[n][10][1024];
        for (int[][] m : memo) {
            for (int[] mm : m) {
                Arrays.fill(mm, -1);
            }
        }
        int result = 0;

        for (int i = 1; i < 10; i++) {
            result += dfs(n - 1, i, (1 << i));
            result %= FACTOR;
        }

        return result;
    }

    private static int dfs(int n, int here, int state) {
        if (n == 0) {
            return (state == check) ? 1 : 0;
        }

        if (memo[n][here][state] != -1) {
            return memo[n][here][state];
        }

        int[] cases = new int[2];
        int next = here - 1;

        if (next >= 0) {
            cases[0] = dfs(n - 1, next, state | (1 << next));
        }

        next = here + 1;

        if (next < 10) {
            cases[1] = dfs(n - 1, next, state | (1 << next));
        }

        memo[n][here][state] = (cases[0] + cases[1]) % FACTOR;
        return memo[n][here][state];
    }
}
