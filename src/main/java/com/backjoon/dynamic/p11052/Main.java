package com.backjoon.dynamic.p11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 11052 : 카드 구매하기
 *
 * @author 송훤출
 * @since 20.03.30
 */
public class Main {
    static final int NOT_VISITED = -1;

    static int[] cardPackPrices;
    static int[][] memo;

    public static void main(String[] args) {
        int[] cardPack = createCardPack();
        System.out.println(solve(cardPack));
    }

    private static int[] createCardPack() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(in.readLine());
            int[] cardPack = new int[n];

            String line = in.readLine();
            StringTokenizer stk = new StringTokenizer(line);
            for (int cardNo = 0; cardNo < cardPack.length; cardNo++) {
                cardPack[cardNo] = Integer.parseInt(stk.nextToken());
            }
            return cardPack;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static int solve(int[] cardPack) {
        cardPackPrices = cardPack.clone();
        int cardCnt = cardPackPrices.length;
        memo = new int[cardCnt + 1][cardCnt + 1];
        for (int[] m : memo) {
            Arrays.fill(m, NOT_VISITED);
        }

        return dfs(1, cardCnt);
    }

    private static int dfs(int cardNo, int cardCnt) {
        if (cardNo > cardPackPrices.length) {
            return 0;
        }
        if (memo[cardNo][cardCnt] != NOT_VISITED) {
            return memo[cardNo][cardCnt];
        }

        int buy = 0;
        if (cardNo <= cardCnt) {
            buy = dfs(cardNo, cardCnt - cardNo) + cardPackPrices[cardNo - 1];
        }
        int pass = dfs(cardNo + 1, cardCnt);
        memo[cardNo][cardCnt] = Math.max(buy, pass);

        return memo[cardNo][cardCnt];
    }
}
