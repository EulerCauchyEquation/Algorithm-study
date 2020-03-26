package com.programmers.dynamic.p7;

import java.util.Arrays;

/**
 * 프로그래머스 : 서울에서 경산까지 ( 동적 계획법 )
 *
 * @author 송훤출
 * @since 20.03.26
 */
public class Solution {
    static final int NOT_VISITED = -1;

    static int[][] memo;
    static int[][] travelInfo;


    public static int solution(int k, int[][] travel) {
        int n = travel.length;
        memo = new int[travel.length][k + 1];
        for (int[] m : memo) {
            Arrays.fill(m, NOT_VISITED);
        }
        travelInfo = travel;

        return dfs(n - 1, k);
    }

    private static int dfs(int n, int availableTime) {
        if (n < 0) {
            return 0;
        }
        if (memo[n][availableTime] != NOT_VISITED) {
            return memo[n][availableTime];
        }

        int collection = 0;
        for (TravelCase tCase : TravelCase.values()) {
            int time = travelInfo[n][tCase.timeIdx];
            int money = travelInfo[n][tCase.moneyIdx];

            if (isValid(time, availableTime)) {
                collection = Math.max(
                        collection,
                        dfs(n - 1, availableTime - time) + money);
            }
        }

        memo[n][availableTime] = collection;
        return memo[n][availableTime];
    }

    private static boolean isValid(int time, int availableTime) {
        return time <= availableTime;
    }

    enum TravelCase {
        WALKING(0, 1),
        BICYCLE(2, 3);

        int timeIdx;
        int moneyIdx;

        TravelCase(int timeIdx, int moneyIdx) {
            this.timeIdx = timeIdx;
            this.moneyIdx = moneyIdx;
        }
    }
}
