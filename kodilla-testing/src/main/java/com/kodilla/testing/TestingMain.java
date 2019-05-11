package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();
        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        // next test
        System.out.println("The first unit test:");
        Calculator calculate = new Calculator();

        int addResult = calculate.add(5, 40);
        if (addResult == 45) {
            System.out.println("The add method works correctly");
        } else {
            System.out.println("Error in the add method");
        }

        int subtractResult = calculate.subtract(50, 10);
        if (subtractResult == 40) {
            System.out.println("The subtract method works correctly");
        } else {
            System.out.println("Error in the subtract method");
        }
    }
}
