package com.jam.spring_beginner.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloService {

    private final Printer printer; // Printer 타입의 bean이 주입될 자리
    /* final은 값 자체를 바꾸는걸 막는게 아니라, 참조가 바뀌지 않도록 막는 것, 따라서 객체의 내부 값을 바꾸는 건 가능하지만 객체 자체를 다른 객체로 바꾸는건 불가능
    - 객체: ArrayList, HashMap, Scanner, StringBuilder, 직접 만든 클래스 등 기본형 말고 내부 수정이 가능한 참조형 들(기본형 int, double, char, boolean 이 아닌건 전부 객체임!)
    ex) final List<String> list = new ArrayList<>();  // ✅ 참조 고정
        list.add("apple");  // ✅ 가능! 내부 데이터 변경
        list.remove("apple");  // ✅ 가능!

        final int x = 0;
        x = 1;  // ❌ 에러!
        => int는 참조가 아니라 값 자체이므로, 값을 바꾼다는건 그 자체를 다시 대입하는 거라 금지

     */

    @Autowired // 스프링이 Printer 타입의 구현체 Printer 클래스를 찾아서 이 메소드로 주입함
    public HelloService(Printer printer){
        this.printer = printer;
    }

    /* 위에는 생성자 주입 방식이고, setter 주입 방식이면 아래와 같음
        @Autowired
        public void setPrinter(Printer printer) {
            this.printer = printer;}
    - 생성자 주입의 의도: 진짜 필수인 의존성 final과 함께 사용0
    - setter 주입의 의도: 선택적, 변경 가능한 의존성
    - 순환참조 발생을 막기 위해선 setter 주입 방식이나 생성자 주입에서 @Lazy 사용
    !!! setter 주입 방식에선 필드에서 가져오는 변수에 final 쓰면생성자에선 꼭 변수를 초기화 해야하고, 꼭 필요한 의존성인걸 드러내면서, 객체 안정성을 높임
     */

    public void sayHello() {
        printer.print("오늘 먹은 초밥은 완벽했어");
    }

}
