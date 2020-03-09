# 백준 10164번 문제

* 날짜 : 20.03.09
* 언어 : java
* IDE : IntelliJ IDEA community 

## 요구사항

<img src="/doc/backjoon10164.png"> 

## 풀이

먼저 o 표시 조건을 제외한 경우부터 고려해본다.  
그러면 (m,n)일 때 총합은 (m,n-1)일 때의 총합과 (m-1,n)일 때의 총합과 같으므로

```
sum(m, n) = sum(m, n-1) + sum(m-1, n)
```

을 알 수 있다. 여기서 o 조건을 고려해보면, 

<img src="/doc/backjoon10164/picture1.png"> 

O 가 8번일 때, 좌표가 X인 영역은 조사할 이유가 없어진다.  그 영역은 0처리해버리면 간단해진다.
따라서,  (m, n) 좌표가 x 영역이면 점화식을 진행하지 않는다.

```
sum(m, n) = sum(m, n-1) + sum(m-1, n)
sum(m, n) = 0  ( (m,n)이 X인 좌표 영역이면 )
```
