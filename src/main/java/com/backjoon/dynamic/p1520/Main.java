package com.backjoon.dynamic.p1520;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1520 : 내리막 길
 *
 * @author 송훤출
 * @since 20.03.17
 */
public class Main {
    static final int NOT_VISITED = -1;

    static int[][] memo;
    static int[][] dirList = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        int[][] board = createBoard();
        System.out.println(solve(board));
    }

    private static int[][] createBoard() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = in.readLine();
            StringTokenizer stk = new StringTokenizer(line);
            int m = Integer.parseInt(stk.nextToken());
            int n = Integer.parseInt(stk.nextToken());
            int[][] board = new int[m][n];
            for (int i = 0; i < m; i++) {
                line = in.readLine();
                stk = new StringTokenizer(line);
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

        memo = new int[m][n];
        for (int[] me : memo) {
            Arrays.fill(me, NOT_VISITED);
        }
        Point root = new Point(m - 1, n - 1);
        return dfs(root, board);
    }

    private static int dfs(Point parent, int[][] board) {
        if (parent.x == 0 && parent.y == 0) {
            memo[parent.x][parent.y] = 1;
        }
        if (memo[parent.x][parent.y] != NOT_VISITED) {
            return memo[parent.x][parent.y];
        }

        memo[parent.x][parent.y] = 0;
        for (int[] dir : dirList) {
            int x = parent.x + dir[0];
            int y = parent.y + dir[1];
            Point child = new Point(x, y);
            if (isPromisingNode(child, parent, board)) {
                memo[parent.x][parent.y] += dfs(child, board);
            }
        }
        return memo[parent.x][parent.y];
    }

    private static boolean isPromisingNode(Point child, Point parent, int[][] board) {
        if (child.x < 0 || child.y < 0 || child.x >= board.length || child.y >= board[0].length) {
            return false;
        }
        return board[child.x][child.y] > board[parent.x][parent.y];
    }
}
