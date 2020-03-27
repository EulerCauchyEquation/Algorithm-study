# 백준 12865번 문제

* 날짜 : 20.03.27
* 언어 : java
* IDE : IntelliJ IDEA community 

## 요구사항

<img src="/doc/backjoon/dynamic/p12865/requirement.png"> 

## 풀이

사실 이 문제는 쉽게 풀 수 있었다. 전 날에 풀었던 "서울에서 경산까지" 문제와 아주 흡사했기 때문이다.  
약간의 조건만 다를 뿐 매우 흡사한 문제다.  

이 문제 또한, 동적 계획법으로 풀 수 있다.  점화식은 다음처럼 도출할 수 있다.

case.

---
case 1. 물건을 선택한다.<br>
case 2. 물건을 선택하지 않는다. <br>

---

점화식.
```
dfs(n, weight) = Max ( 
            dfs( n + 1, weight - 물건 무게[n] ) + 물건 가치[n]       ( 단,  물건 무게[n] <= weight )
            dfs( n + 1, weight)
```  

너무 기계적으로 푼 문제다.

######유사한 문제. 
* 프로그래머스,  서울에서 경산까지
* 백준 2240, 자두 나무



