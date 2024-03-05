package com.example.order.service.abstraction;


import com.example.order.model.request.CreateOrderRequest;

public interface OrderService {
    void createPayment(CreateOrderRequest request);
}
