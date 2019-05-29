package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape){
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        boolean removed = false;
        if (shapes.contains(shape)){
            shapes.remove(shape);
            removed = true;
        }
        return removed;
    }

    public Shape getFigure(int n){
        Shape shape = null;
        if (n >= 0 && n < shapes.size()) {
            shape = shapes.get(n);
        }
        return shape;
    }

    public String showFigures(){
        StringBuilder result = new StringBuilder();
        for (Shape shape : shapes) {
            result.append(shape);
        }
        return result.toString();
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }
}
