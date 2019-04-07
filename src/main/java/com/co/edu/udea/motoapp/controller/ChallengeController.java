package com.co.edu.udea.motoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.edu.udea.motoapp.model.Challenge;
import com.co.edu.udea.motoapp.repositories.ChallengeRepository;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {
	
	@Autowired
	private ChallengeRepository challengeRepository;

	@CrossOrigin(origins = "*")
	@GetMapping(value = "")
	public ResponseEntity<List<Challenge>> getAllChallenges() {
		try {
			return new ResponseEntity<>(challengeRepository.findAll(), HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
