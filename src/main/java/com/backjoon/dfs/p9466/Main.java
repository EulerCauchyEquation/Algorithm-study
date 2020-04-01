package com.backjoon.dfs.p9466;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 백준 9466번 : 텀 프로젝트
 *
 * @author 송훤출
 * @since 20.03.31
 */
public class Main {
    static int[] mWanted;
    static boolean[] visited;
    static boolean hasTeam;
    static int result;

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
        visited = new boolean[wanted.length];
        result = 0;

        for (int studentNo = 1; studentNo < wanted.length; studentNo++) {
            Arrays.fill(visited, false);
            visited[studentNo] = true;
            hasTeam = false;

            dfs(mWanted[studentNo], studentNo);
            result = hasTeam ? result
                    : (result += 1);
        }

        return result;
    }

    private static void dfs(int studentNo, int wantedNo) {
        if (studentNo == wantedNo) {
            hasTeam = true;
            return;
        }

        if (visited[studentNo]) {
            return;
        }

        visited[studentNo] = true;
        dfs(mWanted[studentNo], wantedNo);
    }
}
