package com.backjoon.backtrack.p1339;

import java.util.*;

/**
 * 백준 1339 : 단어 수학
 *
 * @author 송훤출
 * @since 20.03.16
 */
public class Main {
    static final int NOT_VISITED = -1;

    static List<Character> alphabetInfo;
    static Map<Character, Integer> numberMap;
    static long result;

    public static void main(String[] args) {
        String[] words = createWords();
        System.out.println(solve(words));
    }

    private static String[] createWords() {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = in.nextLine();
        }
        return words;
    }

    public static long solve(String[] words) {
        Set<Character> set = new HashSet<>();
        for (String word : words) {
            for (char alphabet : word.toCharArray()) {
                set.add(alphabet);
            }
        }
        alphabetInfo = new ArrayList<>(set);
        numberMap = new HashMap<>();
        result = 0;

        backtrack(0, words);
        return result;
    }

    private static void backtrack(int level, String[] words) {
        if (level == alphabetInfo.size()) {
            int newResult = mapping(words);
            result = Math.max(result, newResult);
            return;
        }

        for (int childValue = 0; childValue <= 9; childValue++) {
            char childKey = alphabetInfo.get(level);
            if (isPromisingNode(childValue)) {
                numberMap.put(childKey, childValue);
                backtrack(level + 1, words);
                numberMap.put(childKey, NOT_VISITED);
            }
        }
    }

    private static boolean isPromisingNode(int child) {
        return !numberMap.containsValue(child);
    }

    private static int mapping(String[] words) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.setLength(0);
            for (char alphabet : word.toCharArray()) {
                sb.append(numberMap.get(alphabet));
            }
            sum += Long.parseLong(sb.toString());
        }
        return sum;
    }
}
