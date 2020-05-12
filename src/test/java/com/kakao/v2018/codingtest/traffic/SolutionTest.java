package com.kakao.v2018.codingtest.traffic;

import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.is;

/**
 * 2018 카카오 블라인드 코딩 테스트 : 추석 트래픽 test
 *
 * @author 송훤출
 * @since 20.05.12
 */
public class SolutionTest {

    @Test
    public void 예제1() {
        String[] lines = {"2016-09-15 00:00:00.000 3s"};

        Assert.assertThat(Solution.solution(lines), is(1));
    }

    @Test
    public void 예제2() {
        String[] lines = {"2016-09-15 23:59:59.999 0.001s"};

        Assert.assertThat(Solution.solution(lines), is(1));
    }

    @Test
    public void 예제3() {
        String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};

        Assert.assertThat(Solution.solution(lines), is(1));
    }

    @Test
    public void 예제4() {
        String[] lines = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};

        Assert.assertThat(Solution.solution(lines), is(2));
    }

    @Test
    public void 예제5() {
        String[] lines = {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"};

        Assert.assertThat(Solution.solution(lines), is(7));
    }

    @Test
    public void 예제6() {
        String[] lines = {"2016-09-15 00:00:00.000 2.3s", "2016-09-15 23:59:59.999 0.1s"};

        Assert.assertThat(Solution.solution(lines), is(1));
    }

    @Test
    public void asd() {
        String s = "2016-09-15 20:59:58.233 1.181s";
        String[] split = s.split("\\s(?=\\d\\.\\d{1,3})");
        String[] temp = split[0].split(" ");
        LocalDateTime time = LocalDateTime.parse(split[0], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.nnn"));
        System.out.println(time.getNano());
        LocalTime time1 = LocalTime.of(0, 0, 1, 1);
        LocalTime time2 = LocalTime.of(0, 9, 1, 123);
        Duration d = Duration.between(time1, time2);
        LocalTime time3 = time2.minus(d);
        LocalTime time4 = LocalTime.parse("12,23,45.445", DateTimeFormatter.ofPattern("HH,mm,ss.SSS"));

        String[] ss = "1.181s".split("[.s]");
        LocalTime time5 = LocalTime.of(0, 0, Integer.parseInt(ss[0]), Integer.parseInt(ss[1]));


    }
}
