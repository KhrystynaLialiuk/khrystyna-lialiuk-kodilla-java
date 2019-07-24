package com.kodilla.good.patterns.challenges.food2door;

import java.util.ArrayList;

public class ManufacturerRepository {
    private ArrayList<Manufacturer> manufacturers = new ArrayList<>();

    public void addManufacturer(Manufacturer manufacturer) {
        manufacturers.add(manufacturer);
    }
}
