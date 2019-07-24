package com.kodilla.good.patterns.challenges.food2door;

public class PopUpMessage implements ConfirmationService {
    public void sendConfirmation(String message) {
        System.out.println(message);
    }
}
