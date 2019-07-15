package com.kodilla.good.patterns.challenges.product_order_service;

public class ElectricalAppliance implements Product {
    private String type;
    private String title;
    private String model;
    private String price;
    private boolean availability;

    public ElectricalAppliance(String type, String title, String model, String price, boolean availability) {
        this.type = type;
        this.title = title;
        this.model = model;
        this.price = price;
        this.availability = availability;
    }

    @Override
    public boolean isAvailable() {
        return availability;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getModel() {
        return model;
    }

    public String getPrice() {
        return price;
    }
}
