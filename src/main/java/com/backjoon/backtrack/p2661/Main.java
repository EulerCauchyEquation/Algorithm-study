package com.backjoon.backtrack.p2661;

import java.util.Scanner;

/**
 * 백준 2661번 : 좋은수열
 *
 * @author 송훤출
 * @since 20.03.15
 */
public class Main {
    static boolean hasSolved;
    static char[] elements;
    static String result;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        System.out.println(solve(n));
        in.close();
    }

    public static String solve(int n) {
        hasSolved = false;
        elements = new char[n];
        backtrack(0, '1');
        return result;
    }

    private static void backtrack(int n, char parent) {
        elements[n] = parent;
        if (hasSolved) {
            return;
        }
        if (n == elements.length - 1) {
            hasSolved = true;
            result = String.valueOf(elements);
            return;
        }

        for (char child = '1'; child <= '3'; child++) {
            if (isPromisingNode(child, n)) {
                backtrack(n + 1, child);
            }
        }
    }

    private static boolean isPromisingNode(char child, int n) {
        elements[n + 1] = child;
        int len = n + 2;
        for (int i = 1; i <= (len / 2); i++) {
            String s1 = new String(elements, len - (i * 2), i);
            String s2 = new String(elements, len - i, i);
            if (s1.equals(s2)) {
                return false;
            }
        }
        return true;
    }
}
