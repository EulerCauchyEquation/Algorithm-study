package com.backjoon.dynamic.p1987;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 백준 1987번 : 알파벳
 *
 * @author 송훤출
 * @since 20.03.11
 */
public class Main {
    static boolean[][] visited;
    static Map<Character, Character> map = new HashMap<>();
    static int moveCnt = 0;
    static int result = 0;

    public static void main(String[] args) {
        char[][] board = createBoard();
        System.out.println(solve(board));
    }

    private static char[][] createBoard() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        StringTokenizer stk = new StringTokenizer(input);
        int r = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());
        char[][] board = new char[r][c];
        for (int i = 0; i < board.length; i++) {
            input = in.nextLine();
            for (int j = 0; j < input.length(); j++) {
                board[i][j] = input.charAt(j);
            }
        }
        return board;
    }

    public static int solve(char[][] board) {
        visited = new boolean[board.length][board[0].length];
        dfs(0, 0, board);
        return result;
    }

    private static void dfs(int x, int y, char[][] board) {
        if (moveCnt == 26) {
            // 알파벳 총 개수를 넘지 못한다.. 문제 조건 상
            return;
        }

        visited[x][y] = true;
        map.put(board[x][y], board[x][y]);
        moveCnt++;
        result = Math.max(result, moveCnt);

        for (Direction dir : Direction.values()) {
            int nx = x + dir.x;
            int ny = y + dir.y;
            if (isMovable(nx, ny, board)) {
                dfs(nx, ny, board);
            }
        }
        visited[x][y] = false;
        map.remove(board[x][y]);
        moveCnt--;
    }

    private static boolean isMovable(int nx, int ny, char[][] board) {
        if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) {
            return false;
        }
        if (visited[nx][ny]) {
            return false;
        }
        return !map.containsKey(board[nx][ny]);
    }

    enum Direction {
        UP(-1, 0),
        DOWN(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1);

        int x;
        int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

