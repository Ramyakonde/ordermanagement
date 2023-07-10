package com.orderManagement.mapper;

import com.orderManagement.dto.CustomerDto;
import com.orderManagement.model.CustomerModel;

public  class CustomerMapper {
    public  static CustomerModel dtoToModel(CustomerDto customerDto){

        return CustomerModel.builder()
                .customerId(customerDto.getCustomerId())
                .name(customerDto.getName())
                .emailId(customerDto.getEmailId())
                .phoneNumber(customerDto.getPhoneNumber())
                .addressLine1(customerDto.getAddressLine1())
                .addressLine2(customerDto.getAddressLine2())
                .street(customerDto.getStreet())
                .city(customerDto.getCity())
                .country(customerDto.getCity())
                .pinCode(customerDto.getPinCode())
                .build();

    }

    public static CustomerDto modelToDto(CustomerModel customerModel){
        return CustomerDto.builder()
                .customerId(customerModel.getCustomerId())
                .name(customerModel.getName())
                .emailId(customerModel.getEmailId())
                .phoneNumber(customerModel.getPhoneNumber())
                .addressLine1(customerModel.getAddressLine1())
                .addressLine2(customerModel.getAddressLine2())
                .street(customerModel.getStreet())
                .city(customerModel.getCity())
                .country(customerModel.getCountry())
                .pinCode(customerModel.getPinCode())
                .build();
    }
}
