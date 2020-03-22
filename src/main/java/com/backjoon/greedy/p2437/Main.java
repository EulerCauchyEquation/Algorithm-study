package com.backjoon.greedy.p2437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2437 : 저울
 *
 * @author 송훤출
 * @since 20.03.21
 */
public class Main {

    public static void main(String[] args) {
        int[] ballasts = createBallasts();
        System.out.println(solve(ballasts));
    }

    private static int[] createBallasts() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(in.readLine());
            int[] ballasts = new int[n];
            String line = in.readLine();
            StringTokenizer stk = new StringTokenizer(line);
            for (int i = 0; i < ballasts.length; i++) {
                ballasts[i] = Integer.parseInt(stk.nextToken());
            }
            return ballasts;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static int solve(int[] ballasts) {
        Arrays.sort(ballasts);

        int measurableWeight = 0;
        for (int weight : ballasts) {
            if ((measurableWeight + 1) < weight) {
                break;
            }
            measurableWeight += weight;
        }

        return measurableWeight + 1;
    }
}
