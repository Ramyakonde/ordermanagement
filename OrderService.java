package com.orderManagement.services;

import com.orderManagement.dto.OrderDto;
import com.orderManagement.dto.OrderedProductsDto;
import com.orderManagement.mapper.OrderMapper;
import com.orderManagement.mapper.OrderedProductsMapper;
import com.orderManagement.model.CustomerModel;
import com.orderManagement.model.OrderModel;
import com.orderManagement.model.OrderedProductsModel;
import com.orderManagement.model.ProductModel;
import com.orderManagement.repository.CustomerRepository;
import com.orderManagement.repository.OrderedProductsRepository;
import com.orderManagement.repository.OrderRepository;
import com.orderManagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderedProductsRepository orderedProductsRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public OrderDto getOrder(long orderId) {
        Optional<OrderModel> orderModel = orderRepository.findById(orderId);
        return OrderMapper.modelToDto(orderModel.get());
    }


    public void updateOrder(OrderDto order) {
        OrderModel orderModel = OrderMapper.dtoToModel(order);
        Optional<OrderModel> existingOrder = orderRepository.findById(order.getOrderId());
        if (existingOrder.isPresent()) {
            OrderModel model = existingOrder.get();
            model.setOrderId(orderModel.getOrderId());
            model.setCustomerId(orderModel.getCustomerId());

            orderRepository.save(model);
        } else {
            orderRepository.save(orderModel);
        }
    }

    public void deleteOrder(long orderId) {
        orderRepository.deleteById(orderId);
        orderedProductsRepository.deleteById(orderId);
    }

    public List<OrderDto> getAllOrders() {
        List<OrderModel> orderModelList = orderRepository.findAll();
        return orderModelList.stream().map(orderModel -> OrderMapper.modelToDto(orderModel)).collect(Collectors.toList());
    }

    public String createOrder(OrderDto orderDto) {

        Optional<CustomerModel> existingCustomer = customerRepository.findById(orderDto.getCustomerId());

        if (existingCustomer.isPresent()) {
            List<OrderedProductsDto> orderedProductsDto = orderDto.getOrderedProductsDtoList();
            for (OrderedProductsDto ele : orderedProductsDto
            ) {
                Optional<ProductModel> productModel = productRepository.findById(ele.getProductId());
                boolean b = productModel.get().getProductQuantity() > ele.getProductQuantity();
                if (b) {
                    OrderedProductsModel orderedProductsModel = OrderedProductsMapper.dtoToModel(ele);
                    orderedProductsModel.setOrderId(orderDto.getOrderId());
                    orderedProductsRepository.save(orderedProductsModel);
                }
            } long t = 0;
            for (OrderedProductsDto ele:orderedProductsDto
                 ) {
                t = t + ele.getProductPrice();
            }
                OrderModel orderModel = new OrderModel();
                orderModel.setOrderId(orderDto.getOrderId());
                orderModel.setTotalOrderPrice(t);
                orderModel.setCustomerId(orderDto.getCustomerId());
                orderRepository.save(orderModel);

            return "order placed successfully";

        } else {
            return "not a valid user";


        }





    }}























