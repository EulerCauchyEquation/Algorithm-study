package com.backjoon.greedy.p2352;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 백준 2352 : 반도체 설계 *
 *
 * @author 송훤출
 * @since 20.04.03
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[] connections = new int[n];

        String line = in.nextLine();
        StringTokenizer stk = new StringTokenizer(line);

        for (int i = 0; i < n; i++) {
            connections[i] = Integer.parseInt(stk.nextToken());
        }

        System.out.println(solve(connections));
    }

    public static int solve(int[] connections) {
        return LIS(connections);
    }

    private static int LIS(int[] connections) {
        List<Integer> list = new ArrayList<>();
        list.add(connections[0]);

        for (int i = 1; i < connections.length; i++) {
            int last = list.get(list.size() - 1);

            if (connections[i] < last) {
                int temp = lower_bound(0, list.size(), connections[i], list);
                list.set(temp, connections[i]);
            } else {
                list.add(connections[i]);
            }
        }

        return list.size();
    }

    public static int lower_bound(int begin, int end, int key, List<Integer> list) {
        int left = begin;
        int right = end - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (key <= list.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
