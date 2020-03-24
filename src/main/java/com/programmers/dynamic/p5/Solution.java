package com.programmers.dynamic.p5;

import java.util.Arrays;

/**
 * 프로그래머스 : 카드게임( 동적 계획법 )
 *
 * @author 송훤출
 * @since 20.03.24
 */
public class Solution {
    static final int NOT_VISITED = -1;

    static int[][] memo;

    public static int solution(int[] left, int[] right) {
        memo = new int[left.length][right.length];
        for (int[] m : memo) {
            Arrays.fill(m, NOT_VISITED);
        }

        return dfs(0, 0, left, right);
    }

    private static int dfs(int leftIndex, int rightIndex, int[] left, int[] right) {
        if ((leftIndex == left.length) || (rightIndex == right.length)) {
            return 0;
        }
        if (memo[leftIndex][rightIndex] != NOT_VISITED) {
            return memo[leftIndex][rightIndex];
        }

        int childScore = 0;
        for (Action act : Action.values()) {
            int nextLeft = leftIndex + act.nextLeft;
            int nextRight = rightIndex + act.nextRight;
            int score = act.isRightDestroy() ? right[rightIndex] : 0;

            if (isValid(left[leftIndex], right[rightIndex], act)) {
                childScore = Math.max(
                        dfs(nextLeft, nextRight, left, right) + score,
                        childScore);
            }
        }
        memo[leftIndex][rightIndex] = childScore;
        return memo[leftIndex][rightIndex];
    }

    private static boolean isValid(int leftValue, int rightValue, Action action) {
        if (action.isRightDestroy()) {
            return leftValue > rightValue;
        }
        return true;
    }

    enum Action {
        LEFT_DESTROY(1, 0),
        RIGHT_DESTROY(0, 1),
        ALL_DESTROY(1, 1);

        int nextLeft;
        int nextRight;

        Action(int nextLeft, int nextRight) {
            this.nextLeft = nextLeft;
            this.nextRight = nextRight;
        }

        private boolean isRightDestroy() {
            return (this.nextLeft == Action.RIGHT_DESTROY.nextLeft)
                    && (this.nextRight == Action.RIGHT_DESTROY.nextRight);
        }
    }
}
