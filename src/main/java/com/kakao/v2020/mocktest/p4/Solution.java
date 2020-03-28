package com.kakao.v2020.mocktest.p4;

import java.util.HashSet;
import java.util.Set;

/**
 * 카카오 2020 인턴 모의고사 : 문제 4번
 *
 * @author 송훤출
 * @since 20.03.28
 */
public class Solution {
    static Set<Long> roomAssignment;

    public static long[] solution(long k, long[] room_number) {
        roomAssignment = new HashSet<>();
        long[] guestRoomInfo = new long[room_number.length];

        for (int guestNo = 0; guestNo < room_number.length; guestNo++) {
            long wantedRoomNo = room_number[guestNo];

            if (!roomAssignment.contains(wantedRoomNo)) {
                // 1.1 손님이 원하는 방이 비어 있다면
                roomAssignment.add(wantedRoomNo);
                guestRoomInfo[guestNo] = wantedRoomNo;
            } else {
                // 1.2 이미 투숙중이면
                for (long otherRoomNo = wantedRoomNo + 1; otherRoomNo <= k; otherRoomNo++) {
                    if (!roomAssignment.contains(otherRoomNo)) {
                        roomAssignment.add(otherRoomNo);
                        guestRoomInfo[guestNo] = otherRoomNo;
                        break;
                    }
                }
            }
        }

        return guestRoomInfo;
    }
}
