package com.backjoon.dynamic.p2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 2579번
 *
 * @author 송훤출
 * @since 20.02.25
 */
public class MainApp {
    static int[] memo;

    public static void main(String[] args) {
        int[] values = inputService();
        System.out.println(solve(values));
    }

    private static int[] inputService() {
        int[] values = null;
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in))) {

            int numberOfStairs = toInt(in.readLine());
            values = new int[numberOfStairs + 1];
            for (int i = 1; i <= numberOfStairs; i++) {
                String input = in.readLine();
                values[i] = toInt(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return values;
    }

    private static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static int solve(int[] values) {
        int n = values.length;
        memo = new int[n];
        return util(n - 1, values);
    }

    private static int util(int n, int[] values) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            memo[n] = values[1];
        } else if (n == 2) {
            memo[n] = values[1] + values[2];
        } else {
            if (memo[n] > 0) {
                return memo[n];
            }
            memo[n] = Math.max(
                    util(n - 3, values) + values[n] + values[n - 1],
                    util(n - 2, values) + values[n]);
        }
        return memo[n];
    }
}
