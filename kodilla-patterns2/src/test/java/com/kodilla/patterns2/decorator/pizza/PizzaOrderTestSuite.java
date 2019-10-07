package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;
import static org.junit.Assert.*;

public class PizzaOrderTestSuite {
    @Test
    public void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        BigDecimal theCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(15.00), theCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("Pizza base with cheese and tomato sauce", description);
    }

    @Test
    public void testPepperoniGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new PepperoniOrderDecorator(pizzaOrder);
        //When
        BigDecimal theCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(20.00), theCost);
    }

    @Test
    public void testPepperoniGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new PepperoniOrderDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("Pizza base with cheese and tomato sauce + pepperoni", description);
    }

    @Test
    public void testShrimpsSpinachGarlicSauceGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ShrimpsOrderDecorator(pizzaOrder);
        pizzaOrder = new SpinachOrderDecorator(pizzaOrder);
        pizzaOrder = new GarlicSauceOrderDecorator(pizzaOrder);
        //When
        BigDecimal theCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(26.00), theCost);
    }

    @Test
    public void testShrimpsSpinachGarlicSauceGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ShrimpsOrderDecorator(pizzaOrder);
        pizzaOrder = new SpinachOrderDecorator(pizzaOrder);
        pizzaOrder = new GarlicSauceOrderDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("Pizza base with cheese and tomato sauce + shrimps + spinach + garlic sauce", description);
    }

    @Test
    public void testBaconBbqSauceGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new BaconOrderDecorator(pizzaOrder);
        pizzaOrder = new BbqSauceOrderDecorator(pizzaOrder);
        //When
        BigDecimal theCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(21.00), theCost);
    }

    @Test
    public void testBaconBbqSauceGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new BaconOrderDecorator(pizzaOrder);
        pizzaOrder = new BbqSauceOrderDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("Pizza base with cheese and tomato sauce + bacon + BBQ sauce", description);
    }
}
