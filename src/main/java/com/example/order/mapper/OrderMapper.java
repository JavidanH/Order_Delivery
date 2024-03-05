package com.example.order.mapper;

import com.example.order.dao.entity.OrderEntity;
import com.example.order.model.request.CreateOrderRequest;
import com.example.order.model.response.OrderResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public enum OrderMapper {

    ORDER_MAPPER;

    public OrderEntity buildOrderEntity(CreateOrderRequest orderRequest) {
        return OrderEntity.builder()
                .customerName(orderRequest.getCustomerName())
                .totalAmount(orderRequest.getTotalAmount())
                .build();
    }

    public OrderResponse buildOrderResponse(OrderEntity orderEntity) {
        return OrderResponse.builder()
                .id(orderEntity.getId())
                .customerName(orderEntity.getCustomerName())
                .totalAmount(orderEntity.getTotalAmount())
                .build();
    }

    public List<OrderResponse> buildOrderResponseList(List<OrderEntity> orderEntities) {
        return orderEntities.stream()
                .map(this::buildOrderResponse)
                .collect(Collectors.toList());
    }
}
