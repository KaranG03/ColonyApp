package com.karan.property.repository;

import com.karan.property.entity.Plot;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlotRepo extends MongoRepository<Plot, ObjectId> {

}
