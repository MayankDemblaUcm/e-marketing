package com.ucm.adbms.repository;

import com.ucm.adbms.entity.Customer;
import com.ucm.adbms.entity.RefundRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends MongoRepository<Customer, String>  {

    Customer findByEmail(String email) ;
}
