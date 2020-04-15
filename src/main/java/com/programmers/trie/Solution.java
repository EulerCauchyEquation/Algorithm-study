package com.programmers.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 프로그래머스 : 전화번호 목록
 *
 * @author 송훤출
 * @since 20.04.15
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            int nn = Integer.parseInt(in.nextLine());
            String[] phones = new String[nn];

            for (int j = 0; j < nn; j++) {
                phones[j] = in.nextLine();
            }
            boolean result = solution(phones);

            System.out.println(result ? "YES" : "NO");
        }

        in.close();
    }

    public static boolean solution(String[] phone_book) {
        Trie trie = new Trie();

        for (String phone : phone_book) {
            trie.insert(phone);

            if (trie.validate(phone)) {
                return false;
            }
        }

        return true;
    }

    static class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode('#');
        }

        public void insert(String word) {
            TrieNode cur = root;

            for (char ch : word.toCharArray()) {
                cur = getChildNode(cur, ch);
            }

            cur.isLeafNode = true;
        }

        private TrieNode getChildNode(TrieNode node, char ch) {
            if (node.childNodes.containsKey(ch)) {
                return node.childNodes.get(ch);
            }

            TrieNode newNode = new TrieNode(ch);
            node.childNodes.put(ch, newNode);
            return newNode;
        }

        public boolean validate(String phone) {
            TrieNode cur = root;

            for (int i = 0; i < phone.length(); i++) {
                TrieNode child = getChildNode(cur, phone.charAt(i));

                if ((i != phone.length() - 1) && child.isLeafNode) {
                    return true;
                }

                cur = child;
            }

            return cur.childNodes.size() > 0;
        }

        static class TrieNode {

            private char ch;
            private boolean isLeafNode;
            private Map<Character, TrieNode> childNodes;

            public TrieNode(char ch) {
                this.ch = ch;
                this.isLeafNode = false;
                this.childNodes = new HashMap();
            }
        }
    }
}
