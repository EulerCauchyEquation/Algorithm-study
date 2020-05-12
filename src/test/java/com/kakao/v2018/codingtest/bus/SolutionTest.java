package com.kakao.v2018.codingtest.bus;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * 카카오 2018 블라인드 코딩 테스트 : 셔틀버스 test
 *
 * @author 송훤출
 * @since 20.05.11
 */
public class SolutionTest {

    @Test
    public void 예제1() {
        int n = 1;
        int t = 1;
        int m = 5;
        String[] timetable = {"08:00", "08:01", "08:02", "08:03"};

        Assert.assertThat(Solution.solution(n, t, m, timetable), is("09:00"));
    }

    @Test
    public void 예제2() {
        int n = 2;
        int t = 10;
        int m = 2;
        String[] timetable = {"09:10", "09:09", "08:00"};

        Assert.assertThat(Solution.solution(n, t, m, timetable), is("09:09"));
    }

    @Test
    public void 예제3() {
        int n = 2;
        int t = 1;
        int m = 2;
        String[] timetable = {"09:00", "09:00", "09:00", "09:00"};

        Assert.assertThat(Solution.solution(n, t, m, timetable), is("08:59"));
    }

    @Test
    public void 예제4() {
        int n = 1;
        int t = 1;
        int m = 5;
        String[] timetable = {"00:01", "00:01", "00:01", "00:01", "00:01"};

        Assert.assertThat(Solution.solution(n, t, m, timetable), is("00:00"));
    }

    @Test
    public void 예제5() {
        int n = 1;
        int t = 1;
        int m = 1;
        String[] timetable = {"23:59"};

        Assert.assertThat(Solution.solution(n, t, m, timetable), is("09:00"));
    }

    @Test
    public void 예제6() {
        int n = 10;
        int t = 60;
        int m = 45;
        String[] timetable = {"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};

        Assert.assertThat(Solution.solution(n, t, m, timetable), is("18:00"));
    }
}
