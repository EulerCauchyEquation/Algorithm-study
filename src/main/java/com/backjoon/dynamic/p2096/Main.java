package com.backjoon.dynamic.p2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2096번 : 내려가기
 *
 * @author 송훤출
 * @since 20.04.06
 */
public class Main {
    static int[][] mBoard;
    static int[][] memo;

    public static void main(String[] args) {
        int[][] board = createBoard();
        int[] result = solve(board);
        System.out.print(result[0] + " " + result[1]);
    }

    private static int[][] createBoard() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(in.readLine());
            int[][] board = new int[n][n];

            for (int i = 0; i < n; i++) {
                String line = in.readLine();
                StringTokenizer stk = new StringTokenizer(line);

                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(stk.nextToken());
                }
            }

            return board;
        } catch (IOException e) {
            throw new AssertionError();
        }
    }

    public static int[] solve(int[][] board) {
        mBoard = board.clone();
        memo = new int[board.length][board.length];

        int[] result = new int[2];
        result[1] = Integer.MAX_VALUE;

        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        for (int i = 0; i < board.length; i++) {
            result[0] = Math.max(result[0], dfsMax(0, i));
        }

        for (int[] m : memo) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }
        for (int i = 0; i < board.length; i++) {
            result[1] = Math.min(result[1], dfsMin(0, i));
        }

        return result;
    }

    private static int dfsMax(int m, int n) {
        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        for (PlayCase playCase : PlayCase.values()) {
            int x = m + playCase.x;
            int y = n + playCase.y;

            if (isValidPoint(x, y)) {
                memo[m][n] = Math.max(memo[m][n],
                        dfsMax(x, y));
            }
        }
        memo[m][n] = (memo[m][n] == -1) ? 0 : memo[m][n];
        memo[m][n] += mBoard[m][n];

        return memo[m][n];
    }

    private static int dfsMin(int m, int n) {
        if (memo[m][n] != Integer.MAX_VALUE) {
            return memo[m][n];
        }

        for (PlayCase playCase : PlayCase.values()) {
            int x = m + playCase.x;
            int y = n + playCase.y;

            if (isValidPoint(x, y)) {
                memo[m][n] = Math.min(memo[m][n],
                        dfsMin(x, y));
            }
        }
        memo[m][n] = (memo[m][n] == Integer.MAX_VALUE) ? 0 : memo[m][n];
        memo[m][n] += mBoard[m][n];

        return memo[m][n];
    }

    private static boolean isValidPoint(int x, int y) {
        return x >= 0 && y >= 0 && x < mBoard.length && y < mBoard.length;
    }

    enum PlayCase {
        LEFT(1, -1),
        RIGHT(1, 1),
        CENTER(1, 0);

        int x;
        int y;

        PlayCase(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
