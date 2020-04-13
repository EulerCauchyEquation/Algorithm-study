package com.backjoon.dynamic.p1149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1149번 문제
 *
 * @author 송훤출
 * @since 20.02.29
 */
public class Main {
    static int[][] memo;

    public static void main(String[] args) {
        int[][] values = ScannerService();
        System.out.println(solve(values));
    }

    private static int[][] ScannerService() {
        int[][] values;
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(in.readLine());
            values = new int[n][3];
            for (int i = 0; i < n; i++) {
                String input = in.readLine();
                StringTokenizer stk = new StringTokenizer(input);
                values[i][0] = Integer.parseInt(stk.nextToken());
                values[i][1] = Integer.parseInt(stk.nextToken());
                values[i][2] = Integer.parseInt(stk.nextToken());
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return values;
    }

    private static Color[] createOtherColors(Color color) {
        Color[] otherColors = new Color[2];
        int i = 0;
        for (Color otherColor : Color.values()) {
            if (!otherColor.match(color)) {
                otherColors[i++] = otherColor;
            }
        }
        return otherColors;
    }

    public static int solve(int[][] values) {
        int n = values.length - 1;
        memo = new int[n + 1][3];
        return min(
                util(n, Color.RED, values),
                util(n, Color.GREEN, values),
                util(n, Color.BLUE, values));
    }

    private static int util(int n, Color preColor, int[][] values) {
        Color[] otherColors = createOtherColors(preColor);
        int indexOfPreColor = preColor.getIndex();
        if (n == 0) {
            memo[n][indexOfPreColor] = values[n][indexOfPreColor];
        }
        if (memo[n][indexOfPreColor] > 0) {
            return memo[n][indexOfPreColor];
        }
        memo[n][indexOfPreColor] = Math.min(
                util(n - 1, otherColors[0], values),
                util(n - 1, otherColors[1], values)) + values[n][indexOfPreColor];
        return memo[n][indexOfPreColor];
    }

    private static int min(int value1, int value2, int value3) {
        if (value1 < value3) {
            return Math.min(value1, value2);
        } else {
            return Math.min(value3, value2);
        }
    }

    enum Color {
        RED(0),
        GREEN(1),
        BLUE(2);

        private int index;

        Color(int index) {
            this.index = index;
        }

        private boolean match(Color color) {
            return this.index == color.index;
        }

        public int getIndex() {
            return index;
        }
    }
}
