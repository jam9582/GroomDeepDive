package me.codetiny.monitoring.section02;

import lombok.RequiredArgsConstructor;
import me.codetiny.monitoring.section02.model.MetricNames;
import me.codetiny.monitoring.section02.model.MetricTags;
import me.codetiny.monitoring.section02.support.CounterRecorder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // 생성자 주입 귀찮아서 달아둔 것
public class UserMetricsRecorder {

    // 특정 이벤트가 발생 할 때 횟수를 누적해서 측정하는 레코더
    private final CounterRecorder counter;

    /* 사용자 등록이 성공 했을 때 호출
        매트릭 이름: app.user.create.count
        태그: status=success
        전체 요청 대비 성공률 확인용
         */
    public void countUserCreateSuccess() {
        counter.increment(MetricNames.USER_CREATE_COUNTER
                 , MetricTags.STATUS, "success");
    }
}
