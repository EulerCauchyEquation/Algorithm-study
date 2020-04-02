package com.backjoon.dfs.p1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 백준 1697번 : 숨바꼭질
 *
 * @author 송훤출
 * @since 20.04.02
 */
public class Main {
    static int[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();
        StringTokenizer stk = new StringTokenizer(line);

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        System.out.println(solve(n, k));
    }

    public static int solve(int n, int k) {
        visited = new int[100001];

        return bfs(n, k);
    }

    private static int bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = 1;

        while (!queue.isEmpty()) {
            int here = queue.poll();

            if (here == k) {
                return visited[here] - 1;
            }

            for (ActCase act : ActCase.values()) {
                int next = act.move(here);

                if (isValidPoint(next)) {
                    queue.offer(next);
                    visited[next] = visited[here] + 1;
                }
            }
        }

        throw new AssertionError("cannot case");
    }


    private static boolean isValidPoint(int pos) {
        if (pos < 0 || pos > 100000) {
            return false;
        }

        return visited[pos] == 0;
    }

    enum ActCase {
        LEFT_MOVE, RIGHT_MOVE, JUMP;

        int move(int pos) {
            switch (this) {
                case LEFT_MOVE:
                    return pos - 1;
                case RIGHT_MOVE:
                    return pos + 1;
                case JUMP:
                    return pos * 2;
            }
            throw new AssertionError("Unknown op : " + this);
        }

    }
}
