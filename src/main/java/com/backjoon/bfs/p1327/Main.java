package com.backjoon.bfs.p1327;

import java.util.*;

/**
 * 백준 1327번 : 소트 게임
 *
 * @author 송훤출
 * @since 20.04.10
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();
        StringTokenizer stk = new StringTokenizer(line);

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int[] sequence = new int[n];
        line = in.nextLine();
        stk = new StringTokenizer(line);

        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(stk.nextToken());
        }

        System.out.println(solve(sequence, k));
    }

    public static int solve(int[] sequence, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= sequence.length; i++) {
            sb.append(i);
        }
        String target = sb.toString();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(
                Arrays.toString(sequence).replaceAll("[^0-9]", ""),
                -1
                , 0));

        while (!queue.isEmpty()) {
            Node here = queue.poll();

            if (here.vertex.equals(target)) {
                return here.cnt;
            }

            for (int i = 0; i <= sequence.length - k; i++) {
                if (i != here.index) {
                    String vertex = turnString(i, k, here.vertex);

                    queue.offer(new Node(vertex, i, here.cnt + 1));
                }
            }
        }
        return 0;
    }

    private static String turnString(int start, int k, String vertex) {
        String subString = new StringBuilder(vertex.substring(start, start + k))
                .reverse()
                .toString();

        return vertex.substring(0, start)
                + subString + vertex.substring(start + k);
    }

    static class Node {
        String vertex;
        int index;
        int cnt;

        public Node(String vertex, int index, int cnt) {
            this.vertex = vertex;
            this.index = index;
            this.cnt = cnt;
        }
    }
}
