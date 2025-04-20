package com.jam.spring_beginner.interfaceDI;

import com.jam.spring_beginner.interfaceDI.model.Animal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InterfaceDIMain {

    public static void main(String[] args) {
        SpringApplication.run(InterfaceDIMain.class, args);
    }

    @Bean
    public CommandLineRunner run(AnimalPrinter printer) {
        return args -> {
            printer.print();
            /*
            - 만약 Printer 메소드에 static 붙이고 AnimalPrinter.print() 하면 객체 없이 바로 호출할 수 있게 됨
            - 이러면 spring이 직접 만든 객체가 아니라 스프링이 개입할 수 없게 되어 DI, transaction, aop 등이 불가능해지고 객체 지향에 위반됨
            - 객체 지향은 객체를 만들고 그 객체의 메소드를 호출하는 방식인데, static은 그냥 유틸 클래스나 전역 함수처럼 쓰는거라서 객체지향과 어긋남
            - 따라서 spring에서 bean으로 쓰려면 static 웬만하면 사용 x, 유틸 클래스나 static final 상수 선언 같은 상태가 없고 계산만 하는 함수에는 써도 됨
            */

        };
    }
}
