package com.learning.spring_security.controller;

import com.learning.spring_security.model.CustomerOrder;
import com.learning.spring_security.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerOrderController {

    private final CustomerOrderService customerOrderService;

    @Autowired
    public CustomerOrderController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    @GetMapping("/orders")
    public List<CustomerOrder> getAllCustomerOrders() {
        return customerOrderService.getAllCustomerOrders();
    }

    @GetMapping("/orders/tracking")
    public CustomerOrder findByTrackingNumber(@RequestParam String trackingNumber) {
        return customerOrderService.findByTrackingNumber(trackingNumber);
    }
}
