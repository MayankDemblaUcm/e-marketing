package com.ucm.adbms.repository;

import com.ucm.adbms.entity.Admin;
import com.ucm.adbms.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

    Category findByName(String name) ;

    Category findByCategoryId(String id) ;

}
