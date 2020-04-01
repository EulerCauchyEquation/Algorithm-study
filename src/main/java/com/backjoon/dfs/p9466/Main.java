package com.backjoon.dfs.p9466;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 백준 9466번 : 텀 프로젝트
 *
 * @author 송훤출
 * @since 20.03.31
 */
public class Main {
    static final int NOT_VISITED = 0;
    static final int SEARCHING = 1;
    static final int FINISHED = 2;
    static final int CYCLE = 3;

    static int[] mWanted;

    static int[] visited;
    static boolean[] cycle;
    static int cycleVertex;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int caseCnt = Integer.parseInt(in.nextLine());
        for (int i = 0; i < caseCnt; i++) {
            int n = Integer.parseInt(in.nextLine());
            int[] wanted = new int[n + 1];

            String line = in.nextLine();
            StringTokenizer stk = new StringTokenizer(line);

            for (int j = 1; j < wanted.length; j++) {
                wanted[j] = Integer.parseInt(stk.nextToken());
            }
            System.out.println(solve(wanted));
        }
    }

    public static int solve(int[] wanted) {
        mWanted = wanted.clone();
        visited = new int[wanted.length];
        cycle = new boolean[wanted.length];
        cycleVertex = 0;

        for (int studentNo = 1; studentNo < wanted.length; studentNo++) {
            dfs(mWanted[studentNo]);
        }

        return (wanted.length - 1) - cycleVertex;
    }

    private static void dfs(int here) {
        if (visited[here] == FINISHED) {
            return;
        }
        if (visited[here] == CYCLE) {
            return;
        }

        if (visited[here] == SEARCHING) {
            visited[here] = CYCLE;
            cycleVertex++;
        } else if (visited[here] == NOT_VISITED) {
            visited[here] = SEARCHING;
        }

        dfs(mWanted[here]);
        visited[here] = FINISHED;
    }
}
