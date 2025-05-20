package me.codetiny.monitoring.section01.intro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/test")
    public String hello() {
        log.info("test 핸들러 메소드 동작");
        return "안녕";
    }

    @PostMapping("/test")
    public String hello2() {
        log.info("test post 방식의 핸들러 메소드 동작");
        return "안녕2";
    }

    @GetMapping("/testCPU")
    public String testCPU() {
        long lnum = 0 ;
        for(long i = 0 ; i < 10000000000000000L; i++) {
            lnum++;
        }
        return "cpu가 힘들어 하는 것을 확인: " + lnum;
    }

    //Heap 메모리 공간을 과도하게 만들기 위한 List 선언
    private List<String> arr = new ArrayList<>();
    @GetMapping("/testHeap")
    public String heap() {
        for (int i=0 ; i<10000000 ; i++) {
            arr.add("heap 메모리 공간에 할당: " + i );
        }
        return "heap 메모리 공간 힘들게 만들기";
    }

}

