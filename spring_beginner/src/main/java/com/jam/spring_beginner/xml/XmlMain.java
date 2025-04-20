package com.jam.spring_beginner.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        HelloService helloService = context.getBean("helloService", HelloService.class);
        helloService.sayHello();
    }
}
