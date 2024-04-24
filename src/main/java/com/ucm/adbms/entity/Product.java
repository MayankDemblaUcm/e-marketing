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
@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String productId;
    private String name;
    private String description;

    private String categoryId;

    private String vendorId;

    private String imageurl ;

    @DBRef
    private List<ProductVariant> productVariant;

    @DBRef
    private List<Review> reviews ;

    private boolean isApproved;
    private int averageRating;
    private boolean isAvailable;
    private String createdAt;
    private String updatedAt;
}
