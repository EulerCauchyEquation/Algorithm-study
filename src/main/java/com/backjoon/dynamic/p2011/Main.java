package com.backjoon.dynamic.p2011;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static final int CORRECTION_FACTOR = 1000000;
    static int[] memo;
    static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        map.put("4", "D");
        map.put("5", "E");
        map.put("6", "F");
        map.put("7", "G");
        map.put("8", "H");
        map.put("9", "I");
        map.put("10", "J");
        map.put("11", "K");
        map.put("12", "L");
        map.put("13", "M");
        map.put("14", "N");
        map.put("15", "O");
        map.put("16", "P");
        map.put("17", "Q");
        map.put("18", "R");
        map.put("19", "S");
        map.put("20", "T");
        map.put("21", "U");
        map.put("22", "V");
        map.put("23", "W");
        map.put("24", "X");
        map.put("25", "Y");
        map.put("26", "Z");
    }

    public static void main(String[] args) {
        String line = createString();
        System.out.println(solve(line));
    }

    private static String createString() {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();
        return line;
    }

    public static int solve(String value) {
        int n = value.length();
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return util(n, value) % CORRECTION_FACTOR;
    }

    private static int util(int n, String line) {
        if (n == 0) {
            memo[n] = 1;
        }
        if (n == 1) {
            memo[1] = (line.charAt(0) != '0') ? 1 : 0;
        }
        if (memo[n] > -1) {
            return memo[n];
        }
        memo[n] = (map.containsKey(line.substring(n - 1, n)) ? util(n - 1, line) : 0) % CORRECTION_FACTOR +
                (map.containsKey(line.substring(n - 2, n)) ? util(n - 2, line) : 0) % CORRECTION_FACTOR;
        return memo[n];
    }
}
