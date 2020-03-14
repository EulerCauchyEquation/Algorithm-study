package com.backjoon.backtrack.p1342;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 백준 1342번 : 행운의 문자열
 *
 * @author 송훤출
 * @since 20.03.14
 */
public class Main {
    static Set<String> result;
    static char[] backtrackList;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(solve(input));
        in.close();
    }

    public static int solve(String input) {
        result = new HashSet<>();
        backtrackList = input.toCharArray();

        for (int i = 0; i < backtrackList.length; i++) {
            backtrack(0, i);
        }

        return result.size();
    }

    private static void backtrack(int level, int target) {
        swap(level, target);

        if (level == backtrackList.length - 1) {
            result.add(Arrays.toString(backtrackList));
            return;
        }

        for (int i = level + 1; i < backtrackList.length; i++) {
            char childNode = backtrackList[i];
            if (isPromisingNode(childNode, level)) {
                backtrack(level + 1, i);
            }
        }

        swap(level, target);
    }

    private static void swap(int level, int target) {
        if (backtrackList.length <= 0) {
            return;
        }
        char temp = backtrackList[level];
        backtrackList[level] = backtrackList[target];
        backtrackList[target] = temp;
    }

    private static boolean isPromisingNode(char childNode, int level) {
        return backtrackList[level] != childNode;
    }
}
