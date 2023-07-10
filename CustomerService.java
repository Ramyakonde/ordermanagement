package com.orderManagement.services;

import com.orderManagement.dto.CustomerDto;
import com.orderManagement.mapper.CustomerMapper;
import com.orderManagement.model.CustomerModel;
import com.orderManagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public CustomerDto getCustomer(long customerId) {
        Optional<CustomerModel> customerModel = customerRepository.findById(customerId);
        return CustomerMapper.modelToDto(customerModel.get());
    }
    public void createCustomer(CustomerDto customerDto) {
        CustomerModel customerModel = CustomerMapper.dtoToModel(customerDto);
         customerRepository.save(customerModel);
    }
    public void updateCustomer(CustomerDto customerDto) {
        CustomerModel customerModel = CustomerMapper.dtoToModel(customerDto);
        Optional<CustomerModel> existingCustomer = customerRepository.findById(customerDto.getCustomerId());
      if (existingCustomer.isPresent()) {
          CustomerModel model = existingCustomer.get();
                  model.setCustomerId(customerModel.getCustomerId());
                  model.setName(customerModel.getName());
                  model.setEmailId(customerModel.getEmailId());
                  model.setPhoneNumber(customerModel.getPhoneNumber());
                  model.setAddressLine1(customerModel.getAddressLine1());
                  model.setAddressLine2(customerModel.getAddressLine2());
                  model.setStreet(customerModel.getStreet());
                  model.setCity(customerModel.getCity());
                  model.setCountry(customerModel.getCountry());
                  model.setPinCode(customerModel.getPinCode());
         customerRepository.save(model);
      } else{
           customerRepository.save(customerModel);
      }
    }
    public void deleteCustomer(Long customerId) {

        customerRepository.deleteById(customerId);
    }
    public List<CustomerDto> getAllCustomers(){
        List<CustomerModel >customerModels = customerRepository.findAll();
        return customerModels.stream().map(customerModel->CustomerMapper.modelToDto(customerModel)).collect(Collectors.toList());

    }
}
