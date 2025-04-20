package com.jam.spring_beginner.interfaceDI.model;

public interface Animal {
    void sound(); // 어떤 동물이든 이 메소드는 있어야 한다는 뜻
}

/*
- 얘한테는 @Component 안 쓰는 이유는 구현체에만 붙이면 충분하기 때문
- 지금 얘는 단순히 설계용 계약서 같은 것
- 인터페이스는 모두 객체가 아니고 그냥 설계도(기능 약속)이어서 객체를 bean으로 등록하겠다는 @Component 안 붙여도 됨
- interface에 @Component 붙여도 오류는 안 나는데 의미가 없음
 */