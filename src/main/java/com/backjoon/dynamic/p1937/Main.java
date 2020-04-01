package com.backjoon.dynamic.p1937;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 백준 1937번 : 욕심쟁이 판다
 *
 * @author 송훤출
 * @since 20.04.01
 */
public class Main {
    static int[][] mForest;
    static int[][] memo;

    public static void main(String[] args) {
        int[][] forest = createForest();
        System.out.println(solve(forest));
    }

    private static int[][] createForest() {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[][] forest = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            StringTokenizer stk = new StringTokenizer(line);

            for (int j = 0; j < n; j++) {
                forest[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        in.close();
        return forest;
    }

    public static int solve(int[][] forest) {
        mForest = forest.clone();
        memo = new int[forest.length][forest.length];

        int result = 0;
        for (int i = 0; i < forest.length; i++) {
            for (int j = 0; j < forest.length; j++) {
                result = Math.max(result, dfs(i, j));
            }
        }

        return result;
    }

    private static int dfs(int m, int n) {
        if (memo[m][n] > 0) {
            return memo[m][n];
        }

        for (Direction dir : Direction.values()) {
            int x = m + dir.x;
            int y = n + dir.y;

            if (isValidPoint(m, n, x, y)) {
                memo[m][n] = Math.max(dfs(x, y), memo[m][n]);
            }
        }
        memo[m][n] = memo[m][n] + 1;
        return memo[m][n];
    }

    private static boolean isValidPoint(int srcX, int srcY, int dstX, int dstY) {
        if (dstX < 0 || dstY < 0 || dstX >= mForest.length || dstY >= mForest.length) {
            return false;
        }

        return mForest[srcX][srcY] < mForest[dstX][dstY];
    }

    enum Direction {
        NORTH(-1, 0),
        WEST(0, 1),
        SOUTH(1, 0),
        EAST(0, -1);

        int x;
        int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
