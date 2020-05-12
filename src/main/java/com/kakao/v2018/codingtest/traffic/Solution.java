package com.kakao.v2018.codingtest.traffic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 2018 카카오 블라인드 코딩 테스트 : 추석 트래픽
 *
 * @author 송훤출
 * @since 20.05.12
 */
public class Solution {

    public static int solution(String[] lines) {
        final List<Time> timeList = Stream.of(lines)
                .flatMap(line -> {
                    final String[] parse = line.split("\\s((?=\\ds$)|(?=\\d.\\d{1,3}s$))");
                    final LocalDateTime time = getStartTime(parse[0]);
                    final Time end = new Time(time, "end");
                    final Time start = new Time(getStartTime(time, parse[1]), "start");
                    final List<Time> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    return list.stream();
                })
                .sorted()
                .collect(Collectors.toList());

        int max = 0;
        int count = 0;
        for (Time time : timeList) {
            count = time.pos.equals("start") ? ++count : --count;
            max = Math.max(max, count);
        }
        return max;
    }

    private static LocalDateTime getStartTime(String time) {
        return LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    }

    private static LocalDateTime getStartTime(LocalDateTime end, String time) {
        final String[] parse = time.split("[.s]");
        final int second = Integer.parseInt(parse[0]);
        final int millisecond = (parse.length == 1) ? 0
                : Integer.parseInt(parse[1]) * 1000000;

        return end.minusSeconds(second)
                .minusNanos(millisecond)
                .minusNanos(999000000);
    }


    static class Time implements Comparable<Time> {
        private final LocalDateTime time;
        private final String pos;

        public Time(LocalDateTime time, String pos) {
            this.time = time;
            this.pos = pos;
        }

        @Override
        public int compareTo(Time o) {
            if (this.time.equals(o.time)) {
                return pos.equals("end") ? -1 : 1;
            }

            return this.time.compareTo(o.time);
        }
    }
}
