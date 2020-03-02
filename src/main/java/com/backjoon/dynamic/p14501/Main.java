package com.backjoon.dynamic.p14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 14501번 : 퇴사
 *
 * @author 송훤출
 * @since 20.03.02
 */
public class Main {
    static final int PERIOD = 0;
    static final int MONEY = 1;

    public static void main(String[] args) {
        int[][] values = createValues();
        System.out.println(solve(values));
    }

    private static int[][] createValues() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[][] values;
        try {
            int n = Integer.parseInt(in.readLine());
            values = new int[n][2];
            for (int i = 0; i < n; i++) {
                String input = in.readLine();
                StringTokenizer stk = new StringTokenizer(input);
                values[i][0] = Integer.parseInt(stk.nextToken());
                values[i][1] = Integer.parseInt(stk.nextToken());
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return values;
    }

    public static int solve(int[][] values) {
        int n = values.length - 1;
        return util(n, 1, values);
    }

    public static int util(int n, int numberOfDaysOff, int[][] values) {
        if (n == 0) {
            return values[0][PERIOD] <= numberOfDaysOff
                    ? values[0][MONEY]
                    : 0;
        }
        if (values[n][PERIOD] > numberOfDaysOff) {
            return util(n - 1, numberOfDaysOff + 1, values);
        }
        return Math.max(
                util(n - 1, 1, values) + values[n][MONEY],
                util(n - 1, numberOfDaysOff + 1, values)
        );
    }
}
