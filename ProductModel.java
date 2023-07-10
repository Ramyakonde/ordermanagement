package com.orderManagement.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_t")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "product_id",nullable = false)
    private Long productId;

    @Column(name = "product_name",nullable = false)
    private String  productName;

    @Column(name = "product_price",nullable = false)
    private float productPrice;
    @Column(name = "product_quantity",nullable = false)
    private Integer productQuantity;
    @Column(name = "product_description",nullable = true)
    private String productDescription;

}
