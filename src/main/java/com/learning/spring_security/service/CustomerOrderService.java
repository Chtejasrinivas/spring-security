package com.learning.spring_security.service;

import com.learning.spring_security.model.CustomerOrder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerOrderService {


    List<CustomerOrder> customerOrders = new ArrayList<>(List.of(
        new CustomerOrder(1, "ORD001", "Laptop", "John Doe", "TRK123456", "123 Main St, City A"),
        new CustomerOrder(2, "ORD002", "Smartphone", "Jane Smith", "TRK654321", "456 Elm St, City B"),
        new CustomerOrder(3, "ORD003", "Headphones", "Alice Johnson", "TRK789012", "789 Oak St, City C")
    ));

    public List<CustomerOrder> getAllCustomerOrders() {
        return customerOrders;
    }

    public CustomerOrder findByTrackingNumber(String trackingNumber) {
        return customerOrders.stream()
                .filter(order -> order.getTrackingNumber().equals(trackingNumber))
                .findFirst()
                .orElse(null);
    }

    public boolean addCustomerOrder(CustomerOrder customerOrder) {
        return customerOrders.add(customerOrder);
    }
}
