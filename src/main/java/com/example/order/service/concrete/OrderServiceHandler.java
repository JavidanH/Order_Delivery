package com.example.order.service.concrete;


import com.example.order.dao.repository.OrderRepository;
import com.example.order.model.request.CreateOrderRequest;
import com.example.order.service.abstraction.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.order.mapper.OrderMapper.ORDER_MAPPER;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceHandler implements OrderService {

    private final OrderRepository orderRepository;
    @Override
    public void createPayment(CreateOrderRequest request) {
        log.info("ActionLog.createOrder.start request: {}", request);
        orderRepository.save(ORDER_MAPPER.buildOrderEntity(request));
        log.info("ActionLog.createOrder.success request: {}", request);
    }
}
