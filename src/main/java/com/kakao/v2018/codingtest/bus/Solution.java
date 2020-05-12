package com.kakao.v2018.codingtest.bus;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 카카오 2018 블라인드 코딩 테스트 : 셔틀버스
 *
 * @author 송훤출
 * @since 20.05.11
 */
public class Solution {

    public static String solution(int n, int t, int m, String[] timetable) {
        final List<LocalTime> passengerList = Arrays.stream(timetable)
                .map(LocalTime::parse)
                .sorted()
                .collect(Collectors.toList());
        final LinkedList<Bus> busList = IntStream.range(0, n)
                .mapToObj(it -> new Bus(it * t, m))
                .collect(Collectors.toCollection(LinkedList::new));

        for (Bus bus : busList) {
            final Iterator<LocalTime> it = passengerList.iterator();
            while (it.hasNext()) {
                final LocalTime passenger = it.next();
                if (bus.canGetOn(passenger)) {
                    bus.getOn(passenger);
                    it.remove();
                }
            }
        }

        final Bus lastBus = busList.getLast();
        final LocalTime result = lastBus.isAvailable()
                ? lastBus.arriveTime
                : lastBus.passengers.getLast().minusMinutes(1);
        return result.toString();
    }

    static class Bus {
        private static final LocalTime START = LocalTime.of(9, 0);

        private final LinkedList<LocalTime> passengers;
        private final LocalTime arriveTime;
        private final int capacity;

        public Bus(int t, int capacity) {
            this.arriveTime = START.plusHours(t / 60).plusMinutes(t % 60);
            this.capacity = capacity;
            this.passengers = new LinkedList<>();
        }

        public boolean canGetOn(LocalTime time) {
            return isAvailable()
                    && (arriveTime.isAfter(time) || arriveTime.equals(time));

        }

        public boolean isAvailable() {
            return passengers.size() < capacity;
        }

        public void getOn(LocalTime passenger) {
            passengers.add(passenger);
        }
    }
}
