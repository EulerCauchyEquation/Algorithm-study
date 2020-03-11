# 백준 2169번 문제

* 날짜 : 20.03.10
* 언어 : java
* IDE : IntelliJ IDEA community 

## 요구사항

<img src="/doc/backjoon2169.png"> 

## 풀이

백트랙킹이 먼저 떠올랐지만, DP로 풀어봤다.  점화식을 찾기 위해서 경우의 수를 생각했다.  진행방향이 좌, 우, 아래만 가능하므로 좌표 (M,N) = 위에서 오는 경우, 왼쪽, 오른쪽에서 오는 경우 중에 최대값과 (M, N)좌표의 가치의 합이다.  따라서,

```
sum(m, n) = max(sum(m, n-1), sum(m, n+1), sum(m-1, n)) + board[m][n]
```


이다.  그런데, 문제가 하나있다.  재탐색이 불가능하다는 조건이 문제다.  보통 이런 문제는 방향이 우측과 아래만 가능한 조건이 일반적이다. 그래서,  다음 길이 항상 새로운 길이다.  그런데,  위 문제는 좌측와 우측이 가능하므로,  왔던 길을 다시 갈 수 있는 문제가 생긴다.  이것을 해결하려면, 왔던 길은 제외한 나머지 경우에 대해서 max를 따져야한다. 예를 들면, (m, n)의 좌표가 우측에서 온 전제하면 좌측의 경우를 제외한 우측과 위 경우만 따진다.  

```
sum(m, n, 좌) = max(sum(m, n-1, 좌), sum(m-1, n, 위)) + board[m][n]
sum(m, n, 우) = max(sum(m, n+1, 우), sum(m-1, n, 위)) + board[m][n]
sum(m, n, 위) = max(sum(m, n-1, 좌), sum(m, n+1, 우), sum(m-1, n, 위)) + board[m][n]
```


여기까지는 비교적 잘 찾아왔는데, memoization 과정이 조금 힘들었다.

```
private static int util(int m, int n, int fromDir, int[][] board) {
    ...
    memo[m][n][fromDir] = max(left, right, up);
    return memo[m][n][fromDir];
}
```

해당 값이 배열에서 벗어난 범주이거나 재탐색하는 방향이면 Integer.MIN_VALUE로 처리했다.  그러다보니 모든 경우의 수가 Integer.MIN_VALUE이면 점화식 값이 Integer.MIN_VALUE가 나온다. 이럴 경우는 버려야 하는데,  Integer.MIN_VALUE + board[m][n] 해버려서 문제가 발생했다.  이것을 찾는다고 많이 헤맸다.

```
private static int util(int m, int n, int fromDir, int[][] board) {
    ...
    memo[m][n][fromDir] = max(left, right, up);
    memo[m][n][fromDir] = (memo[m][n][fromDir] == Integer.MIN_VALUE)
            ? memo[m][n][fromDir]
            : memo[m][n][fromDir] + board[m][n];
    return memo[m][n][fromDir];
}
```

하나의 값에 두 가지 의미가 있어서 생긴 문제였다.  좀 더 쉽게 풀이할 방법을 생각해봐야겠다.