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

import com.example.demo.dal.entities.Adresse;
import com.example.demo.dal.entities.Patient;
import com.example.demo.dal.services.AdresseService;
import com.example.demo.dal.services.PatientService;
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/adresses")
public class AdresseController {
	@Autowired
	private AdresseService service;
	@SuppressWarnings("unchecked")
	@GetMapping("")
	public ResponseEntity<List<Adresse>> getAll(){
		return new ResponseEntity<List<Adresse>>( (List<Adresse>) service.getAll(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Adresse>> getById(@PathVariable("id") long id){
		return new ResponseEntity<Optional<Adresse>>(service.getById(id),HttpStatus.FOUND);
	}
	@PostMapping("")
	public ResponseEntity<Adresse> create(@Valid @RequestBody Adresse c){
		return new ResponseEntity<Adresse>(service.create(c), HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Adresse> update(@Valid @RequestBody Adresse c, @PathVariable("id") long id) throws Exception{
		return new ResponseEntity<Adresse>(service.update(c, id),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id){
		return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.OK);
	}
}
