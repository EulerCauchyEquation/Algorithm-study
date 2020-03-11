package com.backjoon.dynamic.p2169;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2168번 : 로봇 조종하기
 *
 * @author 송훤출
 * @since 20.03.10
 */
public class Main {
    static final int LEFT = 0;
    static final int RIGHT = 1;
    static final int UP = 2;
    static int[][][] memo;

    public static void main(String[] args) {
        int[][] board = createBoard();
        System.out.println(solve(board));
    }

    private static int[][] createBoard() {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            String input = in.readLine();
            StringTokenizer stk = new StringTokenizer(input);
            int m = Integer.parseInt(stk.nextToken());
            int n = Integer.parseInt(stk.nextToken());
            int[][] board = new int[m][n];
            for (int i = 0; i < m; i++) {
                input = in.readLine();
                stk = new StringTokenizer(input);
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(stk.nextToken());
                }
            }
            return board;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static int solve(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        memo = new int[m][n][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], Integer.MIN_VALUE);
            }
        }
        return util(m - 1, n - 1, UP, board);
    }

    private static int util(int m, int n, int fromDir, int[][] board) {
        if (m < 0 || n < 0 || n >= board[0].length) {
            return Integer.MIN_VALUE;
        }
        if (m == 0 && n == 0) {
            return board[0][0];
        }
        if (memo[m][n][fromDir] > Integer.MIN_VALUE) {
            return memo[m][n][fromDir];
        }

        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        int up = util(m - 1, n, UP, board);

        if (fromDir != RIGHT) {
            left = util(m, n - 1, LEFT, board);
        }
        if (fromDir != LEFT) {
            right = util(m, n + 1, RIGHT, board);
        }
        memo[m][n][fromDir] = max(left, right, up);
        memo[m][n][fromDir] = (memo[m][n][fromDir] == Integer.MIN_VALUE)
                ? memo[m][n][fromDir]
                : memo[m][n][fromDir] + board[m][n];
        return memo[m][n][fromDir];
    }

    private static int max(int value1, int value2, int value3) {
        if (value1 > value2) {
            return Math.max(value1, value3);
        } else {
            return Math.max(value2, value3);
        }
    }
}
