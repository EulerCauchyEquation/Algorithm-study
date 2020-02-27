package com.backjoon.dynamic.p1912;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1912
 *
 * @author 송훤출
 * @since 20.02.27
 */
public class Main {

    public static void main(String[] args) {
        long[] values = nextArrayLong();
        System.out.println(solve(values));
    }

    private static long[] nextArrayLong() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(System.in));
            String input = in.readLine();
            int n = Integer.parseInt(input);
            long[] values = new long[n];
            input = in.readLine();
            StringTokenizer stk = new StringTokenizer(input);
            int index = 0;
            while (stk.hasMoreTokens()) {
                values[index++] = Long.parseLong(stk.nextToken());
            }
            return values;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static long solve(long[] values) {
        int n = values.length;
        long[] dp = new long[n];

        dp[0] = values[0];
        long max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + values[i], values[i]);

            max = Math.max(dp[i], max);
        }
        return max;
    }
}
