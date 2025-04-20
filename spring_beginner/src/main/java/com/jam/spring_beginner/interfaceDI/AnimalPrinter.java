package com.jam.spring_beginner.interfaceDI;

import com.jam.spring_beginner.interfaceDI.model.Animal;
import org.springframework.stereotype.Component;

@Component
public class AnimalPrinter {

    private final Animal animal;

    public AnimalPrinter(Animal animal) {
        this.animal = animal;
    }

    public void print() {
        animal.sound();
    }
}
