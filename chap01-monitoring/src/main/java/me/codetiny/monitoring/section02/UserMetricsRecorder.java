package me.codetiny.monitoring.section02;

import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import me.codetiny.monitoring.section02.model.MetricNames;
import me.codetiny.monitoring.section02.model.MetricTags;
import me.codetiny.monitoring.section02.support.CounterRecorder;
import me.codetiny.monitoring.section02.support.GaugeRecorder;
import me.codetiny.monitoring.section02.support.TimerRecorder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor // 생성자 주입 귀찮아서 달아둔 것
public class UserMetricsRecorder { // 여기서 사용자 정의의 메트릭 만듦

    // 특정 이벤트가 발생 할 때 횟수를 누적해서 측정하는 레코더
    private final CounterRecorder counter;

    // 특정 작업의 소요 시간을 측정하고 통계(평균, 최대, 백분위)를 제공하는 레코더
    private final TimerRecorder timer;

    // 특정 시점의 단일 값(현재 활성 사용자)을 추적하기 위한 gauge 레코더
    private final GaugeRecorder gauge;

    /* 사용자 등록이 성공 했을 때 호출
        매트릭 이름: app.user.create.count
        태그: status=success
        전체 요청 대비 성공률 확인용
         */
    public void countUserCreateSuccess() {
        counter.increment(MetricNames.USER_CREATE_COUNTER
                 , MetricTags.STATUS, "success");
    }

    /* 사용자 등록이 실패 횟수 카운트 + 실패에 대한 사유 분류
        매트릭 이름: app.user.create.count
        태그: status=failure, reason={실패사유}
        validation 오류, 중복 ID 등에 대한 패턴을 식별
        /app.user.create.count?tad=status:success 이런 식으로 식별해 볼 것
         */
    public void countCreateFailure(String reason) {
        counter.increment(MetricNames.USER_CREATE_COUNTER
                , MetricTags.STATUS, "failure", MetricTags.REASON, reason);
    }
    // 이 메트릭을 비즈니스 로직 사이사이에 끼워넣어 볼 것

    /* 사용자 상세 조회 실패 시에 404 카운트
    메트릭 이름 : app.user.lookup.failure
    태그 : status=404
    존재하지 않는 ID 요청 탐지 혹은 비정상 패턴 추적용도
     */
    public void countLookupFailure() {
        counter.increment(
                MetricNames.USER_LOOKUP_FAILURE
                , MetricTags.STATUS, "404"
        );
    }

    // 사용자 등록 처리 시간 측정, 측정 시작 시 호출한다.
    public Timer.Sample startUserCreateTimer() {
        return timer.start();
    }

    /* 사용자 등록 처리 시간 측정 종료 시 호출
    Timer 메트릭 사용 목적: 응답 지연 감지, 등록 처리 병목 분석을 위한 처리 시간 분석
    메트릭 이름: app.user.create.time
     */
    public void stopUserCreateTimer(Timer.Sample sample, String... tags) {
        timer.stop(sample, MetricNames.USER_CREATE_TIMER, tags);
    }

    /* 현재 인메모리 데이터에 저장된 User를 실시간 추적
    메트릭 이름: app.user.total
    전체 사용자 증가/감소에 따른 추이를 분석하여 서비스의 성장을 추적하기 위한 용도
    사용 위치: controller의 @PostConstruct
    주의사항: gauge는 중복 등록 시에 충돌이 발생할 가능성이 있으므로 @PostConstruct를 통해 최초 1회만 등록 해야함,
    해당 List가 변경 시에 Gauge 값이 자동으로 업데이트가 되게 관리
     */
    public void registerUserListSizeGauge(List<?> users) {
        gauge.registerListSize(MetricNames.USER_TOTAL_GAUGE, users);
    }
}
