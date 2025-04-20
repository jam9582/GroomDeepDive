package com.jam.spring_beginner.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class LifeCyclePrinter {

    public LifeCyclePrinter(){ // 이건 반환타입이 없으므로 생성자! 클래스명과 완벽히 일치해야함
        System.out.println("1. LifeCyclePrinter 생성자 호출 완료");
    }

    @PostConstruct
    public void start() {
        System.out.println("2. @PostConstruct: 빈 초기화 완료");
    }

    public void run() {
        System.out.println("3. 메인 비즈니스 로직 실행 중");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("4. @PreDestroy: bean 소멸 직전 정리 중");
    }

}
