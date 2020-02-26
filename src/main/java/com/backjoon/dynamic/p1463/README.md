# 백준 1463번 문제

* 날짜 : 20.02.26
* 언어 : java
* IDE : IntelliJ IDEA community 

## 요구사항

<img src="/doc/backjoon1463.png"> 


## 풀이
점화식 세우는데 오래 걸렸다.  평소 점화식 방법이랑 조금 달랐다.   

```
a(n) = a(n/3) + 1  (단, 3으로 나눈 나머지가 0일 때 적용)
a(n) = a(n/2) + 1  (단, 2로 나눈 나머지가 0일 때 적용)
a(n) = a(n-1) + 1
```

우리가 필요한 값은 최솟값이므로,  3가지 경우 중 최솟값을 선택하면서 찾으면 된다.

<img src="/doc/backjoon1463/tiemcomplexity1.png"> 

<일반적인 경우>

<img src="/doc/backjoon1463/tiemcomplexity2.png"> 

<memoization을 적용한 경우>
