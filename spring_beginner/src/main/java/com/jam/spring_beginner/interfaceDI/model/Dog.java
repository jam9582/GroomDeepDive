package com.jam.spring_beginner.interfaceDI.model;
import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {

    @Override
    public void sound(){
        System.out.println("왈왈");
    }
}
