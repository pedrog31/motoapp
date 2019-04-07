package com.co.edu.udea.motoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.edu.udea.motoapp.model.Response;
import com.co.edu.udea.motoapp.repositories.ChallengeRepository;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {
	
	@Autowired
	private ChallengeRepository challengeRepository;

	@CrossOrigin(origins = "*")
	@GetMapping(value = "")
	public Response getAdvisesByTrip(@PathVariable() String id) {
		Response response = new Response();
		try {
			response.setData(challengeRepository.findAll());
			response.setStatus(HttpStatus.OK);
			return response;
		}catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("there are no results.");
			return response;
		}
	}
}
