package com.example.order.service.concrete;


import com.example.order.client.PaymentClient;
import com.example.order.dao.entity.OrderEntity;
import com.example.order.dao.repository.OrderRepository;
import com.example.order.exception.NotFoundException;
import com.example.order.model.request.CreateOrderRequest;
import com.example.order.model.response.OrderResponse;
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

    private final PaymentClient paymentClient;
    @Override
    public void createPayment(CreateOrderRequest request) {
        if (paymentClient.getPayment(request.getPaymentId())==null){
            throw new NotFoundException("Payment not found");
        }
        log.info("ActionLog.createOrder.start request: {}", request);
        orderRepository.save(ORDER_MAPPER.buildOrderEntity(request));
        log.info("ActionLog.createOrder.success request: {}", request);
    }

    @Override
    public OrderResponse getOrder(Long id) {
        log.info("ActionLog.createPayment.start request: {}", id);
        var order = fetchOrderIfExist(id);
        return ORDER_MAPPER.buildOrderResponse(order);
    }

    private OrderEntity fetchOrderIfExist(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Payment not found"));
    }

}
