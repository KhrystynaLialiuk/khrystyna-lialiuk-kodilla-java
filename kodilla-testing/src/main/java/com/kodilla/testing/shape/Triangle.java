package com.kodilla.testing.shape;

public class Triangle implements Shape{

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public String getShapeName() {
        return "triangle";
    }

    public double getField() {
        double p = (sideA + sideB + sideC) / 2.0;
        return (Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC)));
    }

    @Override
    public String toString() {
        return "Triangle{sideA=" + sideA + ", sideB=" + sideB + ", sideC=" + sideC + "} with the field " + getField() + "/n";
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }
}
