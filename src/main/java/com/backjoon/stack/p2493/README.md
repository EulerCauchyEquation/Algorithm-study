# 백준 2493번 문제

* 날짜 : 20.04.12
* 언어 : java
* IDE : IntelliJ IDEA community 

## 요구사항

<img src="/doc/backjoon/stack/p2493/requirement.png"> 

## 풀이

위 문제는 단순하게 생각하면,  top 배열 for문을 돌면서 자기보다 큰 탑이 나타날 때까지 돌면 답은 구할 수 있다.  문제는 시간 복잡도가 O(n^2)을 가져온다.   

그래서 이것을 stack을 이용하면 O(N)으로 개선할 수 있다는 것이 이 문제의 의도이다.


시나리오.

---
1. 현재 타켓인 탑과 스택의 Top자리에 탑과 비교한다.<br>
2.
    2.1 스택의 Top에 탑이 더 크면 stack의 top을 저장하고, 다음 타겟 탑을 준비하고 1번으로 돌아간다.<br>
    2.2 작다면 stack을 pop하고 다시 1번으로 돌아간다.<br>
 
---

스택은 더 사용될 소지가 있으면 pop을 하지않고 다시 쓰는 것이 핵심이다.

예제를 들어보자.  
tops = {6, 9, 5, 7, 4}     stack = {6}    result = {0}

```
top = 9
stack = {9}    result = {0, 0}
```

```
top = 5
stack = {9, 5}    result = {0, 0, 9}
```

```
top = 7
stack = {9, 7}    result = {0, 0, 9, 9}
```

```
top = 4
stack = {9, 7, 4}    result = {0, 0, 9, 9, 7}
```