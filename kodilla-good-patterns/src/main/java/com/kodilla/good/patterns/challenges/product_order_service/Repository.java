package com.kodilla.good.patterns.challenges.product_order_service;

import java.util.ArrayDeque;

public class Repository {
    private ArrayDeque<Order> ordersQueue = new ArrayDeque<>();

    public ArrayDeque<Order> getOrdersQueue() {
        return ordersQueue;
    }
}
