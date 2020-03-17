package com.backjoon.backtrack.p3109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 3109 : 빵집
 *
 * @author 송훤출
 * @since 20.03.17
 */
public class Main {
    static int[][] dirList = {{-1, 1}, {0, 1}, {1, 1}};
    static boolean[][] visited;
    static boolean hasSolved;
    static int result;

    public static void main(String[] args) {
        char[][] map = createMap();
        System.out.println(solve(map));
    }

    private static char[][] createMap() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = in.readLine();
            StringTokenizer stk = new StringTokenizer(line);
            int m = Integer.parseInt(stk.nextToken());
            int n = Integer.parseInt(stk.nextToken());
            char[][] map = new char[m][n];
            for (int i = 0; i < map.length; i++) {
                line = in.readLine();
                for (int j = 0; j < line.length(); j++) {
                    map[i][j] = line.charAt(j);
                }
            }
            return map;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static int solve(char[][] map) {
        int m = map.length;
        int n = map[0].length;
        visited = new boolean[m][n];
        result = 0;

        for (int i = 0; i < m; i++) {
            hasSolved = false;
            backtrack(i, 0, map);
        }
        return result;
    }

    private static void backtrack(int m, int n, char[][] map) {
        visited[m][n] = true;

        if (n == map[0].length - 1) {
            hasSolved = true;
            result++;
            return;
        }

        for (int dir = 0; dir < dirList.length; dir++) {
            int x = m + dirList[dir][0];
            int y = n + dirList[dir][1];
            if (isPromisingNode(x, y, map)) {
                backtrack(x, y, map);
                if (hasSolved) {
                    return;
                }
            }
        }
    }

    private static boolean isPromisingNode(int x, int y, char[][] map) {
        if (x < 0 || y < 0 || x >= map.length || y >= map[0].length) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        return map[x][y] == '.';
    }
}
