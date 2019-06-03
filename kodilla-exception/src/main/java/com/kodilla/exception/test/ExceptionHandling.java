package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args){
        SecondChallenge secondChallenge = new SecondChallenge();

        // first test
        try {
            System.out.println(secondChallenge.probablyIWillThrowException(1, 3));
        } catch (Exception e){
            System.out.println("Entry data cannot be used in a method probablyIWillThrowException()");
        } finally {
            System.out.println("Continue!\n");
        }

        //second test
        try {
            System.out.println(secondChallenge.probablyIWillThrowException(2, 3));
        } catch (Exception e){
            System.out.println("Entry data cannot be used in a method probablyIWillThrowException()");
        } finally {
            System.out.println("Continue!\n");
        }
    }
}
