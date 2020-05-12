package com.kakao.v2018.codingtest.dart;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * 카카오 2018 블라인드 코딩 테스트 : 다트 게임 test
 *
 * @author 송훤출
 * @since 20.05.08
 */
public class SolutionTest {

    @Test
    public void 예제1() {
        Assert.assertThat(Solution.solution("1S2D*3T"), is(37));
    }

    @Test
    public void 예제2() {
        Assert.assertThat(Solution.solution("1D2S#10S"), is(9));
    }

    @Test
    public void 예제3() {
        Assert.assertThat(Solution.solution("1D2S0T"), is(3));
    }

    @Test
    public void 예제4() {
        Assert.assertThat(Solution.solution("1S*2T*3S"), is(23));
    }

    @Test
    public void 예제5() {
        Assert.assertThat(Solution.solution("1D#2S*3S"), is(5));
    }

    @Test
    public void 예제6() {
        Assert.assertThat(Solution.solution("1T2D3D#"), is(-4));
    }

    @Test
    public void 예제7() {
        Assert.assertThat(Solution.solution("1D2S3T*"), is(59));
    }
}
