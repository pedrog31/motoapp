package com.co.edu.udea.motoapp.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.co.edu.udea.motoapp.model.Advise;

public interface AdviseRepository extends MongoRepository<Advise, String> {
	List<Advise> findBy_uid(String uid);
	
	List<Advise> findBy_tripId(ObjectId _tripId);
}
