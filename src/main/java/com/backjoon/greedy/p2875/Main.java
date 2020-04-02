package com.backjoon.greedy.p2875;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 백준 2875번 : 대회 or 인턴
 *
 * @author 송훤출
 * @since 20.04.02
 */
public class Main {
    static int result;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();
        StringTokenizer stk = new StringTokenizer(line);

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        System.out.println(solve(n, m, k));
    }

    public static int solve(int n, int m, int k) {
        result = formTeam(n, m);
        calculateTeam(n, m, k);
        return result;
    }

    private static void calculateTeam(int n, int m, int k) {
        if (k == 0) {
            return;
        }

        int girlInternCase = formTeam(n - 1, m);
        int boyInternCase = formTeam(n, m - 1);
        result = Math.max(girlInternCase, boyInternCase);

        if (girlInternCase >= boyInternCase) {
            calculateTeam(n - 1, m, k - 1);
        } else {
            calculateTeam(n, m - 1, k - 1);
        }
    }

    private static int formTeam(int n, int m) {
        n /= 2;
        return Math.min(n, m);
    }
}
