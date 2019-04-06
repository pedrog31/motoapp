package com.co.edu.udea.motoapp.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.co.edu.udea.motoapp.model.Motorcycle;

public interface MotoRepository extends MongoRepository<Motorcycle, String> {
	Motorcycle findById(ObjectId id);
	
    public List<Motorcycle> findByNameContainingIgnoreCase(String name);

}
