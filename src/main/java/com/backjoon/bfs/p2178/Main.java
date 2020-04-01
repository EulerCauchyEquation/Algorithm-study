package com.backjoon.bfs.p2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 백준 2178번 : 미로 탐색
 *
 * @author 송훤출
 * @since 20.04.01
 */
public class Main {
    static int[][] mMaze;
    static boolean[][] visited;

    public static void main(String[] args) {
        int[][] maze = createMaze();
        System.out.println(solve(maze));
    }

    private static int[][] createMaze() {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();
        StringTokenizer stk = new StringTokenizer(line);

        int m = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());
        int[][] maze = new int[m][n];

        for (int i = 0; i < m; i++) {
            line = in.nextLine();

            for (int j = 0; j < n; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        return maze;
    }

    public static int solve(int[][] maze) {
        mMaze = maze.clone();
        visited = new boolean[maze.length][maze[0].length];

        return bfs(new Pos2D(0, 0));
    }

    private static int bfs(Pos2D start) {
        Queue<Pos2D> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Pos2D pos = queue.poll();

            for (Direction dir : Direction.values()) {
                Pos2D next = new Pos2D(
                        pos.x + dir.pos.x,
                        pos.y + dir.pos.y);

                if (isValidPoint(next)) {
                    queue.offer(next);
                    visited[pos.x][pos.y] = true;
                    mMaze[next.x][next.y] = mMaze[pos.x][pos.y] + 1;
                }
            }
        }

        return mMaze[mMaze.length - 1][mMaze[0].length - 1];
    }

    private static boolean isValidPoint(Pos2D pos) {
        if (pos.x < 0 || pos.y < 0 || pos.x >= mMaze.length || pos.y >= mMaze[0].length) {
            return false;
        }

        if (visited[pos.x][pos.y]) {
            return false;
        }

        return mMaze[pos.x][pos.y] == 1;
    }

    enum Direction {
        NORTH(new Pos2D(-1, 0)),
        WEST(new Pos2D(0, 1)),
        SOUTH(new Pos2D(1, 0)),
        EAST(new Pos2D(0, -1));

        Pos2D pos;

        Direction(Pos2D pos) {
            this.pos = pos;
        }
    }

    static class Pos2D {
        int x;
        int y;

        public Pos2D(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
