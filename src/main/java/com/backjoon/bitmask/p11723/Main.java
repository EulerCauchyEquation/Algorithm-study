package com.backjoon.bitmask.p11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 11723 : 집합
 *
 * @author 송훤출
 * @since 20.04.10
 */
public class Main {
    static int value = 0;

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(in.readLine());

            for (int i = 0; i < n; i++) {
                String command = in.readLine();
                solve(command);
            }

        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void solve(String command) {
        String[] com = command.split(" ");
        String commandLanguage = com[0];
        int x = (com.length == 2) ? Integer.parseInt(com[1])
                : 0;
        x = 1 << x;

        switch (commandLanguage) {
            case "add":
                value = value | x;
                break;
            case "remove":
                value = value & ~x;
                break;
            case "check":
                System.out.println(((value & x) == 0) ? 0 : 1);
                break;
            case "toggle":
                value = value ^ x;
                break;
            case "all":
                value = (1 << 21) - 1;
                break;
            case "empty":
                value = 0;
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
