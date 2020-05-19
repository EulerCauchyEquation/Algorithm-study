package com.kakao.v2019.codingtest.chatting;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * 2019 KAKAO 블라인드 코딩 테스트 : 오픈 채팅방 test
 *
 * @author 송훤출
 * @since 20.05.19
 */
public class SolutionTest {

    @Test
    public void 예제1() {
        String[] records = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };
        String[] result = {
                "Prodo님이 들어왔습니다.",
                "Ryan님이 들어왔습니다.",
                "Prodo님이 나갔습니다.",
                "Prodo님이 들어왔습니다."
        };
        Assert.assertThat(Solution.solution(records), is(result));
    }
}
