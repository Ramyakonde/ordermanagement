package com.orderManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "order_products")
public class OrderedProductsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name= "product_id",nullable = false)
    private long productId;
    @Column(name= "order_id",nullable = false)
    private long orderId;
    @Column(name= "product_quantity",nullable = false)
    private int productQuantity;
    @Column(name= "product_price",nullable = false)
    private long productPrice;
    @Column(name= "product_name",nullable = false)
    private String productName;


}

