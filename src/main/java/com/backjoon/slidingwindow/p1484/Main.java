package com.backjoon.slidingwindow.p1484;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 백준 1484번 : 다이어트
 *
 * @author 송훤출
 * @since 20.04.08
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int g = Integer.parseInt(in.nextLine());

        List<Integer> result = solve(g);
        for (int weight : result) {
            System.out.println(weight);
        }
    }

    public static List<Integer> solve(int g) {
        List<Integer> result = new ArrayList<>();

        int start = 1;
        int end = 1;
        int sum = 0;

        while (end < g) {
            if (sum < g) {
                end++;
            } else {
                start++;
            }
            sum = calculateWeight(end, start);

            if (sum == g) {
                result.add(end);
            }
        }

        return result.size() > 0 ? result
                : Collections.singletonList(-1);
    }

    private static int calculateWeight(int current, int pre) {
        return (int) (Math.pow(current, 2) - Math.pow(pre, 2));
    }
}
