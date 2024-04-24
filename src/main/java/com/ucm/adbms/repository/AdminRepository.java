package com.ucm.adbms.repository;

import com.ucm.adbms.entity.Admin;
import com.ucm.adbms.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {

     Admin findByEmail(String email) ;

}
