package com.ucm.adbms.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "admin")
public class Admin {

    @Id
    private String _id;

    private String adminId;

    private String name ;
    private String password;
    private String email;
    private String phoneNumber;
    private double commission;

    @DBRef
    private List<VendorRequest> vendor_request;

    @DBRef
    private List<RefundRequest> refund_request;
    private String createdAt;
    private String updatedAt;

}
