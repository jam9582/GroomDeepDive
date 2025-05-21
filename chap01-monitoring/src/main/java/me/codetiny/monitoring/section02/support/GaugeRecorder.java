package me.codetiny.monitoring.section02.support;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/*
micrometer 의 gauge를 사용해서 특정 컬렉션의 크기를 실시간으로 측정하는 컴포넌트 클래스
컬렉션: List<User>
컬렉션의 현재 크기를 gauge 메트릭으로 노출
 */
@Component
@RequiredArgsConstructor
public class GaugeRecorder {

    private final MeterRegistry registry;

    /*
    지정 된 이름으로 gauge 메트릭을 등록하고,
    주어진 리스트의 크기를 실시간으로 측정하여 gauge 에 반영한다.
    리스트의 크기가 변경 될 때마다 gauge 의 값을 업데이트
    메트릭 name: "app.user.total"
    list: 크기를 측정할 컬렉션 객체
     */
    public void registerListSize(String name, List<?> list) {
        registry.gauge(name, list, List::size);
    }
}
