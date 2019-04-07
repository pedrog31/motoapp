package com.co.edu.udea.motoapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.edu.udea.motoapp.model.Response;
import com.co.edu.udea.motoapp.model.Trip;
import com.co.edu.udea.motoapp.model.User;
import com.co.edu.udea.motoapp.repositories.TripRepository;
import com.co.edu.udea.motoapp.repositories.UserRepository;

@RestController
@RequestMapping("/trips")
public class TripController {
	@Autowired
	private TripRepository repository;
	
	@Autowired
	private UserRepository userRepository;

	@CrossOrigin(origins = "*")
	@GetMapping(value = "")
	public List<Trip> getAllTrips() {
		return repository.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/public")
	public List<Trip> getPublicTrips() {
		return repository.findBytripPublic(true);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/{id}")
	public Trip getTripById(@PathVariable() ObjectId id) {
		return repository.findById(id);
	}

	@CrossOrigin(origins = "*")
	@PutMapping(value = "")
	public void modifyTrip(@Valid @RequestBody Trip trip) {
		repository.save(trip);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/user/{uid}")
	public List<Trip> getTripsBelongToUser(@PathVariable() String uid) {
		return repository.findByUids(uid);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/guest/{uid}")
	public List<Trip> getTripsBelongToGuest(@PathVariable() String uid) {
		return repository.findByGuestUids(uid);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "")
	public Trip createTrip(@Valid @RequestBody Trip trip) {
		trip.setId(new ObjectId());
		repository.save(trip);
		if (!trip.getUids().isEmpty()) {
			User user = userRepository.findByUid(trip.getUids().get(0));
			user.getChallenges().add("TRIP1");
			userRepository.save(user);
		}
		return trip;
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/{id}")
	public Response deleteTrip(@PathVariable() ObjectId id) {
		Response response = new Response();
		Trip trip = repository.findById(id);
		if (trip != null) {
			repository.delete(trip);
			response.setTitle("ok");
			response.setMessage("Ruta eliminada");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setTitle("ERROR");
			response.setMessage("Ruta no encontrada");
			response.setStatus(HttpStatus.CONFLICT);
		}
		return response;
	}
}
