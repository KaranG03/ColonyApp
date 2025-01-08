package com.karan.property.repository;

import com.karan.property.entity.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepo extends MongoRepository<Customer, ObjectId> {

    Customer findBycustName(String name);

}
