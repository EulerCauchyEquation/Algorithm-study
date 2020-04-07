package com.backjoon.dynamic.p2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2096번 : 내려가기
 *
 * @author 송훤출
 * @since 20.04.07
 */
public class Main {

    public static void main(String[] args) {
        int[][] board = createBoard();
        int[] result = solve(board);
        System.out.print(result[0] + " " + result[1]);
    }

    private static int[][] createBoard() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(in.readLine());
            int[][] board = new int[n][3];

            for (int i = 0; i < n; i++) {
                String line = in.readLine();
                StringTokenizer stk = new StringTokenizer(line);

                for (int j = 0; j < 3; j++) {
                    board[i][j] = Integer.parseInt(stk.nextToken());
                }
            }

            return board;
        } catch (IOException e) {
            throw new AssertionError();
        }
    }

    public static int[] solve(int[][] board) {
        int[] temp = new int[3];
        int[] max = new int[3];

        for (int[] row : board) {
            max[0] = row[0] + Math.max(temp[0], temp[1]);
            max[1] = row[1] + Math.max(temp[0], Math.max(temp[1], temp[2]));
            max[2] = row[2] + Math.max(temp[1], temp[2]);

            for (int i = 0; i < 3; i++) {
                temp[i] = max[i];
            }
        }

        temp = new int[3];
        int[] min = new int[3];

        for (int[] row : board) {
            min[0] = row[0] + Math.min(temp[0], temp[1]);
            min[1] = row[1] + Math.min(temp[0], Math.min(temp[1], temp[2]));
            min[2] = row[2] + Math.min(temp[1], temp[2]);

            for (int i = 0; i < 3; i++) {
                temp[i] = min[i];
            }
        }

        return new int[]{
                Math.max(max[0], Math.max(max[1], max[2])),
                Math.min(min[0], Math.min(min[1], min[2]))
        };
    }
}
