package com.kodilla.good.patterns.challenges.food2door;

import java.util.ArrayList;

public class OrderProcessor {

    private static final String POSITIVE_CONFIRMATION = "Your order has been successfully registered and is processed!";
    private static final String NEGATIVE_CONFIRMATION = "Product is not found or found in less quantity.";

    public void process(Order order, ConfirmationService confirmation) {
        boolean orderProcessed = false;
        ArrayList<Product> products = order.getManufacturer().getListOfProducts();
         for (Product product : products) {
             if (product.getProductId() == order.getProductId() &
                     product.getAvailableQuantity() >= order.getDesirableQuantity()) {
                 orderProcessed = true;
             }
         }
         if (orderProcessed) {
             confirmation.sendConfirmation(POSITIVE_CONFIRMATION);
         } else {
             confirmation.sendConfirmation(NEGATIVE_CONFIRMATION);
         }
    }
}
