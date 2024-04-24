package com.ucm.adbms.repository;

import com.ucm.adbms.entity.Order;
import com.ucm.adbms.entity.RefundRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
