package com.co.edu.udea.motoapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.edu.udea.motoapp.model.Advise;
import com.co.edu.udea.motoapp.repositories.AdviseRepository;

@RestController
@RequestMapping("/trips/advises")
public class AdviseController {
	@Autowired
	private AdviseRepository repository;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<Advise> getAdvisesByTrip(@PathVariable() ObjectId id) {
		return repository.findBy_tripId(id);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/uid={uid}", method = RequestMethod.GET)
	public List<Advise> getAdvisesByUser(@PathVariable() String uid) {
		return repository.findBy_uid(uid);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Advise createAdvise(@Valid @RequestBody Advise advise) {
		repository.save(advise);
		return advise;
	}
}
