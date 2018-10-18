package com.co.edu.udea.motoapp.controller;

import java.util.ArrayList;
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

import com.co.edu.udea.motoapp.model.Response;
import com.co.edu.udea.motoapp.model.Trip;
import com.co.edu.udea.motoapp.model.User;
import com.co.edu.udea.motoapp.repositories.TripRepository;

@RestController
@RequestMapping("/trips")
public class TripController {
	@Autowired
	private TripRepository repository;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Trip> getAllTrips() {
		return repository.findAll();
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/public", method = RequestMethod.GET)
	public List<Trip> getPublicTrips() {
		return repository.findBytripPublic(true);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Trip getTripById(@PathVariable() ObjectId id) {
		return repository.findBy_id(id);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void modifyTripBId(@Valid @RequestBody Trip trip) {
		repository.save(trip);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/user/{uid}", method = RequestMethod.GET)
	public List<Trip> getTripsBelongToUser(@PathVariable() String uid) {
		return repository.findByUids(uid);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Trip createTrip(@Valid @RequestBody Trip trip) {
		trip.set_id(new ObjectId());
		repository.save(trip);
		return trip;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Response deleteTrip(@PathVariable() ObjectId id) {
		Response response = new Response();
		Trip trip = repository.findBy_id(id);
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
