package com.jam.spring_beginner.proerties;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PropertiesMain {

    public static void main(String[] args) {
        SpringApplication.run(PropertiesMain.class, args);
    }

    @Bean
    public CommandLineRunner run(AnimalInfoPrinter printer){
        return args -> {
            printer.printInfo();
        };
    }
}
