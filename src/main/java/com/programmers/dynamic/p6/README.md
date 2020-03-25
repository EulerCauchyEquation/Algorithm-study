# 프로그래머스 : 도둑질

* 날짜 : 20.03.25
* 언어 : java
* IDE : IntelliJ IDEA community 

## 요구사항

<img src="/doc/programmers/dynamic/p6/requirement.png"> 

## 풀이

DFS에서 Dynamic Programming으로 풀이했다.  

```
case 1. 현재 집을 훔치지 않고 통과한다.
case 2. 현재 집을 훔친다.  ( 다음은 두번 째 집부터 탐색 )
```


점화식은 다음과 같다.
```
dfs(n, 통과) = Max( dfs(n + 1, 통과), dfs(n + 1, 훔침) )
dfs(n, 훔침) = Max( dfs(n + 2, 통과), dfs(n + 2, 훔침) ) + money[n]
```

그런데, 재귀로 풀이하니 스택 오버플로우 때문인지는 모르겠지만, 효율성에서 실패하였다.

<img src="/doc/programmers/dynamic/p6/picture1.jpg"> 

그래서, For문 형태로 바꾸니 해결은 하였다.

<img src="/doc/programmers/dynamic/p6/picture2.jpg"> 

이유를 확실히는 모르겠다.  데이터가 너무 커서 그런 것인지..