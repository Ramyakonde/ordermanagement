package com.orderManagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_t")
public class OrderModel {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   @Column(name = "order_id",nullable = false)
   private long orderId;
   @Column(name = "customer_id",nullable = false)
   private long customerId;
   @Column(name="total_price",nullable = false)
   private double totalOrderPrice;


}
