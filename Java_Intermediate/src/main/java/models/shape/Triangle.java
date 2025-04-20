package models.shape;

import models.shape.Shape;

public class Triangle extends Shape {
    private double a, b;

    public Triangle(double a, double b) {
        super("삼각형");
        this.a = a;
        this.b = b;
    }

    @Override
    public double getArea() {
        return a * b / 2;
    }
}
