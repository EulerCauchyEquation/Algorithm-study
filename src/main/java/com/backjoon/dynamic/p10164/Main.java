package com.backjoon.dynamic.p10164;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 백준 10164번 : 격자상의 경로
 *
 * @author 송훤출
 * @since 20.03.09
 */
public class Main {
    static int[][] memo;
    static int kx;
    static int ky;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        StringTokenizer stk = new StringTokenizer(input);
        int m = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        System.out.println(solve(m, n, k));

        in.close();
    }

    public static int solve(int m, int n, int k) {
        k--;
        kx = k / n;
        ky = k % n;
        memo = new int[m][n];
        for (int[] data : memo) {
            Arrays.fill(data, -1);
        }
        return util(m - 1, n - 1);
    }

    private static int util(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 0 && n == 0) {
            memo[m][n] = 1;
        }
        if (memo[m][n] > -1) {
            return memo[m][n];
        }
        memo[m][n] = (kx <= m && ky <= n) || (kx >= m && ky >= n)
                ? util(m - 1, n) + util(m, n - 1)
                : 0;
        return memo[m][n];
    }

}
