package com.backjoon.dynamic.p2302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2302번 : 극장 좌석
 *
 * @author 송훤출
 * @since 20.03.08
 */
public class Main {
    static final int VIP_SEAT = -1;
    static long[] memo;

    public static void main(String[] args) {
        int seats;
        int[] vips;
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            seats = Integer.parseInt(in.readLine());
            int n = Integer.parseInt(in.readLine());
            vips = new int[n];
            for (int i = 0; i < n; i++) {
                vips[i] = Integer.parseInt(in.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }

        System.out.println(solve(seats, vips));
    }

    public static long solve(int totalSeat, int[] vip) {
        long[] seats = new long[totalSeat + 1];
        for (int i : vip) {
            seats[i] = VIP_SEAT;
        }
        memo = new long[seats.length];
        return util(totalSeat, seats);
    }

    private static long util(int n, long[] seats) {
        if (n <= 1) {
            memo[n] = 1;
        }
        if (memo[n] > 0) {
            return memo[n];
        }

        memo[n] = util(n - 1, seats);
        if ((seats[n] != VIP_SEAT) && (seats[n - 1] != VIP_SEAT)) {
            memo[n] += util(n - 2, seats);
        }
        return memo[n];
    }
}
