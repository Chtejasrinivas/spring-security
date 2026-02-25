package com.learning.spring_security.service;

import com.learning.spring_security.model.CustomerOrder;
import com.learning.spring_security.model.User;
import com.learning.spring_security.model.UserPrincipal;
import com.learning.spring_security.repo.CustomerOrderRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;

    public CustomerOrderService(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    public List<CustomerOrder> getAllCustomerOrdersBasedOnUserNameFromLogin() {

        // Prefer SecurityContextHolder - more reliable than HttpServletRequest.getUserPrincipal()
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof UserPrincipal userPrincipal) {
            User user = userPrincipal.getUser();
//            System.out.println("User ID: " + user.getId());
//            System.out.println("Username: " + user.getUserName());
//            System.out.println("Roles: " + user.getRoles());
//            System.out.println("Authorities: " + auth.getAuthorities());
//            System.out.println("password: " + user.getPassword());
            return customerOrderRepository.findByCustomerName(user.getUserName().toLowerCase());
        }
        return Collections.emptyList();
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
