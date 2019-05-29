package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Beginning of all tests:");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure(){
        // Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Circle(1);
        // When
        shapeCollector.addFigure(shape);
        // Then
        Assert.assertEquals(1, shapeCollector.getShapes().size());
    }

    @Test
    public void testRemoveFigure() {
        // Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Circle(1);
        shapeCollector.addFigure(shape);
        // When
        boolean result = shapeCollector.removeFigure(shape);
        // Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, shapeCollector.getShapes().size());
    }

    @Test
    public void testRemoveNotExistingFigure(){
        // Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Circle(1);
        // When
        boolean result = shapeCollector.removeFigure(shape);
        // Then
        Assert.assertFalse(result);
    }

    @Test
    public void testGetFigure() {
        // Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Circle(1);
        shapeCollector.addFigure(shape);
        // When
        Shape retrievedShape = shapeCollector.getFigure(0);
        // Then
        Assert.assertEquals(shape, retrievedShape);
    }

    @Test
    public void testGetNotExistingFigure(){
        // Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Circle(1);
        shapeCollector.addFigure(shape);
        // When
        Shape retrievedShape = shapeCollector.getFigure(1);
        // Then
        Assert.assertNull(retrievedShape);
    }

    @Test
    public void testShowFigures(){
        // Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Circle(1);
        shapeCollector.addFigure(shape);
        // When
        String printedShape = shapeCollector.showFigures();
        // Then
        Assert.assertEquals(shape.toString(), printedShape);
    }

    @Test
    public void testShowFiguresWhenListEmpty(){
        // Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Circle(1);
        // When
        String printedShape = shapeCollector.showFigures();
        //Then
        Assert.assertEquals("", printedShape);
    }
}
