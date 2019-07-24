package com.kodilla.good.patterns.challenges.food2door;

public class Product {
    private int productId;
    private String productType;
    private String productTitle;
    private int availableQuantity;

    public Product(int productId, String productType, String productTitle, int availableQuantity) {
        this.productId = productId;
        this.productType = productType;
        this.productTitle = productTitle;
        this.availableQuantity = availableQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }
}
