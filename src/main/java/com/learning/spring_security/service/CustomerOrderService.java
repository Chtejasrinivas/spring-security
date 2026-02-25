package com.learning.spring_security.service;

import com.learning.spring_security.model.CustomerOrder;
import com.learning.spring_security.repo.CustomerOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;

    public CustomerOrderService(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    public List<CustomerOrder> getAllCustomerOrders() {
        return customerOrderRepository.findAll();
    }

    public CustomerOrder findByOrderId(String orderId) {
        return customerOrderRepository.findByOrderId(orderId);
    }

    public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
        return customerOrderRepository.save(customerOrder);
    }
}
