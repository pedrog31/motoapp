package com.co.edu.udea.motoapp.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.co.edu.udea.motoapp.model.Advise;

public interface AdviseRepository extends MongoRepository<Advise, String> {
	List<Advise> findByUid(String uid);
	
	List<Advise> findByTripId(ObjectId tripId);
}
