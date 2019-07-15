package com.kodilla.good.patterns.challenges.product_order_service;

public class OrderService {
    public static void main(String[] args) {
        OrderRetriever orderRetriever = new OrderRetriever();
        Order order = orderRetriever.retrieve();
        OrderProcessor orderProcessor = new OrderProcessor();
        Repository repository = new Repository();
        InformationService mail = new MailService();
        orderProcessor.processOrder(order, repository, mail);
    }
}
