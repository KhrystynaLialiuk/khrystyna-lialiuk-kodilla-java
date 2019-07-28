package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task createTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("Buy ", "candies ", 5);
            case PAINTING:
                return new PaintingTask("Paint ", "blue ", "wall.");
            case DRIVING:
                return new DrivingTask("Drive ", "to the shop ", "by car.");
            default:
                return null;
        }
    }
}
