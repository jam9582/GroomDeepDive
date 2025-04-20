package com.jam.spring_beginner.javaConfig;

import com.jam.spring_beginner.javaConfig.model.Human;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfig.class) // configuration 클래스를 현재 앱에 등록
public class JavaConfigMain {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JavaConfigMain.class, args);
        /*
        - ApplicationContext: 스프링이 생성한 모든 bean을 담고 있는 컨테이너,
        spring이 만든 bean을 직접 꺼내오려면 context.getBean()을 사용해야 함,
        spring이 만든 객체를 내가 직접 꺼내 쓰는 방식,
        명령형 방식이어서 일반적인 자바 코드처럼 동작,
        main() 메서드 안에서 컨트롤 할 수 있는 자유도가 높음,
        여러 빈을 유연하게 조립할 때 좋음

        - 이전에 쓰던 CommandLineRunner는 spring이 자동으로 bean을 주입해서 실행해주는 구조,
        Human bean을 자동 주입(@Component)받아서 실행되고 앱 실행 직후 자동적으로 한번만 실행됨,
        초기 메시지나 테스트처럼 단순 실행에 씀
         */
        Human human = context.getBean(Human.class); // spring이 만든 Human bean을 꺼내와서 실행시켜주라는 말
        human.myPet();
    }
}
