# 백준 1987번 문제

* 날짜 : 20.03.12
* 언어 : java
* IDE : IntelliJ IDEA community 

## 요구사항

<img src="/doc/backjoon1987.png"> 

## 풀이

먼저 DFS 를 떠올렸고,  DP를 써보려고 점화식을 세워보려 했지만,  과거의 해답으로 현재의 해답을 찾을 수 없는 구조였다. 따라서, 백트래킹으로 방향을 바꾸었다.

DFS를 기반으로 하되, 의미없는 탐색은 제외한다.  