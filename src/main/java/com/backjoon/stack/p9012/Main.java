package com.backjoon.stack.p9012;

import java.util.Scanner;

/**
 * 백준 9012 : 괄호
 *
 * @author 송훤출
 * @since 20.04.13
 */
public class Main {

    public static void main(String[] args) {
        String[] testCases = createTestCases();
        boolean[] result = solve(testCases);

        for (boolean bool : result) {
            System.out.println(bool ? "YES" : "NO");
        }
    }

    private static String[] createTestCases() {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String[] testCases = new String[n];

        for (int i = 0; i < n; i++) {
            testCases[i] = in.nextLine();
        }

        return testCases;
    }

    public static boolean[] solve(String[] testCases) {
        boolean[] result = new boolean[testCases.length];

        int index = 0;
        for (String testCase : testCases) {
            result[index++] = analyze(testCase);
        }

        return result;
    }

    private static boolean analyze(String testCase) {
        int cnt = 0;

        for (char ch : testCase.toCharArray()) {
            if (ch == '(') {
                cnt++;
            } else {
                cnt--;

                if (cnt < 0) {
                    return false;
                }
            }
        }

        return cnt == 0;
    }
}
