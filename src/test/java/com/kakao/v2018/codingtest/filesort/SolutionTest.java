package com.kakao.v2018.codingtest.filesort;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * 2018 카카오 블라인드 코딩 테스트 3차 : 파일명 정렬 test
 *
 * @author 송훤출
 * @since 20.05.22
 */
public class SolutionTest {

    @Test
    public void 예제1() {
        final String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        final String[] result = {"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"};

        Assert.assertThat(Solution.solution(files), is(result));
    }

    @Test
    public void 예제2() {
        final String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        final String[] result = {"A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"};

        Assert.assertThat(Solution.solution(files), is(result));
    }
}
