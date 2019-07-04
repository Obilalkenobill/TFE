package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dal.entities.Heure;
import com.example.demo.dal.entities.User;
import com.example.demo.dal.services.HeureService;
import com.example.demo.dal.services.UserService;
@RestController
@RequestMapping("/user")
@CrossOrigin(origins= {"https://planninghospt.herokuapp.com","http://localhost:4200"})
public class UserController {
	@Autowired
	private UserService service;
	@SuppressWarnings("unchecked")
	@GetMapping("")
	public ResponseEntity<List<User>> getAll(){
		return new ResponseEntity<List<User>>((List<User>) service.getAll(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> getById(@PathVariable("id") long id){
		return new ResponseEntity<Optional<User>>(service.getById(id),HttpStatus.FOUND);
	}
	@PostMapping("")
	public ResponseEntity<User> create(@Valid @RequestBody User c){
		return new ResponseEntity<User>(service.create(c), HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@Valid @RequestBody User c, @PathVariable("id") long id) throws Exception{
		return new ResponseEntity<User>(service.update(c, id),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id){
		return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.OK);
	}
	@GetMapping("/getbyname/{username}")
	public ResponseEntity<UserDetails> getByUsername(@PathVariable("username") String username){
		return new ResponseEntity<UserDetails>(service.loadUserByUsername(username),HttpStatus.FOUND);
	}
}
