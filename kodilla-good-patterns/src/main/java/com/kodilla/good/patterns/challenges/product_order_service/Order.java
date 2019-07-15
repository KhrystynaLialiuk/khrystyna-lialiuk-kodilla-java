package com.kodilla.good.patterns.challenges.product_order_service;

public class Order {
    private User user;
    private Supplier supplier;
    private Product product;

    public Order(User user, Supplier supplier, Product product) {
        this.user = user;
        this.supplier = supplier;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Product getProduct() {
        return product;
    }
}
