package com.jam.spring_beginner.javaConfig.model;

public class Human {

    private final Animal pet;

    public Human (Animal pet) {
        this.pet = pet;
    }

    public void myPet() {
        System.out.println("우리집 왈왈이: ");
        pet.sound();
    }
}
