package com.example.demo.controller;



import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dal.entities.Role;
import com.example.demo.dal.entities.User;
import com.example.demo.dal.services.RoleService;
import com.example.demo.dal.services.UserService;

@RestController
@RequestMapping("/role")
@CrossOrigin(origins= {"https://planninghospt.herokuapp.com","http://localhost:4200"})
public class RoleController {
	@Autowired
	private RoleService service;
	@SuppressWarnings("unchecked")
	@GetMapping("")
	public ResponseEntity<List<Role>> getAll(){
		return new ResponseEntity<List<Role>>((List<Role>) service.getAll(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Role>> getById(@PathVariable("id") long id){
		return new ResponseEntity<Optional<Role>>(service.getById(id),HttpStatus.FOUND);
	}
	@PostMapping("")
	public ResponseEntity<Role> create(@Valid @RequestBody Role c){
		return new ResponseEntity<Role>(service.create(c), HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Role> update(@Valid @RequestBody Role c, @PathVariable("id") long id) throws Exception{
		return new ResponseEntity<Role>(service.update(c, id),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id){
		return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.OK);
	}
}