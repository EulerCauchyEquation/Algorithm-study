# 프로그래머스 : 카드 게임

* 날짜 : 20.03.24
* 언어 : java
* IDE : IntelliJ IDEA community 

## 요구사항

<img src="/doc/programmers/dynamic/p5/requirement.png"> 

## 풀이

DFS에서 출발한다.   경우의 수를 생각해봐야 한다.

case.
```
case 1. 왼쪽 더미만 버리는 경우
case 2. 오른쪽 더미만 버리는 경우 (단, 오른쪽이 왼쪽보다 클 때만)
case 3. 모두 버리는 경우
```

조건을 분석해보면 이렇게 3가지 경우의 수를 갖는다. 이를 DFS로 풀이하면 지수 시간 복잡도를 갖는다.  

####시나리오.

---
1. 노드 방문 시 자식 노드들에 대해 탐색 시도
2. 모든 자식들 중 가장 큰 값을 택한다.
3. 선택한 자식 노드가 오른쪽 더미인 케이스이면 오른쪽 값을 더한다.


<img src="/doc/programmers/dynamic/p5/picture1.jpg"> 

따라서,  이를 개선하기 위해서 다른 방법을 찾다가 그림에서 중복이 부분이 보였다.  이를 보고 Dynamic Programming을 적용하였다. 


참고. 점화식
```
m = left의 인덱스,  n = right의 인덱스

dfs(m, n) = Max( dfs(m + 1, n), dfs(m + 1, n + 1), dfs(m + 1, n + 1) + right[n] )

(단, 마지막 case인 "dfs(m + 1, n + 1) + right[m][n]"은 left[m] > left[n] 일 때만 실행)
```