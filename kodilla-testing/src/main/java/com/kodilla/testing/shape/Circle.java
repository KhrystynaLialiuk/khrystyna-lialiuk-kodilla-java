package com.kodilla.testing.shape;

public class Circle implements Shape{

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public String getShapeName() {
        return "circle";
    }

    public double getField() {
        return (3.14 * radius * radius);
    }

    @Override
    public String toString() {
        return "Circle{radius=" + radius + "} with the field " + getField() + "/n";
    }

    public double getRadius() {
        return radius;
    }
}
