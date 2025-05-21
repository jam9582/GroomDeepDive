package me.codetiny.monitoring.section02.support;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/*
micrometer 의 timer를 사용해서 특정 이벤트의 소요 시간 측정 및 기록을 하는 컴포넌트
특정 작업의 시작 시간과 종료 시간을 특정하여 평균, 최대 작업 시간, 백분위
이런 것을 수집할 수 있다.
 */
@Component
@RequiredArgsConstructor
public class TimerRecorder {

    private final MeterRegistry registry;

    /*
    timer 측정을 시작하고 sample 객체를 반환하게 된다.
    반환이 된 sample 객체는 stop() 메서드 호출 시에 사용되어 측정 시간을 기록하게 된다.

    @return : Timer 측정 시작 시점의 Sample 객체
     */
    public Timer.Sample start() {
        return Timer.start(registry);
    }

    /*
    Timer 측정 종료하고 지정된 이름과 태그를 사용해서 측정이 된 시간을 기록한다.

    sample: start() 메소드로부터 반환된 Sample 객체
    name: Timer 메트릭의 이름 ex) "app.user.login.time"
    tags: Timer 메트릭에 추가할 태그(key-value 쌍으로 전달)
    ex) key-value / "status", "success", "method", "post"
    {"status" : "success"}
     */
    public void stop(Timer.Sample sample, String name, String ...tags) {
        sample.stop(
                Timer.builder(name)
                        .tags(tags)
                        .register(registry)
        );
    }
}
