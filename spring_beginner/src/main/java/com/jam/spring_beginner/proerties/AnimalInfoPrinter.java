package com.jam.spring_beginner.proerties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AnimalInfoPrinter {

    @Value("${animal.species}")
    /*원래 문법 이렇게 생김 @Value("${config 파일의 설정 key}"), 스프링이 bean 생성할 때 값이 주임되고 간단한 값 주입에 적합
    @Value는 application.properties나 .yml에 자동으로 연결되고 그 안에 있는 key값만 주입받을 수 있음
    spring boot는 애플리케이션을 실행할 때, 위의 설정 파일들을 내부적으로 Environment 객체에 저장해둠, @Value는 이 안의 값을 가져다 쓰는 것
    */
    private String species;

    @Value("${animal.sound}") // @Value("${animal.sound:소리없음}"), 이런 느낌으로 key값 없을 때 default값도 설정 가능
    private String sound;

    public void printInfo(){
        System.out.println("동물의 종류: " + species);
        System.out.println("동물이 말하고 있습니다. \n" + sound);
    }
}
