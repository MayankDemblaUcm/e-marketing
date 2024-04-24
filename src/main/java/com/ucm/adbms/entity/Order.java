package com.ucm.adbms.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "order")
public class Order {

    @Id
    private String id;

    private String customerId;
    private String orderId;

    @DBRef
    private List<Product> products;
    private String status;
    private String paymentStatus;
    private double totalAmount;
    private String address;
    private String createdAt;
    private String updatedAt;


}
