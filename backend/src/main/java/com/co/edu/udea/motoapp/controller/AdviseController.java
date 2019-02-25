package com.co.edu.udea.motoapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.edu.udea.motoapp.model.Advise;
import com.co.edu.udea.motoapp.model.Response;
import com.co.edu.udea.motoapp.model.Trip;
import com.co.edu.udea.motoapp.repositories.AdviseRepository;
import com.co.edu.udea.motoapp.repositories.TripRepository;

@RestController
@RequestMapping("/trips/advises")
public class AdviseController {
	@Autowired
	private AdviseRepository adviseRepository;
	
	@Autowired
	private TripRepository tripRepository;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/tid={id}", method = RequestMethod.GET)
	public Response getAdvisesByTrip(@PathVariable() String id) {
		Response response = new Response();
		try {
			List<Advise> advices = adviseRepository.findBy_tripId(new ObjectId(id));
			response.setData(advices);
			response.setStatus(HttpStatus.OK);
			return response;
		}catch (Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("The trip does not exist.");
			return response;
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/uid={uid}", method = RequestMethod.GET)
	public Response getAdvisesByUser(@PathVariable() String uid) {
		Response response = new Response();
		try {
			List<Advise> advices = adviseRepository.findBy_uid(uid);
			response.setData(advices);
			response.setStatus(HttpStatus.OK);
			return response;
		}catch (Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("The trip does not exist.");
			return response;
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Advise createAdvise(@Valid @RequestBody Advise advise) {
		adviseRepository.save(advise);
		Trip trip  = tripRepository.findBy_id(advise.get_tripId());
		float score = trip.getScore() * trip.getScoreCount() + advise.getScore();
		trip.setScoreCount(trip.getScoreCount() + 1);
		trip.setScore(score / trip.getScoreCount());
		this.tripRepository.save(trip);
		return advise;
	}
}
