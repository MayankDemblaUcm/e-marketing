package com.ucm.adbms.repository;

import com.ucm.adbms.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ProductRepository extends MongoRepository<Product, String> {

    Product findByProductId(String id) ;

    List<Product> findByCategoryId(String id) ;
}
