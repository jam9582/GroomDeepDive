package com.jam.spring_beginner.xml;


public class HelloService {

    private Printer printer;

    public void setPrinter (Printer printer) {
        this.printer = printer;
    }

    public void sayHello() {
        printer.print("xml 기반 스프링 설정 성공~!");
    }
}
