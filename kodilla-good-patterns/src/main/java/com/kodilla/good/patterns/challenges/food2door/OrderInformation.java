package com.kodilla.good.patterns.challenges.food2door;

public class OrderInformation {
    public Order retrieve() {
        Manufacturer extraFoodShop = new Manufacturer(111, "ExtraFoodShop",
                "Dluga 2, Warsaw");

        ManufacturerRepository manufacturerRepository = new ManufacturerRepository();
        manufacturerRepository.addManufacturer(extraFoodShop);

        Product product = new Product(1234, "Milk", "Valley", 10);
        extraFoodShop.addProduct(product);

        return new Order(extraFoodShop, 1234, 5);
    }
}
