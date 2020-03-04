package com.backjoon.dynamic.p1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1890문제 : 점프
 *
 * @author 송훤출
 * @since 20.03.04
 */
public class Main {
    static long[][] memo;

    public static void main(String[] args) {
        int[][] board = createBoard();
        System.out.println(solve(board));
    }

    private static int[][] createBoard() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[][] board;
        try {
            int n = Integer.parseInt(in.readLine());
            board = new int[n][n];
            for (int i = 0; i < n; i++) {
                String readLine = in.readLine();
                StringTokenizer stk = new StringTokenizer(readLine);
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(stk.nextToken());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return board;
    }

    public static long solve(int[][] board) {
        int startPos = 0;
        memo = new long[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return util(startPos, startPos, board);
    }

    private static long util(int x, int y, int[][] board) {
        if (isOutOfRange(x, y, board)) {
            return 0;
        }
        if (isGoalPoint(x, y, board)) {
            memo[x][y] = 1;
            return memo[x][y];
        }
        if (isMovable(x, y, board)) {
            memo[x][y] = 0;
        }
        if (memo[x][y] >= 0) {
            return memo[x][y];
        }
        memo[x][y] = util(x, board[x][y] + y, board) + util(board[x][y] + x, y, board);
        return memo[x][y];
    }

    private static boolean isMovable(int x, int y, int[][] board) {
        return board[x][y] == 0;
    }

    private static boolean isGoalPoint(int x, int y, int[][] board) {
        return (x == board.length - 1) && (y == board.length - 1);
    }

    private static boolean isOutOfRange(int x, int y, int[][] board) {
        return (x >= board.length) || (y >= board.length);
    }
}
