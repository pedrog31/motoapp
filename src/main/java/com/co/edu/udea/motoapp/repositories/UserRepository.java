package com.co.edu.udea.motoapp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.co.edu.udea.motoapp.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	User findByUid(String uid);
	
	@Query(value = "{'name': {$regex : ?0, $options: 'i'}}")
	List<User> findByNameRegex(String regexString);
}
