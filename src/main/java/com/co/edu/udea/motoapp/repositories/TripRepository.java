package com.co.edu.udea.motoapp.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.co.edu.udea.motoapp.model.Trip;

public interface TripRepository extends MongoRepository<Trip, String> {
	Trip findBy_id(ObjectId _id);
	
	List<Trip> findByName(String name);
	
	List<Trip> findBytripPublic(boolean tripPublic);
	
	List<Trip> findByUids(String uids);
}
