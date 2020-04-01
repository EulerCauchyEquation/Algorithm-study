# 백준 9466번 문제

* 날짜 : 20.04.01
* 언어 : java
* IDE : IntelliJ IDEA community 

## 요구사항

<img src="/doc/backjoon/dfs/p1890/requirement.png"> 

## 풀이

DFS 문제이다.   목표는 탐색하다 사이클이 발견되면, 해당 노드들은 제외하는 로직을 만들어야 한다.  
그래서,  시작 노드를 기준으로 인접한 노드들을 탐색하다가 다시 시작 노드를 방문하면 사이클을 발견한 형식으로 작성했다.

```
private static void dfs(int studentNo, int wantedNo) {
    if (studentNo == wantedNo) {
        hasTeam = true;
        return;
    }


    if (visited[studentNo]) {
        return;
    }


    visited[studentNo] = true;
    dfs(mWanted[studentNo], wantedNo);
}
```

그리고 다음 기준 노드들에서 출발 시 visited 배열을 초기화하고 다시 시작하였다.  그런데, 이 방법은 N 제곱의 시간 복잡도를 초래하였다.  그래서 다른 방법으로 해결하여야 했다.

조건을 잘 살펴보면, Directed Graph이다. Directed Graph일 때, cycle 유무는 back edge 가 있냐 없냐의 문제로 좁혀진다.  즉,  어떤 u 정점를 기준으로 dfs를 시작하다가 dfs가 끝나지 않은 정점을 다시 방문하면 back edge가 있다는 존재이고, cycle이 존재한다는 얘기가 된다.  이 방법은 O(V + E) 시간 복잡도로 해결이 가능하다.

```
private static void dfs(int here) {      
    // dfs 끝난 상태인 정점이면
    if (visited[here] == FINISHED) {
        return;
    }
     // 해당 정점이 cycle이 존재
    if (visited[here] == CYCLE) {
        return;
    }

     // dfs 중인 상태이면, cycle 처리
    if (visited[here] == SEARCHING) {
        visited[here] = CYCLE;
        cycleVertex++;
    // 최초 방문이면
    } else if (visited[here] == NOT_VISITED) {
        visited[here] = SEARCHING;
    }


    dfs(mWanted[here]);
    visited[here] = FINISHED;
}
```

directed graph일 때, cycle 찾기 :  https://kesakiyo.tistory.com/15

