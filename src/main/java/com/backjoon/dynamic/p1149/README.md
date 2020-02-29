# 백준 1149번 문제

* 날짜 : 20.02.29
* 언어 : java
* IDE : IntelliJ IDEA community 

## 요구사항

<img src="/doc/backjoon1149.png"> 


## 풀이

처음에 최솟값을 선택하면서 풀어나가면 결정되는 줄 알았다.  그래서 점화식을 다음과 같이 도출했다.

```
sum(n) = sum(n-1) + min(values[n][0], values[n][1], values[n][2]) 
```

그런데 그것은 함정이었다. <br>

.|Red|Green|Blue
-|-|-|-
 N = 1|1|100|200
 N = 2|1|201|101
 N = 3|202|102|1

위와 같은 경우, n=1에서 출발할 때,  위 점화식으로 하면 처음에 Red를 선택하고, 두번째에서 Blue, 세번째에서 Green을 선택하면서 값이 204가 나온다.  하지만, 답은 102이다.  이것은 최솟값만 선택해서는 알수가 없다는 것을 의미했다.  따라서, 전수조사하는 방향으로 선택했고,

```
total(n) = min(sum(n, Red), sum(n, Green), sum(n, Blue))
sum(n, color) = min(sum(n-1, otherColor), sum(n-1, anotherColor)) + values[n][color]
```

새로운 점화식을 도출해냈다.  처음에 red를 선택했을 때 최솟값, blue일 때, green일 때 이렇게 모두 구해서 가장 작은 값을 선택한다.
이 경우, 시간복잡도는 O(2의 n승)이 나오는데 memoization을 적용하면 O(n)으로 만들 수 있다.
