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

import com.co.edu.udea.motoapp.model.Motorcycle;
import com.co.edu.udea.motoapp.model.Response;
import com.co.edu.udea.motoapp.repositories.MotoRepository;

@RestController
@RequestMapping("/motorcycles")
public class MotoController {
	@Autowired
	private MotoRepository repository;

	@CrossOrigin(origins = "*")
	@GetMapping(value = "")
	public List<Motorcycle> getAllMotorcycles() {
		return repository.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/{id}")
	public Motorcycle getMotorcycleById(@PathVariable() ObjectId id) {
		return repository.findById(id);
	}

	@CrossOrigin(origins = "*")
	@PutMapping(value = "")
	public void modifyMotorcycleBId(@Valid @RequestBody Motorcycle motorcycle) {
		repository.save(motorcycle);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "")
	public Motorcycle createMotorcycle(@Valid @RequestBody Motorcycle motorcycle) {
		repository.save(motorcycle);
		return motorcycle;
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/{query}")
	public List<Motorcycle> searchMotorcycles(@PathVariable() String query) {
		return repository.findByNameContainingIgnoreCase(query);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/{id}")
	public Response deleteMotorcycle(@PathVariable() ObjectId id) {
		Response response = new Response();
		Motorcycle motorcycle = repository.findById(id);
		if (motorcycle != null) {
			repository.delete(motorcycle);
			response.setTitle("ok");
			response.setMessage("Motocicleta eliminada");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setTitle("ERROR");
			response.setMessage("Motocicleta no encontrada");
			response.setStatus(HttpStatus.CONFLICT);
		}
		return response;
	}
}
