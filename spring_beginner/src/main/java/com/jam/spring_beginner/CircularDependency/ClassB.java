package com.jam.spring_beginner.CircularDependency;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ClassB {
    private final ClassA classA;

    public ClassB(@Lazy ClassA classA){ //@Lazy: 얘는 일단 나중에 주입하라는 의미
        this.classA = classA;
    }
    /*
    - 바로 위에 생성자+@Lazy 문단 아니면 setter+@Aurowired로 아래처럼 해도 됨
    - 객체 생성 전에 의존 객체가 무조건 있어야 하는 생성자와 달리, setter는 객체는 일단 생성 가능하고 이후에 의존 객체를 나중에 주입하는 방식
    - @Autowired는 스프링이 해당 메소드(setClassA)를 통해 자동으로 의존성 주입(classA에 메소드 넣기)을 하게 해줌, 메소드를 자동으로 호출해주는 일을 스프링이 해주는 것

    public ClassB() {} => 자바에서는 아무 생성자도 없을때, 생성자를 명시적으로 안 써도 자바가 자동으로 넣어줌, 이래서 생성자 따로 안 써주고 setter만 써도 작동이 됐던 것
    *하지만 다른 생성자(파라미터 있는 생성자)를 하나라도 선언했으면 기본 생성자는 더 이상 자동 생성되지 않음!

    => class에 생성자가 하나뿐이면 @Autowired 안 붙여도 알아서 spring이 내가 넣어줄게 함
    => setter 주입의 경우에는 생성자가 몇개든 상관없이 @Autowired를 항상 붙여줘야한다!

    @Autowired
    public void setClassA(ClassA classA) {
        this.classA = classA;
    }
     */

    public void hello() {
        System.out.println("안녕 난 b야");
    }
}