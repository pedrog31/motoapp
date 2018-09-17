package com.co.edu.udea.motoapp.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.co.edu.udea.motoapp.model.Motorcycle;

public interface MotoRepository extends MongoRepository<Motorcycle, String> {
	Motorcycle findBy_id(ObjectId _id);
}
