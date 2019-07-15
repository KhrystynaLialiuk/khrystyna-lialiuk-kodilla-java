package com.kodilla.good.patterns.challenges.product_order_service;

public class User {
    private String fullNameOrCompanyTitle;
    private String address;
    private String email;
    private String telephone;

    public User(String fullNameOrCompanyTitle, String address, String email, String telephone) {
        this.fullNameOrCompanyTitle = fullNameOrCompanyTitle;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
    }

    public String getFullNameOrCompanyTitle() {
        return fullNameOrCompanyTitle;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }
}
