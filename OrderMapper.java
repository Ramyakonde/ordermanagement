package com.orderManagement.mapper;

import com.orderManagement.dto.OrderDto;
import com.orderManagement.model.OrderModel;

public class OrderMapper {
    public static OrderModel dtoToModel(OrderDto order){
        return OrderModel.builder()
                .orderId(order.getOrderId())
                .customerId(order.getCustomerId())
                .totalOrderPrice(order.getTotalOrderPrice())
                .build();
    }

    public static OrderDto modelToDto(OrderModel orderModel){
        return OrderDto.builder()
                .orderId(orderModel.getOrderId())
                .customerId(orderModel.getCustomerId())
                .totalOrderPrice(orderModel.getTotalOrderPrice())
                .build();
    }
}
