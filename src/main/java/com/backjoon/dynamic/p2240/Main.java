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
    static int W;
    static int result;

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int w = 0;
        int[] plumTimes;
        try {
            String line = in.readLine();
            StringTokenizer stk = new StringTokenizer(line);
            int n = Integer.parseInt(stk.nextToken());
            w = Integer.parseInt(stk.nextToken());
            plumTimes = new int[n];

            for (int i = 0; i < plumTimes.length; i++) {
                plumTimes[i] = Integer.parseInt(in.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }

        System.out.println(solve(plumTimes, w));
    }

    public static int solve(int[] plumTimes, int w) {
        W = w;
        result = 0;
        memo = new int[plumTimes.length][w + 1][3];
        for (int i = 0; i < plumTimes.length; i++) {
            for (int j = 0; j < w + 1; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        dfs(0, 1, 0, 0, plumTimes);
        dfs(0, 2, 1, 0, plumTimes);
        return result;
    }

    private static void dfs(int time, int plum, int w, int hit, int[] plumTimes) {
        if (time == plumTimes.length) {
            result = Math.max(result, hit);
            return;
        }
        if (memo[time][w][plum] > -1) {
            memo[time][w][plum] = Math.min(memo[time][w][plum], hit);
            return;
        }

        hit += (plum == plumTimes[time]) ? 1 : 0;
        memo[time][w][plum] = hit;
        for (int plumType = 1; plumType <= 2; plumType++) {
            boolean hasMoved = (plumType != plum);
            if (hasMoved && W > w) {
                dfs(time + 1, plumType, w + 1, hit, plumTimes);
            } else if (!hasMoved) {
                dfs(time + 1, plumType, w, hit, plumTimes);
            }
        }
    }
}
