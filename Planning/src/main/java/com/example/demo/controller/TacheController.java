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

import com.example.demo.dal.entities.Tache;
import com.example.demo.dal.services.TacheService;;
@RestController
@RequestMapping("/taches")
@CrossOrigin(origins="http://localhost:4200")
public class TacheController {
	@Autowired
	private TacheService service;
	@SuppressWarnings("unchecked")
	@GetMapping("")
	public ResponseEntity<List<Tache>> getAll(){
		return new ResponseEntity<List<Tache>>((List<Tache>) service.getAll(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Tache>> getById(@PathVariable("id") long id){
		return new ResponseEntity<Optional<Tache>>(service.getById(id),HttpStatus.FOUND);
	}
	@PostMapping("")
	public ResponseEntity<Tache> create(@Valid @RequestBody Tache c){
		return new ResponseEntity<Tache>(service.create(c), HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Tache> update(@Valid @RequestBody Tache c, @PathVariable("id") long id) throws Exception{
		return new ResponseEntity<Tache>(service.update(c, id),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id){
		return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.OK);
	}
}
