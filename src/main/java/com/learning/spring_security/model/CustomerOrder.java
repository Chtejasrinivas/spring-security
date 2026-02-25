package com.learning.spring_security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerOrder {

    private int id;
    private String orderId;
    private String productName;
    private String customerName;
    private String trackingNumber;
    private String deliveryAddress;
}
