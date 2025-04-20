package com.jam.spring_beginner.lifecycle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LifeCycleMain {

    public static void main(String[] args) {
        SpringApplication.run(LifeCycleMain.class, args);
    }

    @Bean
    public CommandLineRunner run(LifeCyclePrinter printer) {
        return args -> {
            printer.run();
        };
    }
}
