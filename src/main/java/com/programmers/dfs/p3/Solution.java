package com.programmers.dfs.p3;

/**
 * 프로그래머스 : 단어변환 (DFS/BFS)
 *
 * @author 송훤출
 * @since 20.03.31
 */
public class Solution {
    static boolean[] visited;
    static int result;

    static String mTarget;
    static String[] mWords;

    public static int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        result = Integer.MAX_VALUE;

        mTarget = target;
        mWords = words.clone();

        dfs(begin, 0);

        return (result == Integer.MAX_VALUE) ? 0 : result;
    }

    private static void dfs(String here, int stepCnt) {
        if (here.equals(mTarget)) {
            result = Math.min(result, stepCnt);
            return;
        }

        for (int i = 0; i < mWords.length; i++) {
            String next = mWords[i];

            if (!visited[i] && canBeConverted(here, next)) {
                visited[i] = true;
                dfs(mWords[i], stepCnt + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean canBeConverted(String src, String dst) {
        int count = 0;
        for (int i = 0; i < src.length(); i++) {
            if (src.charAt(i) == dst.charAt(i)) {
                count++;
            }
        }

        return count == dst.length() - 1;
    }
}
