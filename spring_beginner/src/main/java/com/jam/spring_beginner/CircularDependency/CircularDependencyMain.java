package com.jam.spring_beginner.CircularDependency;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
- 순환 의존성(Circular Denpendency): 두개 이상의 객체가 서로를 의존해서, bean 생성 시 꼬여버리는 상황
- 스프링이 A를 만들려면 B가 필요하고, B를 만들려면 다시 A가 필요함, 누굴 먼저 만들어야 할지 몰라서 오류 발생
=> 따라서 해결책이 생성자+@Lazy로 나중에 필요할 때 주입하도록 미루는 것과, setter+@Autowired 주입의 2가지가 있음

- @Autowired를 안쓰면 내가 매번 a.setB(b) 해야되는걸, @Autowired 해주면 그냥 b라고만 해도 호출이 되서 편함
*/

@SpringBootApplication
public class CircularDependencyMain implements CommandLineRunner {

    private final ClassA classA;

    public CircularDependencyMain(ClassA classA){
        this.classA=classA;
    }

    public static void main(String[] args) {
        SpringApplication.run(CircularDependencyMain.class, args);
    }

    @Override
    public void run(String... args){
        classA.hello();
    }

}
