# 백준 11047번 문제

* 날짜 : 20.03.18
* 언어 : java
* IDE : IntelliJ IDEA community 

## 요구사항

<img src="/doc/backjoon11047.png"> 

## 풀이

DFS 경우의 수를 조사해봐야 하므로 기본적으로 DFS에서 시작한다.   자식 노드들은 동전 종류들로 선정한다.  그러면 과정은

시나리오

---
1. 방문 노드에서 코인만큼 차액한다.
2. 차액한 나머지가 0이면 방문해서 내려간 level을 결과값과 비교한다.   더 작으면 결과값으로 갱신
3. 다시 자식 노드들(코인 종류들) 중 선택하며 탐색을 시도한다.
---

 
```
private static void dfs(int level, int sum, Integer[] coinType) {
    if (sum == 0) {
        result = Math.min(result, level);
        return;
    }
    for (int coin : coinType) {
        if (isValidCoin(sum, coin)) {
            dfs(level + 1, sum - coin, coinType);
        }
    }
}
```

전수조사하면 답은 찾을 수 있을 것이다. 하지만, 이는 시간 복잡도가 어마어마하다.  coinType크기 만큼에 지수 시간 복잡도가 나타난다.  이때,  문제 특성상 큰 동전들만 선택해 탐색하다 보면 답을 찾을 수 있다.  그리고 그 답은 곧 최솟값을 보장한다.  때문에 이 문제는 탐욕(greedy) 알고리즘을 사용할 수 있다.

```
private static void dfs(int level, int sum, Integer[] coinType) {
    if (sum == 0) {
        hasSolved = true;
        result = Math.min(result, level);
        return;
    }
    for (int coin : coinType) {
        if (isValidCoin(sum, coin)) {
            dfs(level + 1, sum - coin, coinType);
            if (hasSolved) {
                return;
            }
        }
    }
}
```

coinType을 내림차순으로 정렬하여 탐색을 시도한다.   그러다 답을 찾으면 즉각 멈춘다.   하지만, 이 방식은 k값은 엄청나게 크고 동전 종류가 모두 1원인 경우는 스택이 버티지 못하고 오버플로우가 발생한다.  따라서,  모든 경우를 커버할 수가 없다.  이에 For문 방식을 택한다.

```
private static int dfs2(int k, Integer[] coinType) {
    int count = 0;
    for (int coin : coinType) {
        if (k >= coin) {
            count += k / coin;
            k = k % coin;
        }
    }
    return count;
}
```
