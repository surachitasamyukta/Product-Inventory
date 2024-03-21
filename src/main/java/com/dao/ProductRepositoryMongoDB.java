package com.dao;

import com.model.ProductMongoDB;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepositoryMongoDB extends MongoRepository<ProductMongoDB, ObjectId> {

}
