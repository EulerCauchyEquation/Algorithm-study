package com.backjoon.dynamic.p11053;

import java.util.*;

/**
 * 백준 11053 : LIS
 *
 * @author 송훤출
 * @since 20.04.03
 */
public class Main {
    static int[] mSequence;
    static int[][] memo;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[] sequence = new int[n];

        String line = in.nextLine();
        StringTokenizer stk = new StringTokenizer(line);

        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(stk.nextToken());
        }

        System.out.println(solve(sequence));
    }

    public static int solve(int[] sequence) {
        mSequence = sequence.clone();
        memo = new int[sequence.length][1001];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        //  return dfs(0, 0);
        return LIS(sequence);
    }

    private static int dfs(int n, int standard) {
        if (n == mSequence.length) {
            return 0;
        }
        if (memo[n][standard] != -1) {
            return memo[n][standard];
        }

        int selectCase = 0;
        if (standard < mSequence[n]) {
            selectCase = dfs(n + 1, mSequence[n]) + 1;
        }
        int skipCase = dfs(n + 1, standard);
        memo[n][standard] = Math.max(selectCase, skipCase);

        return memo[n][standard];
    }

    private static int LIS(int[] sequence) {
        List<Integer> list = new ArrayList<>();
        list.add(sequence[0]);

        for (int index = 1; index < sequence.length; index++) {
            if (sequence[index] <= list.get(list.size() - 1)) {
                int temp = binarySearch(0, list.size() - 1, sequence[index], list);
                list.set(temp, sequence[index]);
            } else {
                list.add(sequence[index]);
            }
        }

        return list.size();
    }

    public static int binarySearch(int begin, int end, int key, List<Integer> list) {
        int left = begin;
        int right = end;

        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (key < list.get(mid)) {
                right = mid - 1;
            } else if (list.get(mid) < key) {
                left = mid + 1;
            } else {
                result = mid;
                break;
            }
            result = mid;
        }

        return result;
    }
}
