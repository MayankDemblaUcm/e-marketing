package com.ucm.adbms.repository;

import com.ucm.adbms.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
