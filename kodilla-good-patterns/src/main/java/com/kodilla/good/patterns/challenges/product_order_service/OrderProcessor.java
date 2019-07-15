package com.kodilla.good.patterns.challenges.product_order_service;

public class OrderProcessor {

    private static final String POSITIVE_CONFIRMATION = "Your order has been registered and is processed!";
    private static final String NEGATIVE_CONFIRMATION = "Unfortunately the product you have chosen is unavailable.";

    public void processOrder(Order order, Repository repository, InformationService informationService) {
        if (order.getProduct().isAvailable()) {
            repository.getOrdersQueue().add(order);
            informationService.sendInformation(order, POSITIVE_CONFIRMATION);
        } else {
            informationService.sendInformation(order, NEGATIVE_CONFIRMATION);
        }
    }
}
