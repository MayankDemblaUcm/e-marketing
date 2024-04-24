package com.ucm.adbms.repository;

import com.ucm.adbms.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductVariantRepository extends MongoRepository<Product, String> {
}
