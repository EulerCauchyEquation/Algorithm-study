package com.backjoon.backtrack.p9663;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 백준 9663번 : N-Queen
 *
 * @author 송훤출
 * @since 20.03.13
 */
public class Main {
    static LinkedList<Point2D> list;
    static int N;
    static int result;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        System.out.println(solve(n));
        in.close();
    }

    public static int solve(int n) {
        N = n;
        result = 0;
        for (int i = 0; i < n; i++) {
            list = new LinkedList<>();
            dfs(0, i);
        }

        return result;
    }

    private static void dfs(int m, int n) {
        list.addLast(new Point2D(m, n));

        if (m == N - 1) {
            result++;
            list.removeLast();
            return;
        }

        for (int y = 0; y < N; y++) {
            int x = m + 1;
            if (isValid(x, y)) {
                dfs(x, y);
            }
        }

        list.removeLast();
    }

    private static boolean isValid(int x, int y) {
        for (Point2D p : list) {
            if (y == p.y) {
                return false;
            }
            double m = ((double) (y - p.y) / (x - p.x));
            if (Math.abs(m) == 1.0) {
                return false;
            }
        }
        return true;
    }

    static class Point2D {
        int x;
        int y;

        public Point2D(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
