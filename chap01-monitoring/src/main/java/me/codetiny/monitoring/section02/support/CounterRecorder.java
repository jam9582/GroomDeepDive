package me.codetiny.monitoring.section02.support;

// micrometer 의 counter를 사용해서 특정 이벤트의 발생 횟수를 기록하는 컴포넌트 클래스
// 다양한 태그를 사용하여 counter를 세분화하여 추적할 수 있다.

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class CounterRecorder {

    /*
    MeterRegistry
    micrometer의 핵심 인터페이스로, app의 매트릭을 등록하고 관리하는 역할을 수행하게 된다
    다양한 매트릭 타입(Counter, Timer, Gauge)를 생성 및 등록
    등록 된 매트릭들은 prometheus 을 전송하는 것에 사용될 것이다.
    - 메트릭 저장고
     */

    private final MeterRegistry registry;

    // 해당 컴포넌트에서 MeterRegistry를 사용하기 위한 DI
    public CounterRecorder(MeterRegistry registry) {
        this.registry = registry;
    }

    // 메트릭 이름과 태그들 전달
    // ...은 가변인자
    // 지정된 이름과 태그를 가진 Counter 의 값을 1만큼 증가시킨다.
    // @param name : Counter 의 이름(ex) "app.user.login.count")
    // @param tags : Counter 에 추가할 태그(key-value 쌍으로 전달 ex) "status", "success", "method", "post")
    public void increment(String name, String ...tags) { // counter가 보면 변수로 가변인자를 받아서 매개변수도 똑같이 맞춰준 것
        registry.counter(name, tags).increment();
    }
}
