package com.kakao.v2018.codingtest.filesort;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 2018 카카오 블라인드 코딩 테스트 3차 : 파일명 정렬
 *
 * @author 송훤출
 * @since 20.05.22
 */
public class Solution {

    public static String[] solution(String[] files) {
        final List<File> fileList = Stream.of(files)
                .map(File::new)
                .sorted()
                .collect(Collectors.toList());

        return fileList.stream()
                .map(File::toString)
                .toArray(String[]::new);
    }

    private static class File implements Comparable<File> {
        final String filename;
        final String head;
        final String number;
        final String tail;

        File(String filename) {
            this.filename = filename;
            final String[] section = parse(filename);
            this.head = section[0];
            this.number = section[1];
            this.tail = section[2] == null ? "" : section[2];
        }

        String[] parse(String file) {
            final Pattern pattern = Pattern.compile("^(\\D+)(\\d+)(.*)$");
            final Matcher matcher = pattern.matcher(file.toLowerCase());
            final String[] sections = new String[3];
            matcher.find();
            for (int i = 0; i < sections.length; i++) {
                sections[i] = matcher.group(i + 1);
            }
            return sections;
        }

        @Override
        public String toString() {
            return filename;
        }

        @Override
        public int compareTo(File o) {
            final int compare = this.head.compareTo(o.head);
            if (compare == 0) {
                return Integer.parseInt(this.number) - Integer.parseInt(o.number);
            }
            return compare;
        }
    }
}
