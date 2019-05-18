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

import com.example.demo.dal.entities.iTache;
import com.example.demo.dal.services.iTacheService;

@RestController
@RequestMapping("/itaches")
public class iTacheController {
	@Autowired
	private iTacheService service;
	@SuppressWarnings("unchecked")
	@GetMapping("")
	public ResponseEntity<List<iTache>> getAll(){
		return new ResponseEntity<List<iTache>>((List<iTache>) service.getAll(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<iTache>> getById(@PathVariable("id") long id){
		return new ResponseEntity<Optional<iTache>>(service.getById(id),HttpStatus.FOUND);
	}
	@PostMapping("")
	public ResponseEntity<iTache> create(@Valid @RequestBody iTache c){
		return new ResponseEntity<iTache>(service.create(c), HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<iTache> update(@Valid @RequestBody iTache c, @PathVariable("id") long id) throws Exception{
		return new ResponseEntity<iTache>(service.update(c, id),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id){
		return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.OK);
	}
}
