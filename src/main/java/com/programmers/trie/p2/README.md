# 프로그래머스 : 전화번호 목록

* 날짜 : 20.04.15
* 언어 : java
* IDE : IntelliJ IDEA community 

## 요구사항

<img src="/doc/programmers/trie/p2/requirement.png"> 

## 풀이

문자열 비교 문제이다. 우리가 보통 단순한 방식으로 하면 O(n^3) 시간 복잡도를 초래한다.

n길이인 문자열 두개를 비교하는데 time-complexity는 O(n)이다.
그 비교하고자 하는 문자열이 n개이면 O(n^2)이다.  
이 문제는 여기서 각 문자열을 위 과정을 다 거쳐야하므로, O(N^3)이 걸린다.

```
return Arrays.stream(phone_book)
        .allMatch(phone -> Arrays.stream(phone_book)
                .filter(other -> !other.equals(phone))
                .allMatch(other_phone -> !other_phone.startsWith(phone))
        );
```

이때, Trie라는 자료구조를 사용하면, O(n^2)으로 줄일 수 있다.
Trie는 문자열을 insert하는데 문자열 길이만큼 걸리고, 접두어인지 판단하는데 문자열 길이만큼 걸린다.

따라서, O(n^2)으로 간단하게 풀 수 있다.  이 Trie는 접두어 관련 문제나 자동 완성 문제에서 유용하게 해결할 수 있다.