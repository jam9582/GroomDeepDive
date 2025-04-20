package com.jam.spring_beginner.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudyAspect {

    @Before("execution(* com.jam.spring_beginner.aop.StudyService.study(..))")
    // (..)는 와일드카드로 parameter 0개 이상 이라는 의미, *는 아무 이름이나(한 단어), ..는 0개 이상의 패키지/파라미터
    /*
    "execution(* com.jam.spring_beginner.aop.StudyService.study(...))"
    이거는 포인트컷 표현식, StudyService의 study() 메소드가 타깃이라는 뜻
    포인트컷: aop를 적용할 지점(메소드)를 선택하는 필터 조건, 스프링에게 나 aop 적용할건데 이 메소드에만 해줘
    여기서는 @Before로 적용했으니 study() 메소드 전에만 aop를 적용하겠다는 뜻
    aop는 @Before, @Around, @After 같은 어노테이션에 포인트컷 식을 같이 넣어서만 사용가능
     */
    public void beforeStudy(JoinPoint joinPoint){ // JoinPoint joinPoint: AOP 대상 메소드에 대한 정보(메소드 이름, 파라미터, 객체 등)
        System.out.println("aop 메소드 실행 전: " + joinPoint.getSignature());
        // joinPoint.getSignature(): 실행되는 메소드의 시그니처(이름+파라미터 정보) 출력
    }
}
