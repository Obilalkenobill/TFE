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

import com.example.demo.dal.entities.Heure;
import com.example.demo.dal.services.HeureService;


@RestController
@RequestMapping("/heure")
@CrossOrigin(origins= {"https://planninghospt.herokuapp.com","http://localhost:4200"})
public class HeureController {
	@Autowired
	private HeureService service;
	@SuppressWarnings("unchecked")
	@GetMapping("")
	public ResponseEntity<List<Heure>> getAll(){
		return new ResponseEntity<List<Heure>>((List<Heure>) service.getAll(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Heure>> getById(@PathVariable("id") long id){
		return new ResponseEntity<Optional<Heure>>(service.getById(id),HttpStatus.FOUND);
	}
	@PostMapping("")
	public ResponseEntity<Heure> create(@Valid @RequestBody Heure c){
		return new ResponseEntity<Heure>(service.create(c), HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Heure> update(@Valid @RequestBody Heure c, @PathVariable("id") long id) throws Exception{
		return new ResponseEntity<Heure>(service.update(c, id),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id){
		return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.OK);
	}
}
