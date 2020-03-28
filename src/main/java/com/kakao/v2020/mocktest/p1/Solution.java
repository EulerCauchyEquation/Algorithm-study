package com.kakao.v2020.mocktest.p1;

import java.util.Stack;

/**
 * 카카오 2020 인턴 모의고사 : 문제 1번
 *
 * @author 송훤출
 * @since 20.03.28
 */
public class Solution {
    static final int EMPTY = 0;

    static Stack<Integer> basket;
    static int[][] boardInfo;

    public static int solution(int[][] board, int[] moves) {
        basket = new Stack<>();
        boardInfo = board.clone();
        int destroyedProductCnt = 0;

        for (int rowNo : moves) {
            int productNo = putThingUpIn(rowNo);

            if (productNo == EMPTY) {
                // 그 열에 물건이 없음
            } else if (basket.isEmpty()) {
                basket.push(productNo);
            } else if (basket.peek() == productNo) {
                // 바구니 상단의 물건과 타입이 같다면
                basket.pop();
                destroyedProductCnt += 2;

            } else {
                // 다르다면 삽입. (단, 물건이 있다는 가정하)
                basket.push(productNo);
            }
        }

        return destroyedProductCnt;
    }

    private static int putThingUpIn(int rowNo) {
        rowNo--;
        int productNo = EMPTY;
        for (int i = 0; i < boardInfo.length; i++) {
            if (boardInfo[i][rowNo] > 0) {
                productNo = boardInfo[i][rowNo];
                boardInfo[i][rowNo] = EMPTY;
                break;
            }
        }
        return productNo;
    }
}
