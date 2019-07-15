package com.kodilla.good.patterns.challenges.product_order_service;

public class OrderRetriever {
    public Order retrieve() {
        User purchaser = new User("Khrystyna Lialiuk", "Ul. Powstancow 20, Warszawa",
                "k.lialiuk@gmail.com", "506978934");
        LegalEntity providerCorporation = new LegalEntity("WW Distribution Company",
                "ul. Chmielna 20, Warszawa", "wwdistribution@gmail.com", "22555555",
                123456789);
        ElectricalAppliance fridge = new ElectricalAppliance("Refrigerator", "Samsung", "X2",
                "2000 pln", true);
        providerCorporation.add(fridge);
        return new Order(purchaser, providerCorporation, fridge);
    }
}
