package com.jam.spring_beginner.Autowired;

import org.springframework.stereotype.Component;

@Component
public class Printer {

    public void print(String message) {
        System.out.println("메시지 출력: " + message);
    }
}
