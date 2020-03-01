package com.backjoon.dynamic.p2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 2156번 : 포도주 시식
 *
 * @author 송훤출
 * @since 20.03.01
 */
public class Main {
    static int[] memo;

    public static void main(String[] args) {
        int[] values = createValues();
        System.out.println(solve(values));
    }

    public static int[] createValues() {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        int[] values;
        try {
            int n = Integer.parseInt(in.readLine());
            values = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                values[i] = Integer.parseInt(in.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return values;
    }

    public static int solve(int[] values) {
        int n = values.length - 1;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return util(n, values);
    }

    public static int util(int n, int[] values) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            memo[1] = values[1];
        }
        if (n == 2) {
            memo[2] = values[2] + values[1];
        }
        if (memo[n] >= 0) {
            return memo[n];
        }
        memo[n] = max(
                util(n - 3, values) + values[n] + values[n - 1],
                util(n - 2, values) + values[n],
                util(n - 1, values));
        return memo[n];
    }

    private static int max(int value1, int value2, int value3) {
        if (value1 > value2) {
            return Math.max(value1, value3);
        } else {
            return Math.max(value2, value3);
        }
    }
}
