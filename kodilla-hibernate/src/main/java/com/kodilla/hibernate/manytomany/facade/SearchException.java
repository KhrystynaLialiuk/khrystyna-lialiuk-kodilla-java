package com.kodilla.hibernate.manytomany.facade;

public class SearchException extends Exception {
    public static final String COMPANY_SEARCH_ERR = "No company matches the parameter.";
    public static final String EMPLOYEE_SEARCH_ERR = "No employee matches the parameter.";

    public SearchException(String message) {
        super(message);
    }
}
