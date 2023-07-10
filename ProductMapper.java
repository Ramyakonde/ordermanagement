package com.orderManagement.mapper;

import com.orderManagement.dto.ProductDto;
import com.orderManagement.model.ProductModel;

public class ProductMapper {
    public static ProductModel dtoToModel(ProductDto productDto){
        return ProductModel.builder()
                .productId(productDto.getProductId())
                .productName(productDto.getProductName())
                .productPrice(productDto.getProductPrice())
                .productQuantity(productDto.getProductQuantity())
                .productDescription(productDto.getProductDescription())
                .build();
            }

    public static ProductDto modelToDto(ProductModel productModel) {
        return ProductDto.builder()
                .productId(productModel.getProductId())
                .productName(productModel.getProductName())
                .productQuantity(productModel.getProductQuantity())
                .productPrice(productModel.getProductPrice())
                .productDescription(productModel.getProductDescription())
                .build();
    }
}
