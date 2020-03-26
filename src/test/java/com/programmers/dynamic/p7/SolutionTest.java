package com.programmers.dynamic.p7;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 송훤출
 * @since 20.03.26
 */
public class SolutionTest {

    @Test
    public void 예제1() {
        int[][] travel = {
                {500, 200, 200, 100},
                {800, 370, 300, 120},
                {700, 250, 300, 90}};
        int k = 1650;
        Assert.assertThat(660, CoreMatchers.is(Solution.solution(k, travel)));
    }

    @Test
    public void asd() {
        int[][] travel = {
                {40, 200, 30, 100},
                {80, 300, 70, 150},
                {50, 400, 30, 300}};
        int k = 140;
        Assert.assertThat(700, CoreMatchers.is(Solution.solution(k, travel)));
    }

    @Test
    public void 예제2() {
        int[][] travel = {
                {1000, 2000, 300, 700},
                {1100, 1900, 400, 900},
                {900, 1800, 400, 700},
                {1200, 2300, 500, 1200}};
        int k = 3000;
        Assert.assertThat(5900, CoreMatchers.is(Solution.solution(k, travel)));
    }

    @Test
    public void 예제3() {
        int[][] travel = {
                {1500, 2300, 2000, 1200}};
        int k = 1000;
        Assert.assertThat(0, CoreMatchers.is(Solution.solution(k, travel)));
    }
}
