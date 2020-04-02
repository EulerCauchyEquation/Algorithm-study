package com.backjoon.dynamic.p1495;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 백준 1495번 : 기타리스트
 *
 * @author 송훤출
 * @since 20.04.02
 */
public class Main {
    static final int NOT_VISITED = 0;
    static final int IMPOSSIBLE = -1;
    static final int POSSIBLE = 1;

    static int[][] memo;
    static int[] mVolumes;
    static int M;
    static int result;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();
        StringTokenizer stk = new StringTokenizer(line);

        int n = Integer.parseInt(stk.nextToken());
        int s = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] volumes = new int[n];
        line = in.nextLine();
        stk = new StringTokenizer(line);

        for (int i = 0; i < n; i++) {
            volumes[i] = Integer.parseInt(stk.nextToken());
        }

        System.out.println(solve(s, m, volumes));
    }

    public static int solve(int s, int m, int[] volumes) {
        memo = new int[volumes.length][m + 1];
        mVolumes = volumes.clone();
        M = m;
        result = Integer.MIN_VALUE;

        dfs(0, s);

        return result == Integer.MIN_VALUE ? -1 : result;
    }

    private static void dfs(int n, int p) {
        if (n == mVolumes.length) {
            result = Math.max(result, p);
            return;
        }
        if (memo[n][p] != NOT_VISITED) {
            return;
        }

        memo[n][p] = POSSIBLE;
        if (p - mVolumes[n] >= 0) {
            dfs(n + 1, p - mVolumes[n]);
        } else {
            memo[n][p] = IMPOSSIBLE;
        }
        if (p + mVolumes[n] <= M) {
            dfs(n + 1, p + mVolumes[n]);
        } else {
            memo[n][p] = IMPOSSIBLE;
        }
    }
}
