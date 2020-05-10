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
        stack = new Stack<>();
        stack.push(0);
        final String[] resultSet = dartResult
                .split("((?<=[SDT])(?=\\d))|((?<=[*#])(?=\\d))");
        for (String result : resultSet) {
            calculate(result);
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    private static void calculate(String result) {
        final String[] section = result.split("(?=[SDT])|(?=[*#])");
        final int score = Integer.parseInt(section[0]);
        final char bonus = section[1].charAt(0);
        final char option = (section.length == 3) ? section[2].charAt(0) : '$';

        if (bonus == 'D') {
            stack.push((int) Math.pow(score, 2));
        } else if (bonus == 'T') {
            stack.push((int) Math.pow(score, 3));
        }

        if (option == '*') {
            final int prev = stack.pop();
            stack.push(prev * 2);
            stack.push(score * 2);
        } else if (option == '#') {
            final int top = stack.pop();
            stack.push(-top);
        } else {
            final int top = stack.pop();
            stack.push(top);
        }
    }
}
