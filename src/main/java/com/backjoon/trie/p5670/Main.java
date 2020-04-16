package com.backjoon.trie.p5670;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 백준 5670 : 휴대폰 자판
 *
 * @author 송훤출
 * @since 20.04.15
 */
public class Main {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;

        try {
            while ((line = in.readLine()) != null) {
                int n = Integer.parseInt(line);
                String[] words = new String[n];

                for (int i = 0; i < n; i++) {
                    words[i] = in.readLine();
                }
                System.out.println(solve(words));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public static String solve(String[] words) {
        double answer = 0;
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        for (String word : words) {
            answer += trie.search(word);
        }

        answer = answer / words.length;
        return String.format("%.2f", answer);
    }

    static class Trie {

        private TrieNode root;

        public Trie() {
            this.root = new TrieNode('#');
        }

        public void insert(String word) {
            TrieNode current = root;

            for (char ch : word.toCharArray()) {
                current = getChildNode(current, ch);
            }

            current.isLeafNode = true;
        }

        private TrieNode getChildNode(TrieNode cur, char ch) {
            if (cur.childMap.containsKey(ch)) {
                return cur.childMap.get(ch);
            }

            TrieNode newNode = new TrieNode(ch);
            cur.childMap.put(ch, newNode);
            return newNode;
        }

        public int search(String word) {
            int count = 0;
            TrieNode current = root;

            for (char ch : word.toCharArray()) {
                current = getChildNode(current, ch);

                if (current.childMap.size() > 1 || current.isLeafNode) {
                    count++;
                }
            }

            return count;
        }

        static class TrieNode {
            private char ch;
            private boolean isLeafNode;
            private Map<Character, TrieNode> childMap;

            public TrieNode(char ch) {
                this.ch = ch;
                this.isLeafNode = false;
                this.childMap = new HashMap<>();
            }
        }
    }
}
