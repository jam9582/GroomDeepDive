package com.jam.spring_beginner.CircularDependency;

import org.springframework.stereotype.Component;

@Component
public class ClassA {
    private final ClassB classB;

    public ClassA(ClassB classB){
        this.classB = classB;
    }

    public void hello() {
        System.out.println("안녕 나는 A야");
    }
}
