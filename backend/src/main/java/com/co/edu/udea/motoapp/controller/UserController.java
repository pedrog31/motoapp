package com.co.edu.udea.motoapp.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.edu.udea.motoapp.model.User;
import com.co.edu.udea.motoapp.repositories.UserRepository;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserRepository repository;
 
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<User> getAllUsers() {
	return repository.findAll();
  }
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public User getUserByUid(@PathVariable("id") ObjectId id) {
    return repository.findBy_uid(id);
  }
 
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public void modifyUserByUid(@PathVariable("id") ObjectId id, @Valid @RequestBody User user) {
    user.set_uid(id);
    repository.save(user);
  }
 
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public User createUser(@Valid @RequestBody User user) {
    user.set_uid(ObjectId.get());
    repository.save(user);
    return user;
  }
 
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteUser(@PathVariable ObjectId id) {
    repository.delete(repository.findBy_uid(id));
  }
}
