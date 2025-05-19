package me.codetiny.monitoring.section01.intro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/test")
    public String hello() {
        log.info("test 핸들러 메소드 동작");
        return "안녕";
    }

}

