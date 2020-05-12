# 2018 카카오 블라인드 코딩 테스트 : 추석 트래픽

* 날짜 : 20.05.12
* 언어 : Java
* IDE : IntelliJ IDEA community 

## 요구사항

<img src="/doc/kakao/2018/mocktest/traffic/requirement.png"> 

## Description

이번 문제는 트래픽의 시작 시간과 종료 시간을 확인해서 1초 동안 최대 몇 개가 겹치는지 묻는 문제였다.
파싱하는 것은 어렵지 않다.  LocalDateTime 클래스를 이용하면 아주 손쉽게 해결할 수 있다.

```
LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
```

문제는 1초 동안 최대 몇 개 겹치는 지 분석하는게 핵심이었다.  직관적으로 바로 생각할 수 있는 것은 1ms 단위씩 증가하면서 1초동안 몇 개 겹치는 지 체크하는 방법이 있다. 하지만 이것은 시간 복잡도가 어마어마 할 것이다.  

그래서 사용한 방법은 1초를 늘리는 방법을 선택했다.  우리가 구하고 싶은 것은 그 순간을 계산하는 것이 아닌, 1초 구간의 처리량이므로,  1초를 늘려 구하면 1ms씩 구간 로테이션을 돌릴 필요 없이 딱 한 번만 로테이션 돌려서 구할 수 있다.  

<img src="/doc/kakao/2018/mocktest/traffic/explanation1.png">

그래서 시작 시간은 end - 처리한 시간이 아니라 end - 처리한 시간 - 0.999를 한다.   해서 시간들을 모두 수집해서 sort한 뒤 분석을 한다.  start이면 +1을 하고, end이면 -1을 한다.  그러면, 구하는 과정에서 count가 가장 높은 값이 정답이 된다.  따라서, 시간 복잡도는 O(nlogn)이 도출된다.

```
private static LocalDateTime getStartTime(LocalDateTime end, String time) {
    final String[] parse = time.split("[.s]");
    final int second = Integer.parseInt(parse[0]);
    final int millisecond = (parse.length == 1) ? 0
            : Integer.parseInt(parse[1]) * 1000000;

    return end.minusSeconds(second)
            .minusNanos(millisecond)
            .minusNanos(999000000);
}
```