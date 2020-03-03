package com.backjoon.dynamic.p9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 9461번 : 파도반 수열
 *
 * @author 송훤출
 * @since 20.03.03
 */
public class Main {
    static long[] memo = new long[101];

    public static void main(String[] args) {
        int[] testcases = createTestcases();
        solve(testcases);
    }

    private static int[] createTestcases() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] values;
        try {
            int n = Integer.parseInt(in.readLine());
            values = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = Integer.parseInt(in.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return values;
    }

    public static long[] solve(int[] values) {
        long[] result = new long[values.length];
        for (int testcase = 0; testcase < result.length; testcase++) {
            result[testcase] = util(values[testcase]);
            System.out.println(result[testcase]);
        }
        return result;
    }

    private static long util(int n) {
        if (n <= 3) {
            memo[n] = 1;
        }
        if (n == 4 || n == 5) {
            memo[n] = 2;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = util(n - 1) + util(n - 5);
        return memo[n];
    }
}
