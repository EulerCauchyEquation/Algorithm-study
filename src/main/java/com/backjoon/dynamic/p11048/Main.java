package com.backjoon.dynamic.p11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 11048 : 이동하기
 *
 * @author 송훤출
 * @since 20.03.12
 */
public class Main {
    static int[][] memo;

    static boolean[][] visited;
    static int[][] dirList = {{1, 0}, {0, 1}, {1, 1}};
    static int candy;
    static int result;

    public static void main(String[] args) {
        int[][] maze = createMaze();
        System.out.println(solve(maze));
    }

    private static int[][] createMaze() {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            String input = in.readLine();
            StringTokenizer stk = new StringTokenizer(input);
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            int[][] maze = new int[n][m];
            for (int i = 0; i < n; i++) {
                input = in.readLine();
                stk = new StringTokenizer(input);
                for (int j = 0; j < m; j++) {
                    maze[i][j] = Integer.parseInt(stk.nextToken());
                }
            }
            return maze;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static int solve(int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;
        memo = new int[n][m];
        visited = new boolean[n][m];
        candy = 0;
        result = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        dfs(0, 0, maze);
        return result;
    }

    private static int util(int n, int m, int[][] maze) {
        if (n < 0 || m < 0 || n >= maze.length || m >= maze[0].length) {
            return 0;
        }
        if (n == 0 && m == 0) {
            return maze[0][0];
        }
        if (memo[n][m] > -1) {
            return memo[n][m];
        }
        memo[n][m] = max(
                util(n, m - 1, maze),
                util(n - 1, m - 1, maze),
                util(n - 1, m, maze)) + maze[n][m];
        return memo[n][m];
    }

    private static int max(int value1, int value2, int value3) {
        return Math.max(value1, Math.max(value2, value3));
    }

    private static void dfs(int n, int m, int[][] maze) {
        candy += maze[n][m];
        visited[n][m] = true;
        result = Math.max(result, candy);

        if (n == maze.length - 1 && m == maze[0].length - 1) {
            candy -= maze[n][m];
            visited[n][m] = false;
            return;
        }

        for (int[] dir : dirList) {
            int x = n + dir[0];
            int y = m + dir[1];
            if (isMovable(x, y, maze)) {
                dfs(x, y, maze);
            }
        }

        candy -= maze[n][m];
        visited[n][m] = false;
    }

    private static boolean isMovable(int x, int y, int[][] maze) {
        if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length) {
            return false;
        }
        return !visited[x][y];
    }
}
