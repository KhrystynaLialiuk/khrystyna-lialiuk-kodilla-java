package com.kodilla.testing.shape;

public class Square implements Shape {

    private double sideOfSquare;

    public Square(double sideOfSquare) {
        this.sideOfSquare = sideOfSquare;
    }

    public String getShapeName() {
        return "square";
    }

    public double getField() {
        return sideOfSquare * sideOfSquare;
    }

    @Override
    public String toString() {
        return "Square{sideOfSquare=" + sideOfSquare + "} with the field " + getField() + "/n";
    }

    public double getSideOfSquare() {
        return sideOfSquare;
    }
}
