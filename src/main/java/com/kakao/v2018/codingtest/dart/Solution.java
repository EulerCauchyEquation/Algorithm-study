package com.kakao.v2018.codingtest.dart;

import java.util.Stack;

/**
 * 카카오 2018 블라인드 코딩 테스트 : 다트 게임
 *
 * @author 송훤출
 * @since 20.05.08
 */
public class Solution {
    static Stack<Integer> stack;

    public static int solution(String dartResult) {
        final char[] result = dartResult.toCharArray();
        final StringBuilder score = new StringBuilder();
        char bonus;
        char option = '$';
        stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < result.length; i++) {
            if (Character.isDigit(result[i])) {
                score.append(result[i]);
            } else if (Character.isLetter(result[i])) {
                if (i + 1 < result.length
                        && !Character.isDigit(result[i + 1])) {
                    option = result[i + 1];
                }
                bonus = result[i];
                calculate(score, bonus, option);

                score.setLength(0);
                option = '$';
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    private static void calculate(StringBuilder score, char bonus, char option) {
        int temp = Integer.parseInt(score.toString());

        if (bonus == 'D') {
            temp = (int) Math.pow(temp, 2);
        } else if (bonus == 'T') {
            temp = (int) Math.pow(temp, 3);
        }

        if (option == '*') {
            final int prev = stack.pop();
            stack.push(prev * 2);
            stack.push(temp * 2);
        } else if (option == '#') {
            stack.push(-temp);
        } else {
            stack.push(temp);
        }
    }
}
