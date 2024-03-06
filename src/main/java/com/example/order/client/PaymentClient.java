package com.example.order.client;


import com.example.order.model.client.payment.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-payment")
public interface PaymentClient {

    @GetMapping("internal/v1/payments/{id}")
    PaymentResponse getPayment(@PathVariable Long id);
}
