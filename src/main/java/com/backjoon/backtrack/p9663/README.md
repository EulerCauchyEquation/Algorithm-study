# 백준 9663번 문제

* 날짜 : 20.03.13
* 언어 : java
* IDE : IntelliJ IDEA community 

## 요구사항

<img src="/doc/backjoon9663.png"> 

## 풀이

Backtracking에 대표적인 문제이다.   DFS로 먼저 출발하면서 생각해봤다.

N x N의 체스판에 Queen의 개수는 N개라 하였다.  단순히 N의 최대치인 14일 때, 조합인 288 C 14는 계산 해보지 않아도 엄청나게 큰 값일 것이다.   그러나 기본적으로 Queen의 성질 때문에 한 행에 하나의 Queen만 놓을 수 있다.  그래서 다시 생각해보면  체스판에 한 행마다 Queen을 놓는 경우의 수이므로, 14개에 대한 순열이다.  14! 값이라는 경우의 수가 나온다.  이 또한,  시간 복잡도가 어마어마하다.  

이렇게 단순히 DFS로는 풀기가 힘들다. 하여 Backtrack을 적용하여 풀어봤다.    
DFS처럼 탐색을 시도하되 자식 노드가 의미없는 것은 배제를 할 것이다.  배제할 노드들은 부모 노드인 먼저 선택된 Queen의 대각선과 수직에 위치한 노드들이다.   

과정은 이러했다.
```
1.  방문한 노드들을 list에 넣는다.
2.  유망한 노드들을 선별하여,  있으면 방문할 시도한다. (1번으로)
3.  없으면,  방문한 노드를 list에서 해제한다.
```

선별하는 방법으로는,
list에 있는 모든 노드들의 열 위치에 있으면 배제한다.
list에 있는 모든 노들의 대각선 위치에 있으면 배제한다.

```
if (y == p.y) {
    return false;
}
```

열 위치에 있으면 배제한다.

```
double m = ((double) (y - p.y) / (x - p.x));
if (Math.abs(m) == 1.0) {
    return false;
}
```

list에 노드들과의 기울기 값이 1이 나타나면 배제한다. 이것은 x + y = k 이거나 x - y = k인 1차 방정식에서 착안했다.  대각선은 기울기가 1이거나 -1일 때만 나타난다.  따라서,  둘 중에 하나라도 나타나면 대각선에 위치한 것이므로 배제한다. ( 절대값을 취해 1로 선별해도 동일한 결과가 나오므로 취하였음 )

```
private static boolean isValid(int x, int y) {
    for (Point2D p : list) {
        if (y == p.y) {
            return false;
        }
        double m = ((double) (y - p.y) / (x - p.x));
        if (Math.abs(m) == 1.0) {
            return false;
        }
    }
    return true;
}
```

선별하는 메소드의 전체 소스이다.

