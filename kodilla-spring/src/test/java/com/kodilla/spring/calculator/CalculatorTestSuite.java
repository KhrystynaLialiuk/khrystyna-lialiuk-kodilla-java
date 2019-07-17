package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorTestSuite {

    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double sum = calculator.add(15, 3);
        double difference = calculator.sub(15, 3);
        double product = calculator.mul(15, 3);
        double quotient = calculator.div(15, 3);
        //Then
        Assert.assertEquals(18, sum, 0.01);
        Assert.assertEquals(12, difference, 0.01);
        Assert.assertEquals(45, product, 0.01);
        Assert.assertEquals(5, quotient, 0.01);
    }
}
