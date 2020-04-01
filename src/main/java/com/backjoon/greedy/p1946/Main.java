package com.backjoon.greedy.p1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 백준 1946번 : 신입 사원
 *
 * @author 송훤출
 * @since 20.04.01
 */
public class Main {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int caseCnt;
        int[][] ranks;
        try {
            caseCnt = Integer.parseInt(in.readLine());

            for (int i = 0; i < caseCnt; i++) {
                int n = Integer.parseInt(in.readLine());
                ranks = new int[n][2];

                for (int j = 0; j < n; j++) {
                    String line = in.readLine();
                    StringTokenizer stk = new StringTokenizer(line);
                    ranks[j][0] = Integer.parseInt(stk.nextToken());
                    ranks[j][1] = Integer.parseInt(stk.nextToken());
                }
                System.out.println(solve(ranks));
            }

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static int solve(int[][] ranks) {
        Queue<Rank> rankQueue = Arrays.stream(ranks)
                .map(rank -> new Rank(rank[0], rank[1]))
                .sorted(Rank::compareTo)
                .collect(Collectors.toCollection(LinkedList::new));
        Rank pre = rankQueue.poll();
        int result = 0;

        while (!rankQueue.isEmpty()) {
            Rank rank = rankQueue.poll();

            if (pre.interview > rank.interview) {
                pre = rank;
                result++;
            }
        }

        return result + 1;
    }

    static class Rank implements Comparable<Rank> {
        int document;
        int interview;

        public Rank(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }

        @Override
        public int compareTo(Rank o) {
            return document - o.document;
        }
    }
}
