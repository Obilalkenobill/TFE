package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dal.entities.Infirmier;
import com.example.demo.dal.services.InfirmierService;
@RestController
@RequestMapping("/infirmier")
public class InfirmierController {
	@Autowired
	private InfirmierService service;
	@SuppressWarnings("unchecked")
	@GetMapping("")
	public ResponseEntity<List<Infirmier>> getAll(){
		return new ResponseEntity<List<Infirmier>>((List<Infirmier>) service.getAll(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Infirmier>> getById(@PathVariable("id") long id){
		return new ResponseEntity<Optional<Infirmier>>(service.getById(id),HttpStatus.FOUND);
	}
	@PostMapping("")
	public ResponseEntity<Infirmier> create(@Valid @RequestBody Infirmier c){
		return new ResponseEntity<Infirmier>(service.create(c), HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Infirmier> update(@Valid @RequestBody Infirmier c, @PathVariable("id") long id) throws Exception{
		return new ResponseEntity<Infirmier>(service.update(c, id),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id){
		return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.OK);
	}
}
