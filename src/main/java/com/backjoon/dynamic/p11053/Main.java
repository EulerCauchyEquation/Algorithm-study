package com.backjoon.dynamic.p11053;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 백준 11053 : LIS
 *
 * @author 송훤출
 * @since 20.04.03
 */
public class Main {
    static int[] mSequence;
    static int[][] memo;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[] sequence = new int[n];

        String line = in.nextLine();
        StringTokenizer stk = new StringTokenizer(line);

        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(stk.nextToken());
        }

        System.out.println(solve(sequence));
    }

    public static int solve(int[] sequence) {
        mSequence = sequence.clone();
        memo = new int[sequence.length][1001];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return dfs(0, 0);
    }

    private static int dfs(int n, int standard) {
        if (n == mSequence.length) {
            return 0;
        }
        if (memo[n][standard] != -1) {
            return memo[n][standard];
        }

        int selectCase = 0;
        if (standard < mSequence[n]) {
            selectCase = dfs(n + 1, mSequence[n]) + 1;
        }
        int skipCase = dfs(n + 1, standard);
        memo[n][standard] = Math.max(selectCase, skipCase);

        return memo[n][standard];
    }
}
