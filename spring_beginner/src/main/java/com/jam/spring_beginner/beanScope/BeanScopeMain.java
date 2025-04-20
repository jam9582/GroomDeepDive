package com.jam.spring_beginner.beanScope;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BeanScopeMain implements CommandLineRunner {

    private final ApplicationContext context; // 스프링 컨테이너

    public BeanScopeMain(ApplicationContext context) {
        this.context = context;
    }

    public static void main(String[] args) {
        SpringApplication.run(BeanScopeMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // singleton은 앱이 시작하는 이 시점에(run()) singletoneBean()이 실행되고 TestBean 객체가 만들어져서 스프링 컨테이너 안에 들어가있다
        // prototype은 요청할때 생성되므로 훨씬 뒤에 생성
        System.out.println("싱글톤 테스트");
        TestBean s1 = context.getBean("singletonBean", TestBean.class);
        /*
         -스프링 컨테이너(context)에서 등록된 bean을 가져오는 메소드(getBean)한 것
        - getBean()안에 매개변수로 Bean 이름(ScpoeConfig.java에서 등록한 메소드 이름)과, 반환 타입(형변환 생략용) 을 갖고 있다.
        => 스프링 컨테이너에게  singletonBean 이라는 이름으로 등록된 TestBean 객체를 하나 달라고 해서 s1 에 저장한다는 의미
         */
        TestBean s2 = context.getBean("singletonBean", TestBean.class);
        System.out.println("s1==s2 의 결과는: " + (s1 == s2));

        System.out.println("프로토타입 테스트");
        TestBean p1 = context.getBean("prototypeBean", TestBean.class); // prototype은 singleton과 다르게 요청한 이때 생성된다
        TestBean p2 = context.getBean("prototypeBean", TestBean.class);
        System.out.println("p1 == p2 의 결과는: " + (p1==p2));
        // 만약 객체 안의 값을 동일하게 맞춘다 하더라도 동일한 객체가 되진 않는다.
        // 메모리 상 같은 인스턴스인지 주소(참조값)을 비교하므로 new로 새로 만들면 다른 객체!

    }
}
