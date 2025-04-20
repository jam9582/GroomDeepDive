package com.jam;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Bean bean = context.getBean("helloBean", Bean.class);
        bean.Hello();


    }
}