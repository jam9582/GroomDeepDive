package me.codetiny.monitoring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    // 테스트용 인메모리 선언
    private final List<User> users = new ArrayList<>();

    /* record
    클래스를 간결하게 정의하기 위해서 도입 된 방식
    record의 필드는 기본적으로 final 로 선언되며, 명시적으로 다른 설정을 하지 않으면 불변 객체로 취급
    즉, setter가 존재하지 않는다.
     */
    record User(String id, String name, String email) {}

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        // 기본적인 유효성 검사
        if (user.id() == null || user.name() == null || user.email() == null) {
            return ResponseEntity.badRequest().body("ID, NAME, EMAIL 은 필수입니다!");
        }

        // Users 객체에 동일한 id를 갖는 회원이 있어도 실패하게 만들기
        if (users.stream().anyMatch(u -> u.id().equals(user.id()))) {
            // CONFILCT : 409 번 상태코드를 의미하며 현 서버의 상태와 충돌할 때 사용한다.
            return ResponseEntity.status(HttpStatus.CONFLICT).body(user.id() + "는 이미 존재합니다.");
        }

        // 조건문 통과 시 인메모리에 저장
        users.add(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user.id() + "등록 성공!");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<String> getUserById(@PathVariable("id") String id) {
        // 인메모리 데이터에서 id와 일치하는 User 추출
        Optional<User> user = users.stream().filter(u -> u.id().equals(id)).findFirst();

        // id와 잋리하는 User가 있으면 200번
        if(user.isPresent()) {
            return ResponseEntity.ok(user.get().toString());
        } else{
            // id 와 일치하는 User가 없으면 404번
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,  id + "를 찾을 수 없습니다.");
        }

    }

}
