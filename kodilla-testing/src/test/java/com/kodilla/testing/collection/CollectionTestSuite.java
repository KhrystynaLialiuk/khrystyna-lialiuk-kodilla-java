package com.kodilla.testing.collection;

import org.junit.Assert;
import org.junit.*;
import java.util.*;

public class CollectionTestSuite {
    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }
    @After
    public void after() {
        System.out.println("Test case: end");
    }
    @Test
    public void testOddNumbersExterminatorEmptyList() {
        // Given
        ArrayList<Integer> numbersList = new ArrayList<>();
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        // When
        System.out.println("Testing empty list.");
        ArrayList<Integer> result = exterminator.exterminate(numbersList);
        int numbersListSize = result.size();
        // Then
        Assert.assertEquals(0,numbersListSize);
    }
    @Test
    public void testOddNumbersExterminatorNormalList() {
        // Given
        ArrayList<Integer> numbersList = new ArrayList<>();
        numbersList.add(1);
        numbersList.add(2);
        numbersList.add(3);
        numbersList.add(4);
        numbersList.add(5);
        numbersList.add(6);
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        boolean isEven = true;
        // When
        System.out.println("Testing normal list.");
        ArrayList<Integer> result = exterminator.exterminate(numbersList);
        for (Integer num : result) {
            if (num % 2 != 0) {
                isEven = false;
                break;
            }
        }
        // Then
        Assert.assertTrue(isEven);
    }
}
