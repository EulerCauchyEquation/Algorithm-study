package com.backjoon.backtrack.p2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 백준 2023 : 신기한 소수
 *
 * @author 송훤출
 * @since 20.03.20
 */
public class Main {
    static List<Integer> result;
    static int N;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        solve(n);
        printResult();
    }

    private static void printResult() {
        for (int value : result) {
            System.out.println(value);
        }
    }

    public static List<Integer> solve(int n) {
        N = n;
        result = new ArrayList<>();

        dfs(1, 2);
        dfs(1, 3);
        dfs(1, 5);
        dfs(1, 7);
        return result;
    }

    private static void dfs(int n, int primeNumber) {
        if (n == N) {
            result.add(primeNumber);
            return;
        }

        for (int oddNum = 1; oddNum <= 9; oddNum += 2) {
            int nextPrimeNumber = primeNumber * 10 + oddNum;
            if (isPrimeNumber(nextPrimeNumber)) {
                dfs(n + 1, nextPrimeNumber);
            }
        }
    }

    private static boolean isPrimeNumber(int nextPrimeNumber) {
        for (int i = 2; i < nextPrimeNumber; i++) {
            if (nextPrimeNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}
