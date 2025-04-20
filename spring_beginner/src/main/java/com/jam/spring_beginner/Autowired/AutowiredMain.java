package com.jam.spring_beginner.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/* @SpringBootApplication 은 아래의 역할을 함
1. @Configuration: 설정 클래스로 인식
2. @EnableAutoConfiguration: 자동 설정 활성화
3. @ComponentScan: 현재 패키지 기준으로 @Component를 검색해서 빈 등록
 */
public class AutowiredMain implements CommandLineRunner {
    // implements CommandLineRunner 이걸 하면 run(String... args) 메서드가 자동으로 실행됨, 즉, 앱 실행 직후 실행할 코드를 작성할 수 있는 곳

    private final HelloService helloService;

    public AutowiredMain (HelloService helloService) {
        this.helloService = helloService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AutowiredMain.class, args);
        // SpringApplication.run(...)을 통해 스프링 부트 앱을 실행함
    }

    @Override
    public void run(String... args) {  // run은 앱이 실행되면 자동으로 호출됨
        // String... args은 가변인자, String[] args랑 같은 말로써, args라는 String 배열을 의미
        helloService.sayHello();
    }
}
