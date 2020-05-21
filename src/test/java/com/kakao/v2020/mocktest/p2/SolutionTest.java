package com.kakao.v2020.mocktest.p2;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * 2020 카카오 인턴십 모의고사 : 문제 2번 test
 *
 * @author 송훤출
 * @since 20.05.21
 */
public class SolutionTest {

    @Test
    public void 예제1() {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        Assert.assertThat(Solution.solution(s), is(new int[]{2, 1, 3, 4}));
    }

    @Test
    public void 예제2() {
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";

        Assert.assertThat(Solution.solution(s), is(new int[]{2, 1, 3, 4}));
    }

    @Test
    public void 예제3() {
        String s = "{{20,111},{111}}";

        Assert.assertThat(Solution.solution(s), is(new int[]{111, 20}));
    }

    @Test
    public void 예제4() {
        String s = "{{123}}";

        Assert.assertThat(Solution.solution(s), is(new int[]{123}));
    }

    @Test
    public void 예제5() {
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        Assert.assertThat(Solution.solution(s), is(new int[]{3, 2, 4, 1}));
    }
}
