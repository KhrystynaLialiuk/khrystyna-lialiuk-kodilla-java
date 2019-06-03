package com.kodilla.exception.test;

public class FirstChallenge {
    public double divide(double a, double b) throws ArithmeticException {
        double result = 0.0;

        try {
            if(b == 0) {
                throw new ArithmeticException();
            } else {
                result = a / b;
            }
        } catch (ArithmeticException e) {
            System.out.println("Error occurred: " + e);
        } finally {
            System.out.println("You can type new data!");
        }
        return result;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        //first test
        double result = firstChallenge.divide(3, 0);
        System.out.println(result);
        System.out.println();

        //second test
        double result1 = firstChallenge.divide(3, 2);
        System.out.println(result1);
    }
}
