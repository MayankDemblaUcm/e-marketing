package com.ucm.adbms.repository;

import com.ucm.adbms.entity.Review;
import com.ucm.adbms.entity.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends MongoRepository<Vendor, String> {

    Vendor findByEmail(String email) ;
}
