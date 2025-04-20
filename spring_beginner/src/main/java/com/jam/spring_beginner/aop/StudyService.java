package com.jam.spring_beginner.aop;

import org.springframework.stereotype.Component;

@Component
public class StudyService {
    public void study(String subject){
        System.out.println("나는 " + subject + "를 공부중입니다.");
    }
}
