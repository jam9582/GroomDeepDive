package me.codetiny.monitoring.section02.model;

public class MetricNames {
    // 커스텀 메트릭의 이름을 지정하기 이한 상수들의 집합 클래스
    public static final String USER_CREATE_TIMER = "app.user.create.time"; // 프로메테우스는 이 . 들을 전부 _ 로 바꿔서 이해함
    public static final String USER_CREATE_COUNTER = "app.user.create.count";
    public static final String USER_LOOKUP_FAILURE = "app.user.lookup,failure";
    public static final String USER_TOTAL_GAUGE= "app.user.total.gauge";
}
