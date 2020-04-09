package com.kakao.v2018.codingtest.secretmap;

/**
 * 카카오 2018 코딩테스트 : 비밀지도
 *
 * @author 송훤출
 * @since 20.04.09
 */
public class Solution {

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        String format = "%" + n + "s";

        for (int i = 0; i < n; i++) {
            int line1 = arr1[i];
            int line2 = arr2[i];

            String newLine = String
                    .format(format, Integer.toBinaryString(line1 | line2))
                    .replaceAll("[1]", "#")
                    .replaceAll("[0]", " ");

            result[i] = newLine;
        }

        return result;
    }
}
