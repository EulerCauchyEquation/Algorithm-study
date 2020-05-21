package com.kakao.v2020.mocktest.p2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 2020 카카오 인턴십 모의고사 : 문제 2번
 *
 * @author 송훤출
 * @since 20.05.21
 */
public class Solution {

    public static int[] solution(String s) {
        final String[] section = s.split("\\{\\{|},\\{|}}");
        final List<TupleSet> tuple = Stream.of(section)
                .filter(str -> str.length() > 0)
                .map(str -> {
                    final String[] elements = str.split(",");
                    return new TupleSet(elements);
                })
                .sorted((o1, o2) -> o1.size() - o2.size())
                .collect(Collectors.toList());

        final int[] result = new int[tuple.size()];
        int i = 0;
        Set<Integer> prev = new HashSet<>();
        for (TupleSet tupleSet : tuple) {
            final int element = tupleSet.excluding(prev);
            result[i++] = element;
            prev = tupleSet.set;
        }
        return result;
    }

    private static class TupleSet {
        final Set<Integer> set;

        TupleSet(String[] elements) {
            this.set = Stream.of(elements)
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());
        }

        int size() {
            return set.size();
        }

        int excluding(Set<Integer> other) {
            final Set<Integer> temp = new HashSet<>(set);
            temp.removeAll(other);
            Iterator<Integer> it = temp.iterator();
            return it.next();
        }
    }
}
