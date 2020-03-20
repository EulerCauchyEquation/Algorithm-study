package com.backjoon.greedy.p1541;

import java.util.Scanner;

/**
 * 백준 1541 : 잃어버린 괄호
 *
 * @author 송훤출
 * @since 20.03.20
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        System.out.println(solve(line));
        in.close();
    }

    public static int solve(String line) {
        String[] split = line.split("-");

        int sum = 0;
        for (int i = 0; i < split.length; i++) {
            int num = calculate(split[i]);
            if (i == 0) {
                num *= -1;
            }
            sum -= num;
        }

        return sum;
    }

    private static int calculate(String line) {
        String[] split = line.split("\\+");

        int sum = 0;
        for (String value : split) {
            if (value.length() > 0) {
                sum += Integer.parseInt(value);
            }
        }
        return sum;
    }
}
