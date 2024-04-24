package com.ucm.adbms.service;

import com.ucm.adbms.entity.Product;
import com.ucm.adbms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository ;


    public List<Product> fetchAllProducts(){
       return productRepository.findAll() ;
    }


}
