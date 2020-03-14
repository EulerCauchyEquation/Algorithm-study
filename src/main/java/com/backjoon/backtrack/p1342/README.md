# 백준 1342번 문제

* 날짜 : 20.03.14
* 언어 : java
* IDE : IntelliJ IDEA community 

## 요구사항

<img src="/doc/backjoon1342.png"> 

## 풀이

 back-tracking법으로 시도한다.   자식 노드가 부모 노드와 같은 char값이면 배제한다.   
 
 아래는 aabbbaa 예이다.
 
 <img src="/doc/backjoon1342/picture1.png"> 
  
 이런식으로 자식 노드들 중 유망 노드만 탐색하면서 찾는다.
 
 collection 중 map을 이용하여 풀이하려했으나,
 
 
     private static void dfs(char parent, int level) {
         map.put(parent, map.get(parent) - 1);
         map.remove(parent, 0);
         backtrackList[level] = parent;
 
 
         if (level == backtrackList.length - 1) {
             result++;
             map.merge(parent, 1, Integer::sum);
             return;
         }
 
 
         for (char child : map.keySet()){
             if (isValid(child)) {
                 dfs(child, level + 1);
             }
         }
 
 
         map.merge(parent, 1, Integer::sum);
     }
 
 
     private static boolean isValid(char child) {
         return backtrackList[level] != child;
     }
 
 ConcurrentModificationException 이슈를 해결하지 못했다.  컬렉션을 순회하면서 데이터를 삭제할 때 발생하는 문제라 한다.   Document에는 iterator나 removeIf 같은 방법을 권장하나,  해결하지 못하였다.   다음에 다시 시도해봐야겠다. 
 
 그래서, 이번에는 permutation을 기반으로 풀이하려했다.
 
 
    private static void backtrack(int level, int target) {
     swap(level, target);
 
 
     if (level == backtrackList.length - 1) {
         result.add(Arrays.toString(backtrackList));
         return;
     }
 
 
     for (int i = level + 1; i < backtrackList.length; i++) {
         char childNode = backtrackList[i];
         if (isPromisingNode(childNode, level)) {
             backtrack(level + 1, i);
         }
     }
 
 
     swap(level, target);
    }
 
 다른 문제는 없었는데,  Arrays.toString(backtrackList)) 때문에 메모리 초과 문제가 났다.   Set을 사용하면 코드가 간결해져서 좋았는데,  String 때문에 사용할 수 없어 중복순열 방법을 선택했다.
 
 
    public static int solve(String input) {
         ...
         for (int i = 0; i < backtrackList.length; i++) {
             backtrack2(0, i);
         }
 
 
         for (int value : map.values()) {
             result /= factorial(value);
         }
         return result;
    }
 
    private static void backtrack2(int level, int target) {
         swap(level, target);
 
 
         if (level == backtrackList.length - 1) {
             result++;
             return;
         }
 
 
         for (int i = level + 1; i < backtrackList.length; i++) {
             char childNode = backtrackList[i];
             if (isPromisingNode(childNode, level)) {
                 backtrack(level + 1, i);
             }
         }
 
 
         swap(level, target);
     }
 
    private static int factorial(int value) {
         int sum = 1;
         for (int i = 1; i <= value; i++) {
             sum *= i;
         }
         return sum;
     }