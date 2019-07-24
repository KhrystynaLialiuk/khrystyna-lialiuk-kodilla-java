package com.kodilla.good.patterns.challenges.food2door;

public class Order {
    private Manufacturer manufacturer;
    private int productId;
    private int desirableQuantity;

    public Order(Manufacturer manufacturer, int productId, int desirableQuantity) {
        this.manufacturer = manufacturer;
        this.productId = productId;
        this.desirableQuantity = desirableQuantity;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public int getProductId() {
        return productId;
    }

    public int getDesirableQuantity() {
        return desirableQuantity;
    }
}
