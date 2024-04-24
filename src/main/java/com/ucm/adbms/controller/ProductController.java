package com.ucm.adbms.controller;

import com.ucm.adbms.entity.Product;
import com.ucm.adbms.entity.ProductVariant;
import com.ucm.adbms.model.LoginModel;
import com.ucm.adbms.repository.ProductRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@Slf4j
public class ProductController {

    @Autowired
    ProductRepository productRepository ;

    @GetMapping("/productvariant/{id}")
    public ResponseEntity<List<ProductVariant>> loginForm(@PathVariable String id, Model model, HttpSession session) {

        Product product = productRepository.findByProductId(id);

        if (product != null) {
            List<ProductVariant> variants = product.getProductVariant();
            return new ResponseEntity<>(variants, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
