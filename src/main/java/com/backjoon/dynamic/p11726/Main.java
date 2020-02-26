package com.backjoon.dynamic.p11726;

import java.util.Scanner;

/**
 * 백준 11726 : 2xn 타일링
 *
 * @author 송훤출
 * @since 20.02.26
 */
public class Main {
    static long[] memo;
    static long correction = 10007;

    public static void main(String[] args) {
        int n = inputService();
        System.out.println(solve(n));
    }

    public static int inputService() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();
        return Integer.parseInt(input);
    }

    public static long solve(int value) {
        memo = new long[value + 1];
        return util(value);
    }

    private static long util(int n) {
        if (n == 0) {
            memo[0] = 1;
        }
        if (n == 1) {
            memo[1] = 1;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = (util(n - 1) + util(n - 2)) % correction;
        return memo[n];
    }
}
