package com.example.demo.dal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dal.entities.Heure;
import com.example.demo.dal.repo.HeureRepository;
@Service
public class HeureService implements CrudService<Heure, Long>{
@Autowired
private HeureRepository repo;
	@Override
	public Iterable<? extends Heure> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll()	;
	}

	@Override
	public Optional<Heure> getById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Heure create(Heure entity) {
		// TODO Auto-generated method stub
		return repo.save(entity);
	}

	@Override
	public Heure update(Heure entity, Long id) throws Exception {
		// TODO Auto-generated method stub
		Heure h=repo.findById(id).orElseThrow(()-> new Exception("Heure Id Introuvable"));
		if(entity.getNomHeure()!=null) {h.setNomHeure(entity.getNomHeure());}
		return repo.save(h);
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return !repo.existsById(id);
	}

}
