package com.backjoon.backtrack.p2629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2629 : 양팔저울
 *
 * @author 송훤출
 * @since 20.03.21
 */
public class Main {
    static final int NOT_VISITED = 0;
    static final int POSSIBILITY = 1;
    static final int IMPOSSIBILITY = 2;

    static int[][] memo;
    static boolean[] answer;

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] weights;
        int[] marbles;

        try {
            int n = Integer.parseInt(in.readLine());
            weights = new int[n];
            String line = in.readLine();
            StringTokenizer stk = new StringTokenizer(line);
            for (int i = 0; i < n; i++) {
                weights[i] = Integer.parseInt(stk.nextToken());
            }

            n = Integer.parseInt(in.readLine());
            marbles = new int[n];
            line = in.readLine();
            stk = new StringTokenizer(line);
            for (int i = 0; i < n; i++) {
                marbles[i] = Integer.parseInt(stk.nextToken());
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }

        solve(weights, marbles);
        printAnswer();
    }

    private static void printAnswer() {
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] ? "Y" : "N");
            if (i != answer.length - 1) {
                System.out.print(" ");
            }
        }
    }

    public static boolean[] solve(int[] weights, int[] marbles) {
        answer = new boolean[marbles.length];
        memo = new int[weights.length][30 * 500 + 40000];

        for (int i = 0; i < marbles.length; i++) {
            answer[i] = dfs(0, marbles[i], weights);
        }

        return answer;
    }

    private static boolean dfs(int n, int difference, int[] weights) {
        if (n == weights.length) {
            return difference == 0;
        }
        if (difference == 0) {
            return true;
        }

        if (memo[n][difference] != NOT_VISITED) {
            return memo[n][difference] == POSSIBILITY;
        }

        boolean[] cases = new boolean[3];
        cases[0] = dfs(n + 1, difference, weights);
        cases[1] = dfs(n + 1, difference + weights[n], weights);
        cases[2] = dfs(n + 1, Math.abs(difference - weights[n]), weights);
        memo[n][difference] = (cases[0] || cases[1] || cases[2]) ? POSSIBILITY : IMPOSSIBILITY;

        return memo[n][difference] == POSSIBILITY;
    }

}
