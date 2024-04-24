package com.ucm.adbms.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "reviews")
public class Review {

    @Id
    private String id;
    private String userId;
    private String productId;
    private int rating;
    private String comment;
    private String attachmentLink;
    private String createdAt;
    private String updatedAt;
}
