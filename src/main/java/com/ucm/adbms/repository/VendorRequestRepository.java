package com.ucm.adbms.repository;

import com.ucm.adbms.entity.VendorRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface VendorRequestRepository extends MongoRepository<VendorRequest, String>{
}
