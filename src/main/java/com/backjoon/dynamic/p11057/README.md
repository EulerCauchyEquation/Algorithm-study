# 백준 11057번 문제

* 날짜 : 20.02.28
* 언어 : java
* IDE : IntelliJ IDEA community 

## 요구사항

<img src="/doc/backjoon11057.png"> 

## 풀이

처음에는 dynamic programming 방식을 고려하지 않았다.  그러나 수열을 풀어놓고 보는데 생각이 들었다.  다음 문제는 이렇게 생각하면서 착안했다.

```
if n = 1, then 1 + 1 + ... + 1 = 10
if n = 2, then 1 + 2 + 3 + ...  + 10 = 55
if n = 3, then 1 + (1 + 2) + (1 + 2 + 3) + ... + (1 + 2 + ... + 10) = 220
...
```

이렇게 수열을 풀어놓고 보니 안 보이던 규칙이 보였다.   규칙을 발견하고 점화식을 세웠다.

```
sum(n) = value[n][1] + value[n][2] + ... + value[n][10]
value[n][x] = value[n-1][0] + value[n-1][1] + value[n-1][2] + ... + value[n][9]
(단, n >= 1)
```

생각보다 까다로운 듯 하였으나, 쉽게 생각한 문제였다.<br>
시간복잡도를 생각해봤는데, 이것이 맞는지 잘 모르겠다.

<img src="/doc/backjoon11057/timecomplexity1.png"> 

memoization 적용 전 알고리즘이다.  

<img src="/doc/backjoon11057/timecomplexity2.png"> 

memoization 적용 후이다. 빨간색만 탐색하고 검은색은 재활용해서 탐색하지 않는다.  <br>
O(10n) = O(n)


## 특이부분

```
    public static int solve(int n) {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += util(n, i);
        }
        return sum % CORRECTION;
    }

    private static int util(int n, int x) {
        if (n == 1) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i <= x; i++) {
            sum += util(n - 1, i) % CORRECTION;
        }
        return sum % CORRECTION; 
    }
```

memoization 적용 전 

```
  public static long solve(int n) {
        memo = new long[n + 1][10];
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += util(n, i);
        }
        return sum % CORRECTION;
    }

    private static long util(int n, int x) {
        if (n == 1) {
            memo[n][x] = 1;
        }
        if (memo[n][x] > 0) {
            return memo[n][x];
        }
        for (int i = 0; i <= x; i++) {
            memo[n][x] += util(n - 1, i) % CORRECTION;
        }
        return memo[n][x] % CORRECTION;
    }
```
memoization 적용 후