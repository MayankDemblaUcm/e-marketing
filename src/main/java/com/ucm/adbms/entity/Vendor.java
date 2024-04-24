package com.ucm.adbms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "vendor")
public class Vendor {

    @Id
    private String id;
    private String vendorId;
    private String password;
    private String email;
    private String phoneNumber;

    @DBRef
    private List<Product> products;
    private String createdAt;
    private String updatedAt;
}
