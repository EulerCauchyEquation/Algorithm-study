package com.backjoon.stack.p2493;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        int[] tops = createTops();
        int[] result = solve(tops);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }
    }

    private static int[] createTops() {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[] tops = new int[n];

        String line = in.nextLine();
        StringTokenizer stk = new StringTokenizer(line);
        for (int i = 0; i < tops.length; i++) {
            tops[i] = Integer.parseInt(stk.nextToken());
        }

        return tops;
    }

    public static int[] solve(int[] tops) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] result = new int[tops.length];

        for (int i = 1; i < tops.length; i++) {
            int top = tops[i];

            while (!stack.isEmpty()) {
                int recentlyReceivedTop = tops[stack.peek()];

                if (top <= recentlyReceivedTop) {
                    break;
                }

                stack.pop();
            }

            result[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }

        return result;
    }
}
