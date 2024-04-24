package com.ucm.adbms.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "productvariant")
public class ProductVariant {
    @Id
    private String id;
    private String productId;
    private String name;
    private String description;
    private String color;
    private String size;
    private double MRP;
    private double price;
    private String imageurl ;
    private int quantity;
    private double commission;
    private String createdAt;
    private String updatedAt;
}
