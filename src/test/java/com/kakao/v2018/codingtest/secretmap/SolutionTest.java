package com.kakao.v2018.codingtest.secretmap;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author 송훤출
 * @since 20.04.09
 */
public class SolutionTest {

    @Test
    public void 예제1() {
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] result = {"#####", "# # #", "### #", "#  ##", "#####"};

        Assert.assertThat(result, is(Solution.solution(arr1.length, arr1, arr2)));
    }

    @Test
    public void 예제2() {
        int[] arr1 = {46, 33, 33, 22, 31, 50};
        int[] arr2 = {27, 56, 19, 14, 14, 10};

        String[] result = {"######", "###  #", "##  ##", " #### ", " #####", "### # "};
        Assert.assertThat(result, is(Solution.solution(arr1.length, arr1, arr2)));
    }
}
