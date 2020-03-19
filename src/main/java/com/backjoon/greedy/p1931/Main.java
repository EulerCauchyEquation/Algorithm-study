package com.backjoon.greedy.p1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1931: 회의실배정
 *
 * @author 송훤출
 * @since 20.03.19
 */
public class Main {

    public static void main(String[] args) {
        int[][] meetings = createMeetings();
        System.out.println(solve(meetings));
    }

    private static int[][] createMeetings() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(in.readLine());
            int[][] meetings = new int[n][2];
            for (int i = 0; i < n; i++) {
                String line = in.readLine();
                StringTokenizer stk = new StringTokenizer(line);
                meetings[i][0] = Integer.parseInt(stk.nextToken());
                meetings[i][1] = Integer.parseInt(stk.nextToken());
            }
            return meetings;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static int solve(int[][] meetings) {
        List<Meeting> meetingList = new ArrayList<>();
        for (int[] meeting : meetings) {
            meetingList.add(new Meeting(meeting[0], meeting[1]));
        }
        Collections.sort(meetingList);

        Stack<Meeting> scheduler = new Stack<>();
        for (Meeting meeting : meetingList) {
            if (scheduler.isEmpty()) {
                scheduler.add(meeting);
                continue;
            }
            if (scheduler.peek().endTime <= meeting.startTime) {
                scheduler.add(meeting);
            }
        }
        return scheduler.size();
    }

    static class Meeting implements Comparable<Meeting> {
        int startTime;
        int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Meeting o) {
            return endTime == o.endTime ? startTime - o.startTime
                    : endTime - o.endTime;
        }
    }
}
