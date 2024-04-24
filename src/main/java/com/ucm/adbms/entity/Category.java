package com.ucm.adbms.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "category")
public class Category {

    private String id ;

    private String categoryId ;

    private String name ;

    private String age_group ;

    private String gender ;

    private String type ;

    private String description ;

    private String status ;


    private String createdAt;
    private String updatedAt;



}
