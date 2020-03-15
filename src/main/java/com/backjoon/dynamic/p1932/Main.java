package com.backjoon.dynamic.p1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1932번 : 정수 삼각형
 *
 * @author 송훤출
 * @since 20.03.15
 */
public class Main {
    static int[][] memo;

    public static void main(String[] args) {
        int[][] triangle = createTriangle();
        System.out.println(solve(triangle));
    }

    private static int[][] createTriangle() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(in.readLine());
            int[][] triangle = new int[n][];
            for (int i = 0; i < n; i++) {
                String line = in.readLine();
                StringTokenizer stk = new StringTokenizer(line);
                triangle[i] = new int[stk.countTokens()];
                for (int j = 0; j < triangle[i].length; j++) {
                    triangle[i][j] = Integer.parseInt(stk.nextToken());
                }
            }
            return triangle;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static int solve(int[][] triangle) {
        memo = new int[triangle.length][];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = new int[i + 1];
            Arrays.fill(memo[i], -1);
        }
        return dp(0, 0, triangle);
    }

    private static int dp(int m, int n, int[][] triangle) {
        if (m == triangle.length - 1) {
            memo[m][n] = triangle[m][n];
        }
        if (memo[m][n] > -1) {
            return memo[m][n];
        }

        memo[m][n] = Math.max(
                dp(m + 1, n, triangle),
                dp(m + 1, n + 1, triangle)) + triangle[m][n];
        return memo[m][n];
    }
}
