package com.orderManagement.controller;
import com.orderManagement.dto.OrderDto;
import com.orderManagement.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class OrderController {
  @Autowired
  private OrderService orderService;
    @GetMapping("/order/get")
    public OrderDto getOrder(@RequestParam("orderId") Integer orderId) {
        orderService.getOrder(orderId);
        return new OrderDto();
    }
    @PostMapping("/order/create")
    public String createOrderProduct(@RequestBody  OrderDto orderDto){
         return orderService.createOrder(orderDto);
    }
    @PutMapping("/order/update")
    public String updateOrder(@RequestBody OrderDto order) {
           orderService.updateOrder(order);
           return new String();

    }
    @DeleteMapping("/order/delete/{orderId}")
    public String deleteOrder(@PathVariable("orderId") Integer orderId){
        orderService.deleteOrder(orderId);
        return "order is deleted";
    }
    @GetMapping("/order/getAll")
    public List<OrderDto> getAllOrders(){

        return orderService.getAllOrders();
    }

}
