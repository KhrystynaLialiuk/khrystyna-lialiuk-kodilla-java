package com.kodilla.good.patterns.challenges.product_order_service;

public class MailService implements InformationService {

     public void sendInformation(Order order, String message) {
         System.out.println(order.getProduct() + order.getUser().getEmail() + message);
     }
}
