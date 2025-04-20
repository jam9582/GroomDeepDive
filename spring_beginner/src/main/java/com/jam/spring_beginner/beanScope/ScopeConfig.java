package com.jam.spring_beginner.beanScope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopeConfig {

    @Bean
    @Scope("singleton") // singleton: 스프링 컨테이너 안에 단 하나만 존재, 요청해도 같은 인스턴스 계속 반환, 기본 default 설정
    public TestBean singletonBean() { // 싱글톤 객체가 하나일 뿐이지, 그 안의 값은 마음대로 변경 가능
        return new TestBean();
    }

    @Bean
    @Scope("prototype") // prototype: 요청할 때마다 새로운 객체 생성해서 반환
    public TestBean prototypeBean() {
        return new TestBean();
    }
}
