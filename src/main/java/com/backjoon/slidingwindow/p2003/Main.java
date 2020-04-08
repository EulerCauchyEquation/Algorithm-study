package com.backjoon.slidingwindow.p2003;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 백준 2003 : 수들의 합 2
 *
 * @author 송훤출
 * @since 20.04.07
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();
        StringTokenizer stk = new StringTokenizer(line);

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[] sequence = new int[n];

        line = in.nextLine();
        stk = new StringTokenizer(line);
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(stk.nextToken());
        }

        System.out.println(solve(sequence, m));
    }

    public static int solve(int[] sequence, int m) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int result = 0;

        while (end <= sequence.length) {
            if (sum < m) {
                // 1. 연속합이 m보다 작다면
                if (end == sequence.length) {
                    break;
                }
                sum = sum + sequence[end];
                end++;
            } else {
                // 2. 연속합이 m보다 크다면
                sum = sum - sequence[start];
                start++;
            }

            if (sum == m) {
                result++;
            }
        }

        return result;
    }
}
