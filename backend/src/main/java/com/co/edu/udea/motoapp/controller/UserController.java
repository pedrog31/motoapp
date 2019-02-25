package com.co.edu.udea.motoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.edu.udea.motoapp.model.User;
import com.co.edu.udea.motoapp.repositories.UserRepository;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository repository;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{uid}", method = RequestMethod.GET)
	public User getUserByUid(@PathVariable() String uid) {
		return repository.findBy_uid(uid);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{uid}", method = RequestMethod.PUT)
	public void modifyUserByUid(@PathVariable() String uid, @Valid @RequestBody User user) {
		user.set_uid(uid);
		repository.save(user);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{uid}", method = RequestMethod.POST)
	public User createUser(@PathVariable() String uid, @Valid @RequestBody User user) {
		user.setTimeStamp((new Date()).getTime());
		user.set_uid(uid);
		repository.save(user);
		return user;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{uid}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable() String uid) {
		repository.delete(repository.findBy_uid(uid));
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/search/{word}", method = RequestMethod.GET)
	public List<User> searchUsers(@PathVariable() String word) {
		return repository.findByNameRegex(word);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/friends/{uid}", method = RequestMethod.GET)
	public Iterable<User> findFriendsBelongToUser(@PathVariable() String uid) {
		User myUser = this.getUserByUid(uid);
		if (myUser.getFriends() != null) {
			return repository.findAllById(myUser.getFriends());
		}
		return new ArrayList<User>();
	}
}
