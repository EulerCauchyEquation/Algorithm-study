# CodingTestAlgorithm

* 날짜 : 20.05.10
* 언어 : Java
* IDE : IntelliJ IDEA community 

## 요구사항

<img src="/doc/kakao/2018/mocktest/dart/requirement.png"> 


## Description

위 문제는 뭐 생각보다 별거없다. 그런데,  구현을 좀 더 가독성을 높이기 위해서 다듬어봤다.

```
public static int solution(String dartResult) {
    final char[] result = dartResult.toCharArray();
    final StringBuilder score = new StringBuilder();
    char bonus;
    char option = '$';
    stack = new Stack<>();
    stack.push(0);


    for (int i = 0; i < result.length; i++) {
        if (Character.isDigit(result[i])) {
            score.append(result[i]);
        } else if (Character.isLetter(result[i])) {
            if (i + 1 < result.length
                    && !Character.isDigit(result[i + 1])) {
                option = result[i + 1];
            }
            bonus = result[i];
            calculate(score, bonus, option);


            score.setLength(0);
            option = '$';
        }
    }


    int sum = 0;
    while (!stack.isEmpty()) {
        sum += stack.pop();
    }
    return sum;
}
```


처음에는 이렇게 구현했다. 그런데 아무리 봐도 형태가 마음에 들지 않았다.  코드가 얼마 안되는 길이이지만,  가독성이 좋아 보이지 않았다.  아무래도 숫자가 1~10이고, 뒤에 option이 있을수도 없을수도 있다는 요구사항이 문제였다.  가볍게 if else문으로 충분히 해결 가능하지만, 뭔가 좀 더 깔끔하게 짤 수 없을까 생각을 해봤다.  

아무래도 가장 좋은 것은 정규표현식으로 잘 파싱만 할 수 있다면, 좋을 것 같아서 이리저리 해봤다.

```
public static int solution(String dartResult) {
    stack = new Stack<>();
    stack.push(0);
    final String[] resultSet = dartResult
            .split("((?<=[SDT])(?=\\d))|((?<=[*#])(?=\\d))");
    for (String result : resultSet) {
        calculate(result);
    }


    int sum = 0;
    while (!stack.isEmpty()) {
        sum += stack.pop();
    }
    return sum;
}

private static void calculate(String result) {
    final String[] section = result.split("(?=[SDT])|(?=[*#])");
    final int score = Integer.parseInt(section[0]);
    final char bonus = section[1].charAt(0);
    final char option = (section.length == 3) ? section[2].charAt(0) : '$';


    if (bonus == 'D') {
        stack.push((int) Math.pow(score, 2));
    } else if (bonus == 'T') {
        stack.push((int) Math.pow(score, 3));
    }


    if (option == '*') {
        final int prev = stack.pop();
        stack.push(prev * 2);
        stack.push(score * 2);
    } else if (option == '#') {
        final int top = stack.pop();
        stack.push(-top);
    } else {
        final int top = stack.pop();
        stack.push(top);
    }
}
```

생각보다 시간이 많이 걸렸다.  이게 구분자가 없는 형태를 split할 때 고민을 안 해봤는데,  생각보다 까다로웠다.   이번에 하면서 정규표현식의 look around 형태를 알게됐다.  너무 유용한 기능이였다.   정규표현식을 한 번더 점검해볼 필요가 있는 것 같다.  
