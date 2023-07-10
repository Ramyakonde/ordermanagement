package com.orderManagement.model;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_t")
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "customer_id")
    private Long customerId ;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "email_id",nullable = false)
    private String emailId;
    @Column(name = "phone_number",nullable = false)
    private Long  phoneNumber;
    @Column(name = "address_line1",nullable = false)
    private String addressLine1;
    @Column(name = "address_line2",nullable = true)
    private String addressLine2;
    @Column(name = "street",nullable = false)
    private String street;
    @Column(name = "city",nullable = false)
    private String city;
    @Column(name = "country",nullable = false)
    private String country;
    @Column(name = "pin_code",nullable = false)
    private String pinCode;
}

