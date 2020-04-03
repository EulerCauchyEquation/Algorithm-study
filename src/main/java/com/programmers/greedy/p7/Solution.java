package com.programmers.greedy.p7;

import java.util.Arrays;

/**
 * 프로그래머스 : 저울 (greed)
 *
 * @author 송훤출
 * @since 20.04.03
 */
public class Solution {

    public static int solution(int[] weights) {
        Arrays.sort(weights);
        int maxMeasurableValue = 0;

        for (int weight : weights) {
            if (maxMeasurableValue + 1 < weight) {
                break;
            }
            maxMeasurableValue += weight;
        }

        return maxMeasurableValue + 1;
    }
}
