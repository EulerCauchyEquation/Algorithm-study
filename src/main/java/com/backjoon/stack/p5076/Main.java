package com.backjoon.stack.p5076;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * 백준 5076 : Web Pages
 *
 * @author 송훤출
 * @since 20.04.13
 */
public class Main {

    public static void main(String[] args) {
        String[] webPages = createWebPages();
        String[] result = solve(webPages);

        for (String output : result) {
            System.out.println(output);
        }
    }

    private static String[] createWebPages() {
        Scanner in = new Scanner(System.in);

        List<String> webPages = new ArrayList<>();
        while (true) {
            String line = in.nextLine();
            if (line.equals("#")) {
                break;
            }

            webPages.add(line);
        }

        return webPages.stream().toArray(String[]::new);
    }

    public static String[] solve(String[] webPages) {
        String[] result = new String[webPages.length];

        for (int i = 0; i < webPages.length; i++) {
            if (webPages[i].charAt(0) != '<') {
                result[i] = "legal";
            } else {
                String[] tags = Stream.of(webPages[i].split("(>[^<]*<(/)?)|[<>]"))
                        .map(str -> str.replaceAll("(\\s[^/]\\S+)|(\\S+ /)", ""))
                        .filter(str -> str.length() > 0)
                        .toArray(String[]::new);

                result[i] = analyze(tags);
            }
        }

        return result;
    }

    private static String analyze(String[] tags) {
        Stack<String> stack = new Stack<>();

        for (String tag : tags) {
            if (stack.isEmpty() || !stack.peek().equals(tag)) {
                stack.push(tag);
            } else {
                stack.pop();
            }
        }

        return stack.size() == 0 ? "legal" : "illegal";
    }
}
