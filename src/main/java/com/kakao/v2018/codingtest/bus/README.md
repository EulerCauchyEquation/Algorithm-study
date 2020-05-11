# 2018 카카오 블라인드 코딩 테스트 : 셔틀 버스

* 날짜 : 20.05.11
* 언어 : Java
* IDE : IntelliJ IDEA community 

## 요구사항

<img src="/doc/kakao/2018/mocktest/bus/requirement.png"> 


## Description

어렵지는 않은 문제였다.  하나 집고 넘어가고 싶은 것은 시간 클래스를 적극적으로 사용해야겠다는 점이다.

원래는 시간 "hh:mm" 형태를 모두 총 분으로 변환해서 하나의 클래스를 만든 뒤 거기서 처리를 하고 이후에 다시 format를 사용해서 넘길려 하였다.  그런데, 이렇게 하지말고 LocalTime 클래스를 사용하니 간편하게 처리할 수 있었다.

```
final Bus lastBus = busList.getLast();
final int result = lastBus.isAvailable()
        ? lastBus.arriveTime
        : lastBus.passengers.getLast().time - 1;
return format(result);

...

static class Passenger {
    private final int time;

    public Passenger(String time) {
        this.time = getMinutes(time);
    }


    private int getMinutes(String time) {
        final String[] timeSection = time.split(":");
        return Integer.parseInt(timeSection[0]) * 60
                + Integer.parseInt(timeSection[1]);
    }
}
```

```
final Bus lastBus = busList.getLast();
final LocalTime result = lastBus.isAvailable()
        ? lastBus.arriveTime
        : lastBus.passengers.getLast().minusMinutes(1);
return result.toString();
```

시간 변수는 LocalTime를 기억해놓고 잘 사용해야겠다.