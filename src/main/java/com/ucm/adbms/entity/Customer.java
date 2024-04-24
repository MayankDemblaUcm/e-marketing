package com.ucm.adbms.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "customer")
public class Customer {

    @Id
    private String id;

    private String customerId;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @DBRef
    private List<Review> reviews;

    @DBRef
    private List<Order> orders;

    @DBRef
    private List<RefundRequest> refundRequests;


    private String createdAt;
    private String updatedAt;
}
