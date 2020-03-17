package com.backjoon.backtrack.p2210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 백준 2210 : 숫자판 점프
 *
 * @author 송훤출
 * @since 20.03.17
 */
public class Main {
    static Set<Integer> numberSet;
    static StringBuilder number;
    static int[][] dirList = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        int[][] board = createBoard();
        System.out.println(solve(board));
    }

    private static int[][] createBoard() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            int[][] board = new int[5][5];
            for (int i = 0; i < 5; i++) {
                String line = in.readLine();
                StringTokenizer stk = new StringTokenizer(line);
                for (int j = 0; j < 5; j++) {
                    board[i][j] = Integer.parseInt(stk.nextToken());
                }
            }
            return board;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static int solve(int[][] board) {
        numberSet = new HashSet<>();
        number = new StringBuilder();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                number.setLength(0);
                dfs(i, j, 0, board);
            }
        }
        return numberSet.size();
    }

    private static void dfs(int m, int n, int level, int[][] board) {
        if (level == 6) {
            numberSet.add(Integer.parseInt(number.toString()));
            return;
        }
        number.append(board[m][n]);

        for (int dir = 0; dir < dirList.length; dir++) {
            int x = m + dirList[dir][0];
            int y = n + dirList[dir][1];
            if (isPromisingNode(x, y, board)) {
                dfs(x, y, level + 1, board);
            }
        }

        number.deleteCharAt(level);
    }

    private static boolean isPromisingNode(int x, int y, int[][] board) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length;
    }
}
