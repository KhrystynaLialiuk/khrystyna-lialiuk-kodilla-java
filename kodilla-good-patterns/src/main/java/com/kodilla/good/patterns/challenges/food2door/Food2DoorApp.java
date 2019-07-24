package com.kodilla.good.patterns.challenges.food2door;

public class Food2DoorApp {
    public static void main(String[] args) {
        OrderInformation orderInformation = new OrderInformation();
        Order theOrder = orderInformation.retrieve();
        PopUpMessage popUpMessage = new PopUpMessage();
        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.process(theOrder, popUpMessage);
    }
}
