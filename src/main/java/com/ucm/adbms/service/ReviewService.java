package com.ucm.adbms.service;

import com.ucm.adbms.entity.Review;
import com.ucm.adbms.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository repository ;


    public List<Review> getReviewsByProductId(String productId){
        return  repository.findByProductId(productId) ;
    }
}
