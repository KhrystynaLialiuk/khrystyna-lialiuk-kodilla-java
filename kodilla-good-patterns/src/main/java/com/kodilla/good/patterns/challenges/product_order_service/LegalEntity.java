package com.kodilla.good.patterns.challenges.product_order_service;

import java.util.HashSet;
import java.util.Set;

public class LegalEntity extends User implements Supplier {

    private Integer regon;
    private Set<Product> productsCatalog = new HashSet<>();

    public LegalEntity(String fullNameOrCompanyTitle, String address, String email, String telephone, Integer regon) {
        super(fullNameOrCompanyTitle, address, email, telephone);
        this.regon = regon;
    }

    @Override
    public void add(Product product) {
        productsCatalog.add(product);
    }
}
