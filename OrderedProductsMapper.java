package com.orderManagement.mapper;

import com.orderManagement.dto.OrderedProductsDto;
import com.orderManagement.model.OrderedProductsModel;


public class OrderedProductsMapper {

    public static OrderedProductsModel dtoToModel(OrderedProductsDto orderedProductsDto) {

                return OrderedProductsModel.builder()
                        .productQuantity(orderedProductsDto.getProductQuantity())
                        .productPrice(orderedProductsDto.getProductPrice())
                        .productId(orderedProductsDto.getProductId())
                        .productName(orderedProductsDto.getProductName())
                        .orderId(orderedProductsDto.getOrderId())

                        .build();

            }
            public static OrderedProductsDto modelToDto(OrderedProductsModel orderedProductsModel){
        return OrderedProductsDto.builder()
                .productId(orderedProductsModel.getProductId())
                .productName(orderedProductsModel.getProductName())
                .productPrice(orderedProductsModel.getProductPrice())
                .productQuantity(orderedProductsModel.getProductQuantity())
                .orderId(orderedProductsModel.getOrderId())

                .build();
            }

}
