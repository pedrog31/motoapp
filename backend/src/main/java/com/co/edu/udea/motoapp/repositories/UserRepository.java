package com.co.edu.udea.motoapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.co.edu.udea.motoapp.model.User;
import org.bson.types.ObjectId;

public interface UserRepository extends MongoRepository<User, String> {
	User findBy_uid(ObjectId _uid);
}
