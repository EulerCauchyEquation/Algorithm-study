package com.backjoon.dynamic.p9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 9251번 : LCS
 *
 * @author 송훤출
 * @since 20.03.05
 */
public class Main {
    static char[] sequence1Values;
    static char[] sequence2Values;

    static int[][] memo;

    public static void main(String[] args) {
        String[] sequence = createSequence();
        System.out.println(solve(sequence[0], sequence[1]));
    }

    private static String[] createSequence() {
        String[] input = new String[2];
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            input[0] = in.readLine();
            input[1] = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return input;
    }

    public static int solve(String sequence1, String sequence2) {
        sequence1Values = sequence1.toCharArray();
        sequence2Values = sequence2.toCharArray();
        int n1 = sequence1Values.length - 1;
        int n2 = sequence2Values.length - 1;
        memo = new int[n1 + 1][n2 + 1];
        for (int i = 0; i < n1 + 1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return LCS(n1, n2);
    }

    public static int LCS(int n1, int n2) {
        if (n1 == -1 || n2 == -1) {
            return 0;
        }
        if (memo[n1][n2] > -1) {
            return memo[n1][n2];
        }
        if (sequence1Values[n1] == sequence2Values[n2]) {
            memo[n1][n2] = LCS(n1 - 1, n2 - 1) + 1;
        } else {
            memo[n1][n2] = Math.max(
                    LCS(n1 - 1, n2),
                    LCS(n1, n2 - 1));
        }
        return memo[n1][n2];
    }
}
