# 백준 9251번 문제

* 날짜 : 20.03.06
* 언어 : java
* IDE : IntelliJ IDEA community 

## 요구사항

<img src="/doc/backjoon9251.png"> 

## 풀이

LCS는 Longest Common Subsequence의 약자로 최장 공통 수열 알고리즘이다.   유명한 알고리즘으로,  처음 접했을 때 상당히 어려웠다.   보통 문제는 점화식을 쉽게 구할 수 있게 경우의 수를 힌트로 주지만 이 문제는 직접 찾아야 한다. <br>

생각하기가 까다롭지만 경우의 수는 이렇게 생각할 수 있다.  마지막 문자끼리 같을 때, 아닐 때 두 가자이다.  "ABCD" 와 "AEBD" 예를 들어 보겠다.  마지막 문자가 같으므로,  LCS("ABCD", "AEBD") = LCS("ABC", "AEB") 생각할 수 있다.  다음 마지막 문자가 다르므로 선택지가 생기는데, "ABC"와 "AE"와 비교하느냐, "AB"아 "AEB"와 비교하느냐가 생긴다.  처음에 이렇게 생각하기 어려웠다. <br>

해서 점화식은 다음과 같이 도출할 수 있다. <br>

```
LCS(n, n) = LCS(n-1, n-1) + 1   ( 마지막 문자가 같을 때 )
LCS(n, n) = Max(LCS(n, n-1), LCS(n-1, n))   (마지막 문자가 다를 때)
```

DP 문제 중 가장 헤맸다. 시간 복잡도도 생각하기 힘들었다. memoization을 적용했을 때 O(nm)이 맞는지 모르겠다.<br>

"ABCD"와 "AEBD" 예

<img src="/doc/backjoon9251/tiemcomplexity1.png"> 

<일반적인 경우>

<img src="/doc/backjoon9251/tiemcomplexity2.png"> 

<memoization을 적용한 경우>

