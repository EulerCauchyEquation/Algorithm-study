package com.kakao.v2019.codingtest.failure;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 2019 KAKAO 블라인드 코딩 테스트 : 실패율
 *
 * @author 송훤출
 * @since 20.05.20
 */
public class Solution {
    public static int[] solution(int n, int[] stages) {
        final Map<Integer, Integer> stageMap = new LinkedHashMap<>();
        for (int i = n + 1; i >= 1; i--) {
            stageMap.put(i, 0);
        }
        for (int stage : stages) {
            stageMap.put(stage, stageMap.get(stage) + 1);
        }
        Result[] answer = new Result[n];
        int tryingPlayers = 0;
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : stageMap.entrySet()) {
            tryingPlayers += entry.getValue();
            final double failure = tryingPlayers == 0 ? 0
                    : (double) entry.getValue() / tryingPlayers;
            if (entry.getKey() == n + 1) {
                continue;
            }
            answer[i++] = new Result(entry.getKey(), failure);
        }
        Arrays.sort(answer);
        int[] ans = new int[answer.length];
        for (int j = 0; j < ans.length; j++) {
            ans[j] = answer[j].stage;
        }
        return ans;
    }

    private static class Result implements Comparable<Result> {
        int stage;
        double failure;

        Result(int stage, double failure) {
            this.stage = stage;
            this.failure = failure;
        }

        @Override
        public int compareTo(Result o) {
            return this.failure == o.failure
                    ? this.stage - o.stage
                    : Double.compare(o.failure, this.failure);
        }
    }
}
