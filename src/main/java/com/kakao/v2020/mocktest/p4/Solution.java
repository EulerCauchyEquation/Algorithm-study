package com.kakao.v2020.mocktest.p4;

import java.util.HashMap;
import java.util.Map;

/**
 * 카카오 2020 인턴 모의고사 : 문제 4번
 *
 * @author 송훤출
 * @since 20.03.28
 */
public class Solution {
    static RoomInfo roomInfo;
    static long[] result;
    static long roomCnt;

    public static long[] solution(long k, long[] room_number) {
        roomInfo = new RoomInfo();
        result = new long[room_number.length];
        roomCnt = k;

        for (int guestNo = 0; guestNo < room_number.length; guestNo++) {
            long wantedRoomNo = room_number[guestNo];
            long nextRoomNo = wantedRoomNo + roomInfo.getRoomCount(wantedRoomNo);

            assignRoom(guestNo, nextRoomNo);
        }

        return result;
    }

    private static void assignRoom(int guestNo, long nextRoomNo) {
        for (long roomNo = nextRoomNo; roomNo <= roomCnt; roomNo++) {
            if (roomInfo.isEmptyRoom(roomNo)) {
                roomInfo.assign(roomNo);
                result[guestNo] = roomNo;
                break;
            }
            roomInfo.updateRoomInfo(roomNo);
        }
    }

    static class RoomInfo {
        private Map<Long, Integer> roomAssignment;

        public RoomInfo() {
            this.roomAssignment = new HashMap<>();
        }

        public boolean isEmptyRoom(long roomNo) {
            return !roomAssignment.containsKey(roomNo);
        }

        public void assign(long roomNo) {
            roomAssignment.put(roomNo, 1);
        }

        public void updateRoomInfo(long roomNo) {
            roomAssignment.put(roomNo, roomAssignment.get(roomNo) + 1);
        }

        public int getRoomCount(long roomNo) {
            return (roomAssignment.get(roomNo) == null) ? 0
                    : roomAssignment.get(roomNo);
        }
    }
}
