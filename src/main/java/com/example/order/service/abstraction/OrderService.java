package com.example.order.service.abstraction;


import com.example.order.model.request.CreateOrderRequest;
import com.example.order.model.response.OrderResponse;

public interface OrderService {
    void createPayment(CreateOrderRequest request);

    OrderResponse getOrder(Long id);
}
