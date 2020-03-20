package com.backjoon.dynamic.p2240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2240 : 자두나무
 *
 * @author 송훤출
 * @since 20.03.19
 */
public class Main {
    static int[][][] memo;

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int w;
        int[] times;
        try {
            String line = in.readLine();
            StringTokenizer stk = new StringTokenizer(line);
            int n = Integer.parseInt(stk.nextToken());
            w = Integer.parseInt(stk.nextToken());
            times = new int[n];

            for (int i = 0; i < times.length; i++) {
                times[i] = Integer.parseInt(in.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }

        System.out.println(solve(times, w));
    }

    public static int solve(int[] times, int w) {
        memo = new int[times.length][w + 1][3];
        for (int i = 0; i < times.length; i++) {
            for (int j = 0; j < w + 1; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return Math.max(
                dfs(0, 1, w, times),
                dfs(0, 2, w - 1, times));
    }

    private static int dfs(int time, int pos, int strength, int[] times) {
        if (time == times.length - 1) {
            return pos == times[time] ? 1 : 0;
        }
        if (memo[time][strength][pos] > -1) {
            return memo[time][strength][pos];
        }

        int hit = (pos == times[time]) ? 1 : 0;
        int[] cases = new int[2];
        for (int nextPos = 1; nextPos <= 2; nextPos++) {
            boolean hasMoved = (nextPos != pos);
            if ((strength > 0) && hasMoved) {
                // case 1. 움직일 힘이 남아있고, 이동 함
                cases[0] = dfs(time + 1, nextPos, strength - 1, times);
            } else if (!hasMoved) {
                // case 2. 이동 안 함(움직일 힘이 남아있든 없든)
                cases[1] = dfs(time + 1, nextPos, strength, times);
            }
        }
        memo[time][strength][pos] = Math.max(cases[0], cases[1]) + hit;
        return memo[time][strength][pos];
    }
}
