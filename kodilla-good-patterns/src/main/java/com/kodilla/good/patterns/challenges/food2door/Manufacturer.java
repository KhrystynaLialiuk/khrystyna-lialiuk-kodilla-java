package com.kodilla.good.patterns.challenges.food2door;

import java.util.ArrayList;

public class Manufacturer {
    private int manufacturerId;
    private String manufacturerTitle;
    private String manufacturerAddress;
    private ArrayList<Product> listOfProducts = new ArrayList<>();

    public Manufacturer(int manufacturerId, String manufacturerTitle, String manufacturerAddress) {
        this.manufacturerId = manufacturerId;
        this.manufacturerTitle = manufacturerTitle;
        this.manufacturerAddress = manufacturerAddress;
    }

    public void addProduct(Product product) {
        listOfProducts.add(product);
    }

    public ArrayList<Product> getListOfProducts() {
        return listOfProducts;
    }
}
