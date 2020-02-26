package com.backjoon.dynamic.p1463;

import java.util.Scanner;

/**
 * 백준 1463번 : 1로 만들기
 *
 * @author 송훤출
 * @since 20.02.26
 */
public class Main {
    static int[] memo;

    public static void main(String[] args) {
        int value = inputService();
        System.out.println(solve(value));
    }

    public static int inputService() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();
        return Integer.parseInt(input);
    }

    public static int solve(int value) {
        memo = new int[value + 1];
        return dfs(value);
    }

    private static int dfs(int n) {
        if (n == 1) {
            return 0;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        int dividedByThree = (n % 3 == 0) ? dfs(n / 3) : Integer.MAX_VALUE;
        int dividedByTwo = (n % 2 == 0) ? dfs(n / 2) : Integer.MAX_VALUE;
        int minusOfOne = dfs(n - 1);
        memo[n] = 1 + min(dividedByThree, dividedByTwo, minusOfOne);
        return memo[n];
    }

    public static int min(int value1, int value2, int value3) {
        if (value1 < value2) {
            return Math.min(value1, value3);
        } else {
            return Math.min(value2, value3);
        }
    }
}