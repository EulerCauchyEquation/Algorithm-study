package com.kakao.v2019.codingtest.chatting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2019 KAKAO 블라인드 코딩 테스트 : 오픈 채팅방
 *
 * @author 송훤출
 * @since 20.05.19
 */
public class Solution {

    public static String[] solution(String[] records) {
        final Map<String, User> userMap = new HashMap<>();
        final List<User> logList = new ArrayList<>();

        for (String record : records) {
            final String[] section = record.split(" ");
            final String state = section[0];
            final String id = section[1];
            final String nick = section.length == 3 ? section[2]
                    : null;

            switch (state) {
                case "Enter":
                    final User newUser = new User(id, nick, true);
                    userMap.put(id, newUser);
                    logList.add(User.of(id, nick, true));
                    break;
                case "Leave":
                    final User leaveUser = userMap.get(id);
                    logList.add(User.of(leaveUser.id, leaveUser.nickName, false));
                    break;
                case "Change":
                    User temp = userMap.get(id);
                    temp.nickName = nick;
                    break;
                default:
                    throw new AssertionError();
            }
        }
        return logList.stream()
                .map(user -> {
                    user.nickName = userMap.get(user.id).nickName;
                    return user.nickName + (user.state
                            ? "님이 들어왔습니다."
                            : "님이 나갔습니다.");
                })
                .toArray(String[]::new);
    }

    private static class User {
        final String id;
        String nickName;
        boolean state;

        User(String id, String nickName, boolean state) {
            this.id = id;
            this.nickName = nickName;
            this.state = state;
        }

        static User of(String id, String nickName, boolean state) {
            return new User(id, nickName, state);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof User) {
                User another = (User) obj;
                return this.id.equals(another.id)
                        && this.nickName.equals(another.nickName);
            }
            return false;
        }
    }
}
