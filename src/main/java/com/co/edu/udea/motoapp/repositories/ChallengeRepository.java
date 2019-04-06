package com.co.edu.udea.motoapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.co.edu.udea.motoapp.model.Challenge;

public interface ChallengeRepository extends MongoRepository<Challenge, String> {

}
