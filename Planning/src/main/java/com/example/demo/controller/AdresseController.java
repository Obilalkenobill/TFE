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

import com.example.demo.dal.entities.Patient;
import com.example.demo.dal.services.PatientService;

public class AdresseController {
	@Autowired
	private PatientService service;
	@SuppressWarnings("unchecked")
	@GetMapping("")
	public ResponseEntity<List<Patient>> getAll(){
		return new ResponseEntity<List<Patient>>((List<Patient>) service.getAll(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Patient>> getById(@PathVariable("id") long id){
		return new ResponseEntity<Optional<Patient>>(service.getById(id),HttpStatus.FOUND);
	}
	@PostMapping("")
	public ResponseEntity<Patient> create(@Valid @RequestBody Patient c){
		return new ResponseEntity<Patient>(service.create(c), HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Patient> update(@Valid @RequestBody Patient c, @PathVariable("id") long id) throws Exception{
		return new ResponseEntity<Patient>(service.update(c, id),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id){
		return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.OK);
	}
}
