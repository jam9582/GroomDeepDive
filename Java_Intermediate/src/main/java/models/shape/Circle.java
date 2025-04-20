package models.shape;

import models.shape.Shape;

public class Circle extends Shape {
    private double r;

    public Circle(double r) {
        super("원");
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }
}
