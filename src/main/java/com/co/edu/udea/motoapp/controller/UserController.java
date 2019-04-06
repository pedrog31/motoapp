package com.co.edu.udea.motoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.edu.udea.motoapp.model.User;
import com.co.edu.udea.motoapp.repositories.UserRepository;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository repository;

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/")
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/{uid}")
	public User getUserByUid(@PathVariable() String uid) {
		return repository.findByUid(uid);
	}

	@CrossOrigin(origins = "*")
	@PutMapping(value = "/{uid}")
	public void modifyUserByUid(@PathVariable() String uid, @Valid @RequestBody User user) {
		int number = user.getFriends().size();
		if (number >= 1)
			user.getChallenges().add("FRIENDS1");
		else if (number >= 5)
			user.getChallenges().add("FRIENDS5");
		else if (number >= 10)
			user.getChallenges().add("FRIENDS10");
		number = user.getMotorcycles().size();
		if (number >= 1)
			user.getChallenges().add("MOTO1");
		if (user.getUriPhoto() != null)
			user.getChallenges().add("PHOTO1");
		user.setUid(uid);
		repository.save(user);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/{uid}")
	public User createUser(@PathVariable() String uid, @Valid @RequestBody User user) {
		user.setTimeStamp((new Date()).getTime());
		user.setUid(uid);
		Set<String> a = new HashSet<>();
		a.add("CREATED");
		user.setChallenges(a);
		repository.save(user);
		return user;
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/{uid}")
	public void deleteUser(@PathVariable() String uid) {
		repository.delete(repository.findByUid(uid));
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/search/{word}")
	public List<User> searchUsers(@PathVariable() String word) {
		return repository.findByNameRegex(word);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/friends/{uid}")
	public Iterable<User> findFriendsBelongToUser(@PathVariable() String uid) {
		User myUser = this.getUserByUid(uid);
		if (myUser.getFriends() != null) {
			return repository.findAllById(myUser.getFriends());
		}
		return new ArrayList<>();
	}
}
