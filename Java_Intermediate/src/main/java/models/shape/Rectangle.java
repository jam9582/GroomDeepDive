package models.shape;

import models.shape.Shape;

public class Rectangle extends Shape {
    private double a, b;

    public Rectangle(double a, double b) {
        super("사각형");
        this.a = a;
        this.b = b;
    }

    @Override
    public double getArea() {
        return a * b;
    }
}
