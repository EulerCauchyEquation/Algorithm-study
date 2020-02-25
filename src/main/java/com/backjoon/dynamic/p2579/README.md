# 백준 2579번 문제

* 날짜 : 20.02.25
* 언어 : java
* IDE : IntelliJ IDEA community 

## 요구사항

<img src="/doc/backjoon2579.png"> 


## 풀이


점화식을 놓고 계산한다.  마지막 계단 전 계단을 밟았냐,  안 밟았냐로 생각한다. 

* 마지막 계단 전의 계단을 밟은 경우
* 그렇지 않은 경우

1번 경우라면 마지막 계단 전전의 계단은 밟지 못한다. <br>
2번 경우라면 마지막 계단 전전의 계단은 무조건 밟고 와야한다.

위 경우를 통해 점화식 도출이 가능하다.
```
sum(n) = sum(n-3) + value(n) + value(n-1)
sum(n) = sum(n-2) + value(n)
(단, n >= 3)
```
sum은 n번 계단까지 밟으면서 모두 더한 값이다.  계단이 총 두 개인 경우와 한 개인 경우는 대입이 불가능하므로, 
```
sum(2) = value(2) + value(1)
sum(1) = value(1)
```

놓고 진행한다.   문제는 최대값을 목표로 하기때문에 두 경우 중 가장 큰 값을 선택하면서 recursive로 풀이했다.


## 특이부분
```$xslt
 private static int util(int n, int[] values) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return values[1];
        }
        if (n == 2) {
            return values[1] + values[2];
        }
        return Math.max(
                util(n - 3, values) + values[n] + values[n - 1],
                util(n - 2, values) + values[n]);
    }
```

중복되는 부분은 재활용을 위해 memo배열을 생성해서 활용했다.

```$xslt
private static int util(int n, int[] values) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            memo[n] = values[1];
        } else if (n == 2) {
            memo[n] = values[1] + values[2];
        } else {
            if (memo[n] > 0) {
                return memo[n];
            }
            memo[n] = Math.max(
                    util(n - 3, values) + values[n] + values[n - 1],
                    util(n - 2, values) + values[n]);
        }
        return memo[n];
```