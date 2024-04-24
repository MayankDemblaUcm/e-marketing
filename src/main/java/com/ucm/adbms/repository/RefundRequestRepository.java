package com.ucm.adbms.repository;

import com.ucm.adbms.entity.RefundRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface RefundRequestRepository extends MongoRepository<RefundRequest, String> {
}
