package com.backjoon.greedy.p1120;

import java.util.Scanner;

/**
 * 백준 1120 : 문자열
 *
 * @author 송훤출
 * @since 20.03.20
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] stringList = line.split(" ");

        System.out.println(solve(stringList));
        in.close();
    }

    public static int solve(String[] stringList) {
        String strA = stringList[0];
        String strB = stringList[1];

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= strB.length() - strA.length(); i++) {
            answer = Math.min(answer, difference(i, strA, strB));
        }
        return answer;
    }

    private static int difference(int index, String strA, String strB) {
        int difference = 0;
        for (int i = 0; i < strA.length(); i++) {
            if (strA.charAt(i) != strB.charAt(i + index)) {
                difference++;
            }
        }
        return difference;
    }
}
