package com.programmers.greedy.p6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 프로그래머스 : 단속카메라 (greedy)
 *
 * @author 송훤출
 * @since 20.04.03
 */
public class Solution {

    public static int solution(int[][] routes) {
        List<Route> routeList = Arrays.stream(routes)
                .map(route -> new Route(route[0], route[1]))
                .sorted(Route::compareTo)
                .collect(Collectors.toList());

        int camera = 1;
        Route standard = routeList.get(0);

        for (Route route : routeList) {
            if (standard.end < route.start) {
                standard = route;
                camera++;
            }
        }
        return camera;
    }

    static class Route implements Comparable<Route> {
        int start;
        int end;

        public Route(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Route o) {
            return end - o.end;
        }
    }
}
