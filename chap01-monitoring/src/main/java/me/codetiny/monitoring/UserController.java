package me.codetiny.monitoring;

import io.micrometer.core.instrument.Timer;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import me.codetiny.monitoring.section02.UserMetricsRecorder;
import me.codetiny.monitoring.section02.support.CounterRecorder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor // 생성자 주입을 생략을 위한 어노테이션
public class UserController {
    // 테스트용 인메모리 선언
    private final List<User> users = new ArrayList<>();

    // 메트릭 사용을 위한 DI
    private final UserMetricsRecorder userMetricsRecorder;

    // Gauge 를 통해 관리 할 객체를 넣어줌
    @PostConstruct
    public void initGauge() {
        // 인메모리 데이터인 user의 크기를 실시간 추적하여 size를 반환
        userMetricsRecorder.registerUserListSizeGauge(users);
    }

    /* record
    클래스를 간결하게 정의하기 위해서 도입 된 방식
    record의 필드는 기본적으로 final 로 선언되며, 명시적으로 다른 설정을 하지 않으면 불변 객체로 취급
    즉, setter가 존재하지 않는다.
     */
    record User(String id, String name, String email) {}

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {

        // 사용자 등록 시작 시에 Time을 기록할 메소드 호출
        Timer.Sample sample = userMetricsRecorder.startUserCreateTimer();

        // 0.5초
        sleep(500);

        // 기본적인 유효성 검사
        if (user.id() == null || user.name() == null || user.email() == null) {
            // 유효성 검사로 인한 등록 실패 시 메트릭 등록
            userMetricsRecorder.countCreateFailure("필수값이 누락되었습니다.");
            return ResponseEntity.badRequest().body("ID, NAME, EMAIL 은 필수입니다!");
        }

        // Users 객체에 동일한 id를 갖는 회원이 있어도 실패하게 만들기
        if (users.stream().anyMatch(u -> u.id().equals(user.id()))) {
            // 아이디 중복 상황에 대한 등록 실패 시 메트릭 등록
            userMetricsRecorder.countCreateFailure("중복 된 회원 ID 가 존재합니다!");
            // CONFILCT : 409 번 상태코드를 의미하며 현 서버의 상태와 충돌할 때 사용한다.
            return ResponseEntity.status(HttpStatus.CONFLICT).body(user.id() + "는 이미 존재합니다.");
        }

        // 조건문 통과 시 인메모리에 저장
        users.add(user);

        // 사용자 등록 성공시의 메트릭
        userMetricsRecorder.countUserCreateSuccess();

        // 사용자 등록 성공까지의 시간을 기록할 메트릭
        userMetricsRecorder.stopUserCreateTimer(sample, "status", "success");

        return ResponseEntity.status(HttpStatus.CREATED).body(user.id() + "등록 성공!");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<String> getUserById(@PathVariable("id") String id) {
        // 인메모리 데이터에서 id와 일치하는 User 추출
        Optional<User> user = users.stream().filter(u -> u.id().equals(id)).findFirst();

        // id와 일치하는 User가 있으면 200번
        if(user.isPresent()) {
            return ResponseEntity.ok(user.get().toString());
        } else{
            // 조회 실패 시 등록할 메트릭
            userMetricsRecorder.countLookupFailure();
            // id 와 일치하는 User가 없으면 404번
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,  id + "를 찾을 수 없습니다.");
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        // 인메모리 데이터에 저장된 모든 User를 반환
        return ResponseEntity.ok(users);
    }

    // 회원 아이디로 회원 삭제 관련
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") String id) {
        // ID 와 일치하는 객체를 인메모리 데이터인 users 에서 찾기
        Optional<User> user = users.stream()
                .filter(u -> u.id().equals(id)).findFirst();

        // id와 일치하는 User가 있으면 삭제
        if(user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(id + "는 존재하지 않습니다.");
        }
        // user 객체 users에서 제거
        users.remove(user.get());

        return ResponseEntity.ok(id + "를 삭제했습니다!");
    }

    // 사용자 등록 시에 시간을 끌기 위한 메소드
    private static void sleep(int i) {
        try {
            // 전달 받은 시간 +2초 내의 랜덤한 값으로 시간 끌기
            Thread.sleep(i + new Random().nextInt(2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
