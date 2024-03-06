package com.example.order.controller;

import com.example.order.model.request.CreateOrderRequest;
import com.example.order.model.response.OrderResponse;
import com.example.order.service.abstraction.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("internal/v1/order")
@RequiredArgsConstructor
public class InternalOrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody CreateOrderRequest request){
        orderService.createPayment(request);
    }

    @GetMapping("/{id}")
    public OrderResponse getOrder(@PathVariable Long id){
        return orderService.getOrder(id);
    }
}
