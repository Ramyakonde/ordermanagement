package com.orderManagement.controller;

import com.orderManagement.dto.CustomerDto;
import com.orderManagement.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
@RequestMapping()
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/customer/getAll")
    public List<CustomerDto> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/customer/get")
    public CustomerDto getCustomer(@RequestParam("customerId") long customerId) {
        return customerService.getCustomer(customerId);
       // return new CustomerDto();
    }
    @PostMapping("/customer/create")
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customer) {
         customerService.createCustomer(customer);
        return  new ResponseEntity<CustomerDto>(customer,HttpStatus.CREATED);
    }
    @PutMapping("/customer/update")
    public CustomerDto updateCustomer(@RequestBody CustomerDto customer) {
        customerService.updateCustomer(customer);
        return new CustomerDto();
    }
    @DeleteMapping("/customer/delete/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);

    }
}
