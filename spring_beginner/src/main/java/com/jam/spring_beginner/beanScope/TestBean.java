package com.jam.spring_beginner.beanScope;

public class TestBean {
    public TestBean() { // 객체가 생성되었을 때 어떤 객체인지 로그로 확인하기 위한 용도
        System.out.println("bean 생성됨: " + this);
        /*
        - this: 현재 자기 자신을 가리키는 키워드, 즉, new TestBean() 할 때 만들어진 그 객체 자체
        - sout(this)는 객체의 주소처럼 생긴 값을 출력해줌, ex) com.jam.spring_beginner@1a2b3c
        - 그래서 같은 this면 같은 객체고, 다르면 다른 객체인걸 바로 알 수 있음

        => 근데 그렇다고 해시코드를 반환하는건 아님!!!!! 그냥 객체 자기 자신을 가리치큰 참조값을 의미
        public class TestBean {
            public TestBean() {System.out.println("this: " + this);}}
        이거하면 this: com.jam.spring_beginner.beanScope.TestBean@3a1f21 이런 결과가 나오는데
        이건 Object.toString()이 자동 호출된 결과여서
        내부적으로 System.out.println(this); 이건 System.out.println(this.toString()); 얘랑 같음!

        - 자바에서 Object.toString의 기본 구현:
        getClass().getName() + "@" + Integer.toHexString(hashCode())
        이렇게 생겨서 "클래스이름@16진수해시코드" 형태로 보이는 것

        따라서
        - this:객체 자기 자신
        - sout(this): 객체의 toString 출력
        - ToString() 기본 구현: 클래스명+해시코드
         */
    }
}
