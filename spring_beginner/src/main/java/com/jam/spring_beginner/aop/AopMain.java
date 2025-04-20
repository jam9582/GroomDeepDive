package com.jam.spring_beginner.aop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopMain implements CommandLineRunner {
    /*  애플리케이션 실행 후 한번만 실행할 로직을 넣을 수 있게 해주는 인터페이스를 구현한 것
    클래스가 직접 CommandLineRunner 구현하면 run() 메소드가 자동으로 실행되어서 훨씬 간단히 처리 가능
    대신 아래에 @Override로 되어있는 코드 한 문단도 써줘야 함

    CommandLineRunner는 아래 메소드를 정의하도록 강제하는 인터페이스
    @FunctionalInterface
    public interface CommandLineRunner {
        void run(String... args) throws Exception;
    }

    전에 써왔던 얘랑 완전히 똑같은 문법
    @Bean
    public CommandLineRunner run(GreetingService greetingService) {
    return args -> { // 여기서의 args도 그냥 변수명이므로 얼마든지 변경해도 됨, 단순히 함수의 파라미터일 뿐
            StudyService.study("내용");
        };
    } */

    private final StudyService studyService; // 생성자 주입 방식으로 의존성 주입 받음

    public AopMain (StudyService studyService){
        this.studyService = studyService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AopMain.class, args);
    }

    @Override
    public void run(String... args) {
        /* 애플리케이션 실행 직후 호출되는데, 이 안의 study 메소드 호출 전에 Aspect의 beforeStudy()가 먼저 실행됨
        여기서 ... 은 가변인자,자바 문법 중 하나로 사실상 배열처럼 동작함, String[] args와 거의 같지만 메소드 호출할 때 "a","b","c" 처럼 개별 전달 가능
        따라서 ... 대신에 [] 써서 String[] args해도 문제 없음! []은 정통적인 고정된 배열이고 ... 는 가변인자를 받을 수 있는 짧고 직관적인 배열
        다만 이 케이스 말고 다른데서도 막 혼용하면 안되는 경우도 있음, 가변인자 ...는 반드시 파라미터 목록의 마지막에만 올 수 있음, 대부분 혼용 가능
        String... args는 동적으로 파라미터 개수를 받을 수는 있지만 실제로 메소드 안에 들어가면 그냥 String[] 배열이므로 크기 조절은 불가능
        String은 배열의 자료형, args는 배열의 이름, args는 다른걸로 바꿔도 되지만 main() 영향으로 관습적으로 args 많이 씀
         */
        studyService.study("React.js");
    }
}

/*
- AOP: 핵심 로직 외에 공통된 부가기능을 븐리하는 방식
ex) 로깅, 보안, 트랜잭션, 실행시간 측정 등에 쓰임

- Aspect: aop기능을 담고 있는 클래스
ex) 로깅 클래스, 트랜잭션 클래스 등

- Advice: 실제 실행되는 부가기능 메소드
ex) 메소드 실행 전에 로그 출력

- pointcut: advice를 적용할 대상 메소드 선택 조건, execution 얘가 포인트컷
ex) StudyService의 study()에만 적용
 */