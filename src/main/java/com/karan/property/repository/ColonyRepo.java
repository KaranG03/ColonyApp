package com.karan.property.repository;

import com.karan.property.entity.Colony;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ColonyRepo extends MongoRepository<Colony, ObjectId> {
    Colony findByname(String name);
}
