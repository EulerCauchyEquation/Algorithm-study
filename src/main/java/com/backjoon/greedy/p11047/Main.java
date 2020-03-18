package com.backjoon.greedy.p11047;

import java.util.*;

/**
 * 백준 11047 : 동전 0
 *
 * @author 송훤출
 * @since 20.03.18
 */
public class Main {
    static boolean hasSolved;
    static int result;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        StringTokenizer stk = new StringTokenizer(line);
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        Integer[] coinType = new Integer[n];
        for (int i = 0; i < n; i++) {
            coinType[i] = Integer.parseInt(in.nextLine());
        }

        System.out.println(solve(coinType, k));
    }

    public static int solve(Integer[] coinType, int k) {
        hasSolved = false;
        result = Integer.MAX_VALUE;
        Arrays.sort(coinType, Comparator.reverseOrder());

        //dfs(0, k, coinType);
        //return result;
        return dfs2(k, coinType);
    }

    private static void dfs(int level, int sum, Integer[] coinType) {
        if (sum == 0) {
            hasSolved = true;
            result = Math.min(result, level);
            return;
        }
        for (int coin : coinType) {
            if (isValidCoin(sum, coin)) {
                dfs(level + 1, sum - coin, coinType);
                if (hasSolved) {
                    return;
                }
            }
        }
    }

    private static int dfs2(int k, Integer[] coinType) {
        int count = 0;
        for (int coin : coinType) {
            if (k >= coin) {
                count += k / coin;
                k = k % coin;
            }
        }
        return count;
    }

    private static boolean isValidCoin(int parent, int coin) {
        return parent - coin >= 0;
    }
}
